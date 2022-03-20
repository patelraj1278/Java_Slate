package java8.functionalInterfaceJava8.consumerJava8;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerJava8 {

    public void java8Consumer1(){
        Consumer<String> print = x -> System.out.println(x);
        print.accept("Hello");
    }

    public void java8Consumer2(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        // implementation of the Consumer's accept methods.
        Consumer<Integer> consumer = (Integer x) -> System.out.println(x);
        //list.forEach(consumer);
        forEach(list,consumer);
    }

    public void java8Consumer3(){
        List<String> list = Arrays.asList("a", "ab", "abc");
        forEach(list, (String x) -> System.out.println(x.length()));
    }

    static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }

    public static void main(String[] args) {
        ConsumerJava8 cj = new ConsumerJava8();
        cj.java8Consumer1();
        cj.java8Consumer2();
        cj.java8Consumer3();
    }
}
