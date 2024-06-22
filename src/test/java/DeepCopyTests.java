import am.anooshik.DeepCopyUtils;
import am.anooshik.models.*;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DeepCopyTests {
    Man originalMan;
    Book originalBook;
    Library originalLibrary;
    Employee originalEmployee;

    @Before
    public void setup() {
        // Create material
        originalMan = new Man("Adam", 30, Arrays.asList("Book1", "Book2"));
        originalBook = new Book("1984", "George Orwell");
        originalLibrary = new Library("City Library", Arrays.asList(originalBook));
        originalEmployee = new Employee("Alice", 123, 50000.0, originalLibrary);

    }

    @Test
    // Copies Man Successfully
    public void successfulManDeepCopy() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Man copyMan = DeepCopyUtils.deepCopy(originalMan);
        copyMan.setName("Eve");
        copyMan.setAge(25);
        copyMan.getFavoriteBooks().add("Book3");
        assertEquals("Adam", originalMan.getName());
        assertEquals("Eve", copyMan.getName());
        assertEquals(2, originalMan.getFavoriteBooks().size());
        assertEquals(3, copyMan.getFavoriteBooks().size());

    }

    @Test
    // Copies Book Successfully
    public void successfulBookDeepCopy() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Book copyBook = DeepCopyUtils.deepCopy(originalBook);
        copyBook.setTitle("Animal Farm");
        assertEquals("1984", originalBook.getTitle());
        assertEquals("Animal Farm", copyBook.getTitle());

        assertEquals(originalBook.getAuthor(), copyBook.getAuthor());

    }


    @Test
    // Copies Library Successfully
    public void successfulLibraryDeepCopy() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Library copyLibrary = DeepCopyUtils.deepCopy(originalLibrary);
        copyLibrary.setName("Another Library");
        assertEquals("City Library", originalLibrary.getName());
        assertEquals("Another Library", copyLibrary.getName());

    }

    @Test
    // Copies Employee Successfully
    public void successfulEmployeeDeepCopy() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Employee copyEmployee = DeepCopyUtils.deepCopy(originalEmployee);

        copyEmployee.setName("Bob");
        copyEmployee.setId(456);
        copyEmployee.setSalary(60000.0);
        copyEmployee.getLibrary().setName("University Library");

        assertEquals("Alice", originalEmployee.getName());
        assertEquals("Bob", copyEmployee.getName());

        assertEquals(123, originalEmployee.getId());
        assertEquals(456, copyEmployee.getId());

        assertEquals("50000.0", originalEmployee.getSalary().toString());
        assertEquals("60000.0", copyEmployee.getSalary().toString());

        assertEquals("City Library",  originalEmployee.getLibrary().getName());
        assertEquals("University Library", copyEmployee.getLibrary().getName());

    }

}
