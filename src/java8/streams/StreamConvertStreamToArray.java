package java8.streams;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Java 8 – Convert a Stream to Array
public class StreamConvertStreamToArray {

    //1. Stream -> String[]
    public void convertStreamToArray(){
        String lines = "I Love Java 8 Stream!";
        String[] result = Arrays.stream(lines.split("\\s+"))
                .map(String::toUpperCase).toArray(String[]::new);
        for (String s : result) {
            System.out.println(s);
        }
    }

    //2. IntStream -> Integer[] or int[]
    public void convertStreamToArray1(){
        int[] num = {1, 2, 3, 4, 5};
        Integer[] result = Arrays.stream(num).map(x -> x * 2).boxed().toArray(Integer[]::new);
        for (Integer s : result) {
            System.out.println(s);
        }

        //2.2 Stream to int[]
        // IntStream -> int[]
        int[] stream1 = IntStream.rangeClosed(1, 5).toArray();
        System.out.println(Arrays.toString(stream1));

        // Stream<Integer> -> int[]
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5);
        int[] result1 = stream2.mapToInt(x -> x).toArray();
        System.out.println(Arrays.toString(result1));
    }

    //The key is boxed() the IntStream into a Stream<Integer>, then only convert to an Array.
    public void convertIntArrayToIntegerArray(){
        int[] num = {3, 4, 5};

        //1. int[] -> IntStream
        IntStream stream = Arrays.stream(num);

        //2. IntStream -> Stream<Integer>
        Stream<Integer> boxed = stream.boxed();

        //3. Stream<Integer> -> Integer[]
        Integer[] result =boxed.toArray(Integer[]::new);
        System.out.println(Arrays.toString(result));

        // one line
        Integer[] oneLineResult = Arrays.stream(num).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(oneLineResult));
    }

    public void covertIntStreamToIntArray(){
        int[] num = {1, 2, 3, 4, 5};
        //1. int[] -> IntStream
        IntStream stream = Arrays.stream(num);

        // 2. OptionalInt
        OptionalInt first = stream.findFirst();

        // 3. getAsInt()
        int result = first.getAsInt();

        System.out.println(result);                                     // 1

        // one line
        System.out.println(Arrays.stream(num).findFirst().getAsInt());  // 1


        int[] num1 = {1, 2, 3, 4, 5};

        //1. int[] -> IntStream
        IntStream stream1 = Arrays.stream(num1);

        // 2. OptionalInt
        OptionalInt any1 = stream1.filter(x -> x % 2 == 0).findAny();

        // 3. getAsInt()
        int result1 = any1.getAsInt();

        System.out.println(result1); // 2 or 4


        int[] num2 = {1, 2, 3, 4, 5};

        IntStream stream2 = Arrays.stream(num2);

        // IntStream -> int[]
        int[] ints = stream2.toArray();

        IntStream stream3 = Arrays.stream(num2);

        // IntStream -> Integer[]
        Integer[] integers = stream3.boxed().toArray(Integer[]::new);

    }

    public static void main(String [] args){
        StreamConvertStreamToArray sc = new StreamConvertStreamToArray();
        sc.convertStreamToArray();
        sc.convertStreamToArray1();
        sc.convertIntArrayToIntegerArray();
    }
}
