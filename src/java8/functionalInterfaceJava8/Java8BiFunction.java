package java8.functionalInterfaceJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Java8BiFunction {

    //1.1 This example takes two Integers and returns an Integer, Double or List
    public void java8BiFunction(){

        // takes two Integers and return an Integer
        BiFunction<Integer,Integer,Integer> bfunc = (x,y) -> x + y;
        Integer result = bfunc.apply(1,1);
        System.out.println(result);

        // take two Integers and return an Double
        BiFunction<Integer, Integer, Double> func2 = (x1, x2) -> Math.pow(x1, x2);
        Double result2 = func2.apply(2, 4);
        System.out.println(result2);    // 16.0

        // take two Integers and return a List<Integer>
        BiFunction<Integer, Integer, List<Integer>> func3 = (x1, x2) -> Arrays.asList(x1 + x2);
        List<Integer> result3 = func3.apply(2, 3);
        System.out.println(result3);

    }

    //2.1 This BiFunction takes two Integer and returns a Double, and uses andThen() to chain it with a Function to convert the Double into a String.
    public void java8BiFunction2(){
        BiFunction<Integer,Integer,Double> biFunc = (i1,i2) -> Math.pow(i1, i2);
        Function<Double,String> func =  d -> String.valueOf(d);

        String s = biFunc.andThen(func).apply(2,4);
        System.out.println("Result"+s);
    }

    //2.2 This example converts the above program into a method that accepts
    // BiFunction and Function as arguments and chains it together.
    public void java8BiFunction3(){
        BiFunction<Integer,Integer,Double> biFunc = (i1,i2) -> Math.pow(i1, i2);
        Function<Double,String> func =  d -> String.valueOf(d);
        System.out.println(powString(2,4,biFunc,func));

        BiFunction<String,String,String> biFunc1 = (i1,i2) -> i1.replace(i1,i2);
        Function<String,String> func1 =  d -> String.valueOf(d);
        System.out.println(genericMethod("Raj","Patel",biFunc1,func1));
    }

    //A lot of possibilities in this generic method, Lets Explore
    public void java8BiFunction4(){
        // Take two Integers, pow it into a Double, convert Double into a String.
        String result = genericMethod(2, 4,
                (a1, a2) -> Math.pow(a1, a2),
                (r) -> "Pow : " + String.valueOf(r));

        System.out.println(result);     // Pow : 16.0

        // Take two Integers, multiply into an Integer, convert Integer into a String.
        String result2 = genericMethod(2, 4,
                (a1, a2) -> a1 * a1,
                (r) -> "Multiply : " + String.valueOf(r));

        System.out.println(result2);    // Multiply : 4

        // Take two Strings, join both, join "cde"
        String result3 = genericMethod("a", "b",
                (a1, a2) -> a1 + a2,
                (r) -> r + "cde");      // abcde

        System.out.println(result3);

        // Take two Strings, join both, convert it into an Integer
        Integer result4 = genericMethod("100", "200",
                (a1, a2) -> a1 + a2,
                (r) -> Integer.valueOf(r));

        System.out.println(result4);    // 100200
    }

    //3.1 This example uses BiFunction to create an object, acts as a factory pattern.
    //The GPS::new calls the following constructor, which accepts two arguments and return an object (GPS), so it matches with the BiFunction signature.
    public void java8FactoryBiFunction5(){
        GPS obj = factory("40.741895", "-73.989308",GPS::new);
        System.out.println(obj);
    }

    //4.1 Filtering a List by some conditions.
    public void java8BiFunction6(){
        List<String> list = Arrays.asList("node", "c++", "java", "javascript");
        List<String> result = filterList(list, 3, this::filterByLength);
        System.out.println(result);   // [node, java, javascript]


        List<String> result1 = filterList(list, 3, (l1, size) -> {
            if (l1.length() > size) {
                return l1;
            } else {
                return null;
            }
        });

        System.out.println(result1);  // [node, java, javascript]

        List<String> result2 = filterList(list, "c", (l1, condition) -> {
            if (l1.startsWith(condition)) {
                return l1;
            } else {
                return null;
            }
        });

        System.out.println(result2);  // [c++]

        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> result3 = filterList(number, 2, (l1, condition) -> {
            if (l1 % condition == 0) {
                return l1;
            } else {
                return null;
            }
        });

        System.out.println(result3);  // [2, 4]

    }

    public static <R extends GPS> R factory(String Latitude, String Longitude,BiFunction<String, String, R> func){
        return func.apply(Latitude, Longitude);
    }

    public static <R> R powString(Integer i1 , Integer i2,  BiFunction<Integer,Integer,Double> biFunc,Function<Double,R> func){
        return biFunc.andThen(func).apply(i1,i2);
    }

    public static <A1, A2, R1, R2> R2 genericMethod(A1 a1, A2 a2,
                                              BiFunction<A1, A2, R1> func,
                                              Function<R1, R2> func2) {

        return func.andThen(func2).apply(a1, a2);

    }

    public String filterByLength(String str, Integer size) {
        if (str.length() > size) {
            return str;
        } else {
            return null;
        }
    }

    public <T, U, R> List<R> filterList(List<T> list1, U condition,
                                        BiFunction<T, U, R> func) {

        List<R> result = new ArrayList<>();

        for (T t : list1) {
            R apply = func.apply(t, condition);
            if (apply != null) {
                result.add(apply);
            }
        }

        return result;

    }

    public static void main(String [] args){
        Java8BiFunction jf = new Java8BiFunction();
        jf.java8BiFunction();
        jf.java8BiFunction2();
        jf.java8BiFunction3();
        jf.java8BiFunction4();
        jf.java8FactoryBiFunction5();
        jf.java8BiFunction6();
    }
}
