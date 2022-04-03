package javaconcepts.shadowing;

//Variable Shadowing
public class JavaHungry
{
    String name = "John";
    int age = 21;

    public void show()
    {
        String name = "Roger";
        int age = 30;
        System.out.println("Name: "+ name);
        System.out.println("Age: "+ age);
        System.out.println("Name: "+ this.name);
        System.out.println("Age: "+ this.age);
    }

    public static void main(String[] args)
    {
        JavaHungry obj = new JavaHungry();
        obj.show();

        //Varible Shadowing
        Test t = new Test();
        System.out.println(t.instanceVar);
        System.out.println(Test.classVar);
        System.out.println(t.getLocalVar());


        //Varible Hiding
        Child obj1 = new Child();
        System.out.println("Value of variable a is: "+obj1.a);
        System.out.println("Value of variable str is: "+obj1.str);

        //Varible Hiding Special Case - The above output has nothing to do with shadowing/hiding. In Java, variables are resolved by the reference type and not the object they are referencing.
        Parent obj2 = new Child();
        System.out.println("Value of variable a is: "+obj2.a);
        System.out.println("Value of variable str is: "+obj2.str);
    }
}

class Test
{
    String instanceVar = "It represents Instance Variable"; // Instance variable
    static String classVar = "It represents Class Variable"; // Class or Static variable
    public String getLocalVar()
    {
        String localVar = "It represents Local Variable";// Local variable
        return localVar;
    }
}


//Variable Hiding
class Parent
{
    int a = 10;
    String str = "Parent Class";
}

class Child extends Parent
{
    int a = 100;
    String str = "Child Class";
}



