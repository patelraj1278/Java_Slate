package javaconcepts.interfaceinjava;

interface Printable{
    void print();
}
interface Showable extends Printable{
    void show();
    void print();
}
class TestInterface4 implements Showable{
    public void print(){System.out.println("Hello");}
    public void show(){System.out.println("Welcome");}

    public static void main(String args[]){
        TestInterface4 obj = new TestInterface4();
        obj.print(); //showable overridden print method will be called
        obj.show();
    }
}


//Java 8 Interface added feature
//Java 8 Default Method in Interface
interface Drawable{
    void draw();
    default void msg(){System.out.println("default method");}
}

interface DrawableOverride extends  Drawable{
    default void msg(){System.out.println("default method override");}
}
class Rectangle implements DrawableOverride{
    public void draw(){System.out.println("drawing rectangle");}
}
class TestInterfaceDefault{
    public static void main(String args[]){
        Drawable d=new Rectangle();
        d.draw();
        d.msg();
        DrawableOverride d1 = new Rectangle();
        d1.draw();
        //d1.msg();
    }}

//Java 8 Static Method in Interface
interface Drawable1{
    void draw();
    static int cube(int x){return x*x*x;}
}
class Rectangle1 implements Drawable1{
    public void draw(){System.out.println("drawing rectangle");}
}

class TestInterfaceStatic{
    public static void main(String args[]){
        Drawable1 d=new Rectangle1();
        d.draw();
        System.out.println(Drawable1.cube(3));
    }}