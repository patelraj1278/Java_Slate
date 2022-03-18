package java8.streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Java 8 – Convert a Stream to Array
public class StreamConvertStreamToArray {

    //1. Stream -> String[]
    public void convertStreamToArray(){
        String lines = "I Love Java 8 Stream!";
        String[] result = Arrays.stream(lines.split("\\s+")).map(String::toUpperCase).toArray(String[]::new);
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

    public static void main(String [] args){
        StreamConvertStreamToArray sc = new StreamConvertStreamToArray();
        sc.convertStreamToArray();
        sc.convertStreamToArray1();
    }
}
