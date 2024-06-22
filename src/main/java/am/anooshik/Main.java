package am.anooshik;


import am.anooshik.models.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        try{

            // Test Man class
            Man originalMan = new Man("Adam", 30, Arrays.asList("Book1", "Book2"));
            Man copyMan = DeepCopyUtils.deepCopy(originalMan);
            System.out.println("Original Man: " + originalMan);
            System.out.println("Copy Man: " + copyMan);

            // Modify the copy to see if it affects the original
            copyMan.setName("Eve");
            copyMan.setAge(25);
            copyMan.getFavoriteBooks().add("Book3");
            System.out.println("After modification:");
            System.out.println("Original Man: " + originalMan);
            System.out.println("Copy Man: " + copyMan);


        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
}