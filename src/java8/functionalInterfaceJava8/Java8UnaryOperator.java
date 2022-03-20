package java8.functionalInterfaceJava8;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Java8UnaryOperator {

    //1.1 In this example, the Function<Integer, Integer> which accepts and returns the same type, can be replaced with UnaryOperator<Integer>.
    public void java8UnaryOperator1(){
        Function<Integer, Integer> func = x -> x * 2;
        Integer result = func.apply(2);
        System.out.println(result);         // 4

        UnaryOperator<Integer> uo = x -> x * 2;
        Integer result2 = func.apply(3);
        System.out.println(result2);
    }

    //UnaryOperator as argument
    public void java8UnaryOperator2(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result = math(list, x -> x * 2);

        System.out.println(result); // [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
    }

    public static <T> List<T> math(List<T> list, UnaryOperator<T> uo){
        List<T> result = new ArrayList<>();
        for (T t : list) {
            result.add(uo.apply(t));
        }
        return result;
    }

    // Chain UnaryOperator
    public void java8UnaryOperator3(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result =math(list,x -> x * 2,x -> x + 1);
        System.out.println(result); // [3, 5, 7, 9, 11, 13, 15, 17, 19, 21]
    }

    public static <T> List<T> math(List<T> list,
                                   UnaryOperator<T> uo, UnaryOperator<T> uo2) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            result.add(uo.andThen(uo2).apply(t));
        }
        return result;
    }



    public static void main(String[] args) {
        Java8UnaryOperator jo = new Java8UnaryOperator();
        jo.java8UnaryOperator1();
        jo.java8UnaryOperator2();
    }
}
