package java8.functionJava8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

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
    public static void main(String [] args){
        Java8BiFunction jf = new Java8BiFunction();
        jf.java8BiFunction();
    }
}
