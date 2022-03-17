package java8.streams;

import java.util.stream.Stream;

public class StreamIterate {

    public void streamIterator1(){
        //Stream.iterate(initial value, next value)
        Stream.iterate(0, n -> n + 1)
                .limit(10)
                .forEach(x -> System.out.println(x));

        //1.2 Stream of odd numbers only.
        Stream.iterate(0, n -> n + 1)
                .filter(x -> x % 2 != 0) //odd
                .limit(10)
                .forEach(x -> System.out.println(x));

        //1.3 A classic Fibonacci example.
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(20)
                .map(n -> n[0])
                .forEach(x -> System.out.println(x));


        //1.4 Sum all the Fibonacci values.
        int sum = Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .map(n -> n[0]) // Stream<Integer>
                .mapToInt(n -> n)
                .sum();

        System.out.println("Fibonacci 10 sum : " + sum);
    }
    public static void main(String [] args){
        StreamIterate spm = new StreamIterate();
        spm.streamIterator1();
    }
}
