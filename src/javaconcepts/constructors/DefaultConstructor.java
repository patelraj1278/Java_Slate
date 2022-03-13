package javaconcepts.constructors;

public class DefaultConstructor {
    public static void main(String[] args) {
        C c = new C(8);
        C c1 = new C();
    }
}

class A{
    A(){
        System.out.println("concepts.A()");
    }
}

class B extends A{
    B(){
        System.out.println("concepts.B()");
    }
}

class C extends B{
    C(){
        System.out.println("concepts.C()");
    }
    C(int i){
        System.out.println("<------>"+i);
    }
}