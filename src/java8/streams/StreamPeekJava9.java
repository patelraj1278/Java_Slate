package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPeekJava9 {

    //However, for Java 9 and above, the peek() may print nothing:
    public void streamPeekJava1(){
        List<String> l = Arrays.asList("A", "B", "C", "D");
        long count = l.stream().peek(System.out::println).count();
        System.out.println(count); // 4


        /*
        An implementation may choose to not execute the stream pipeline (either sequentially or in parallel)
        if it is capable of computing the count directly from the stream source.
        In such cases no source elements will be traversed and no intermediate operations will be evaluated.
        Since Java 9, if JDK compiler is able computing the count directly from the stream (optimization in Java 9), it didn’t traverse the stream, so there is no need to run peek() at all.

	    List<String> l = Arrays.asList("A", "B", "C", "D");
	    // JDK compiler know the size of the stream via the variable l
	    long count = l.stream().peek(System.out::println).count();
         */
        //To force the peek() to run, just alter some elements with filter() or switch to another terminal operation like collect()
        List<String> l1 = Arrays.asList("A", "B", "C", "D");
        long count1 = l1.stream()
                .filter(x->!x.isEmpty())
                .peek(System.out::println)
                .count();

        System.out.println(count1); // 4


        //Or to Print Peek
        List<String> l2 = Arrays.asList("A", "B", "C", "D");

        List<String> result = l2.stream()
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println(result.size());
    }

    public static void main(String[] args){
        StreamPeekJava9 sp = new StreamPeekJava9();
        sp.streamPeekJava1();
    }
}
