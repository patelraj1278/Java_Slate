package javaconcepts.bindings;

import java.util.Collection;
import java.util.HashSet;

public class StaticBindingTest {
    public static void main(String args[])  {
        Collection c = new HashSet();
        StaticBindingTest et = new StaticBindingTest();
        et.sort(c);
        // Creating objects of static inner classes
        // inside main() method
        Superclass A = new Superclass();
        Superclass B = new Subclass();

        // Calling method over above objects
        A.print();
        B.print();
    }

    //overloaded method takes Collection argument
    public Collection sort(Collection c){
        System.out.println("Inside Collection sort method");
        return c;
    }


    //another overloaded method which takes HashSet argument which is sub class
    public Collection sort(HashSet hs){
        System.out.println("Inside HashSet sort method");
        return hs;
    }

    // Static nested inner class
    // Class 1
    public static class Superclass {

        // Method of inner class
        static void print()
        {

            // Print statement
            System.out.println(
                    "print() in superclass is called");
        }
    }

    // Static nested inner class
    // Class 2
    public static class Subclass extends Superclass {

        // Method of inner class
        static void print()
        {

            // print statement
            System.out.println(
                    "print() in subclass is called");
        }
    }

}
