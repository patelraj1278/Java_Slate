package javaconcepts.bindings;

public class DynamicBindingTest {
    public static void main(String args[]) {
        Vehicle vehicle = new Car(); //here Type is vehicle but object will be Car
        vehicle.start();       //Car's start called because start() is overridden method
    }
}

class Vehicle {

    public void start() {
        System.out.println("Inside start method of Vehicle");
    }
}

class Car extends Vehicle {

    @Override
    public void start() {
        System.out.println("Inside start method of Car");
    }
}

class GFG {

    // Static nested inner class
    // Class 1
    public static class superclass {

        // Method of inner class 1
        void print()
        {

            // Print statement
            System.out.println(
                    "print in superclass is called");
        }
    }

    // Static nested inner class
    // Class 2
    public static class subclass extends superclass {

        // Method of inner class 2
        @Override void print()
        {

            // Print statement
            System.out.println(
                    "print in subclass is called");
        }
    }

    // Method inside main class
    public static void main(String[] args)
    {

        // Creating object of inner class 1
        // with reference to constructor of super class
        superclass A = new superclass();

        // Creating object of inner class 1
        // with reference to constructor of sub class
        superclass B = new subclass();

        // Calling print() method over above objects
        A.print();
        B.print();
    }
}