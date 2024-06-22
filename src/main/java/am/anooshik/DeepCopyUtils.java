package am.anooshik;
import java.lang.reflect.*;
import java.util.*;

//Identifies the appropriate constructor and uses it to create a new instance of the object.
//Handles primitive types by providing default values for primitive parameters.
//Recursively deep copies fields, lists, sets, maps, and arrays.
public class DeepCopyUtils {
    public static <T> T deepCopy(T original) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        if (original == null) {
            return null;
        }

        Class<?> sourceClass = original.getClass();

        if (sourceClass.isPrimitive() || original instanceof String || original instanceof Number || original instanceof Boolean) {
            return original;
        }

        if (original instanceof List) {
            List<Object> copy = new ArrayList<>();
            for (Object item : (List<Object>) original) {
                copy.add(deepCopy(item));
            }
            return (T) copy;
        }

        if (original instanceof Map) {
            Map<Object, Object> copy = new HashMap<>();
            for (Map.Entry<Object, Object> entry : ((Map<Object, Object>) original).entrySet()) {
                copy.put(deepCopy(entry.getKey()), deepCopy(entry.getValue()));
            }
            return (T) copy;
        }

        if (original instanceof Set) {
            Set<Object> copy = new HashSet<>();
            for (Object item : (Set<Object>) original) {
                copy.add(deepCopy(item));
            }
            return (T) copy;
        }

        if (original.getClass().isArray()) {
            int length = Array.getLength(original);
            Object copy = Array.newInstance(original.getClass().getComponentType(), length);
            for (int i = 0; i < length; i++) {
                Array.set(copy, i, deepCopy(Array.get(original, i)));
            }
            return (T) copy;
        }

        Constructor<?>[] constructors = sourceClass.getDeclaredConstructors();
        Constructor<?> constructor = constructors[0];
        constructor.setAccessible(true);

        // Create new instance using the constructor
        Object[] params = Arrays.stream(constructor.getParameterTypes())
                .map(param -> {
                    if (param.isPrimitive()) {
                        return getPrimitiveDefault(param);
                    } else {
                        return null;
                    }
                })
                .toArray();

        Object copy = constructor.newInstance(params);


        while (sourceClass != null) {
            for (Field field : sourceClass.getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(original);
                field.set(copy, deepCopy(value));
            }
            sourceClass = sourceClass.getSuperclass();
        }

        return (T) copy;
    }
    private static Object getPrimitiveDefault(Class<?> type) {
        if (type == boolean.class) {
            return false;
        } else if (type == byte.class) {
            return (byte) 0;
        } else if (type == char.class) {
            return '\u0000';
        } else if (type == short.class) {
            return (short) 0;
        } else if (type == int.class) {
            return 0;
        } else if (type == long.class) {
            return 0L;
        } else if (type == float.class) {
            return 0.0f;
        } else if (type == double.class) {
            return 0.0;
        } else {
            return null;
        }
    }
}
