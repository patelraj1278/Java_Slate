package javaconcepts.exception;

// Overriding when superclass does not throw an exception

//Base class or SuperClass
class Parent {
    //overridden method
    void display() {
        System.out.println("parent method is executed");
    }
}

//Derived class or SubClass
class Child extends Parent {

    //This method overrides the Parent display() method
    //It throws unchecked exception i.e Arithmetic Exception
    @Override
    void display() throws ArithmeticException{
        System.out.println("child method is executed");
    }
}

public class ExceptionExample {
    public static void main(String args[])
    {
        Parent childObject = new Child();
        childObject.display();
    }
}