package java8.streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOfAndArraysConcept {


    //1. Object Arrays
    //For object arrays, both Arrays.stream and Stream.of returns the same output.
    public void streamOfAndArraysConcept1(){
        String[] array = {"a", "b", "c", "d", "e"};

        //Arrays.stream
        Stream<String> stream1 = Arrays.stream(array);
        stream1.forEach(x -> System.out.println(x));

        //Stream.of
        Stream<String> stream2 = Stream.of(array);
        stream2.forEach(x -> System.out.println(x));
    }

    //2. Primitive Arrays
    //For primitive array, the Arrays.stream and Stream.of will return different output.
    public void streamOfAndArraysConcept2(){
        int[] intArray = {1, 2, 3, 4, 5};

        // 1. Arrays.stream -> IntStream
        IntStream intStream1 = Arrays.stream(intArray);
        intStream1.forEach(x -> System.out.println(x));

        // 2. Stream.of -> Stream<int[]>
        Stream<int[]> temp = Stream.of(intArray);
        // Cant print Stream<int[]> directly, convert / flat it to IntStream
        IntStream intStream2 = temp.flatMapToInt(x -> Arrays.stream(x));
        intStream2.forEach(x -> System.out.println(x));

    }
    public static void main(String [] args){
        StreamOfAndArraysConcept sc = new StreamOfAndArraysConcept();
        sc.streamOfAndArraysConcept1();
        sc.streamOfAndArraysConcept2();
    }
}
