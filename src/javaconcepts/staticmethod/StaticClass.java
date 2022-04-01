package javaconcepts.staticmethod;

public class StaticClass {
    public static void main(String args[]){
        StaticClass.NestedStaticClass ns = new StaticClass.NestedStaticClass();
        System.out.println(ns.getDescription());
    }

    static class NestedStaticClass{
        public String NestedStaticDescription =" Example of Nested Static Class in Java";

        public String getDescription(){
            return NestedStaticDescription;
        }
    }
}
