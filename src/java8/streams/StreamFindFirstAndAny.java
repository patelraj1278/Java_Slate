package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamFindFirstAndAny {

    //1.1 Find the first element from a Stream of Integers.
    public void streamFindFirstAndAny() {
        List<Integer> list = Arrays.asList(1, 2, 3, 2, 1);

        Optional<Integer> first = list.stream().findFirst();
        if (first.isPresent()) {
            Integer result = first.get();
            System.out.println(result);       // 1
        } else {
            System.out.println("no value?");
        }


        Optional<Integer> first2 = list
                .stream()
                .filter(x -> x > 1).findFirst();

        if (first2.isPresent()) {
            System.out.println(first2.get()); // 2
        } else {
            System.out.println("no value?");

        }
    }

    //1.2 Find the first element from a Stream of String which is not equal to "node".
    public void java8FindFirstExample2(){
        List<String> list = Arrays.asList("node", "java", "python", "ruby");

        Optional<String> result = list.stream()
                .filter(x -> !x.equalsIgnoreCase("node"))
                .findFirst();

        if (result.isPresent()) {
            System.out.println(result.get()); // java
        } else {
            System.out.println("no value?");
        }

    }

    /*
    2. findAny()
        2.1 Find any element from a Stream of Integers.
        If we run the below program, most of the time, the result is 2, it looks like findAny()
        always returns the first element? But, there is no guaranteed for this, findAny()
        may return any element from a Stream.
     */
    public void findAnyExample(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> any = list.stream().filter(x -> x > 1).findAny();
        if (any.isPresent()) {
            Integer result = any.get();
            System.out.println(result);
        }

    }
    public static void main(String[] args){
        StreamFindFirstAndAny sf = new StreamFindFirstAndAny();
        sf.streamFindFirstAndAny();
        sf.java8FindFirstExample2();
        sf.findAnyExample();
    }
}
