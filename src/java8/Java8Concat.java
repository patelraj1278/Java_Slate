package java8;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Concat {

    public void java8Concat(){
        String[] s1 = new String[]{"a", "b", "c"};
        String[] s2 = new String[]{"d", "e", "f"};
        String[] s3 = new String[]{"g", "h", "i"};
        //join object type array
        String[] result = Stream.of(s1, s2, s3).flatMap(Stream::of).toArray(String[]::new);
        System.out.println(Arrays.toString(result));

        int [] int1 = new int[]{1,2,3};
        int[] int2 = new int[]{4,5,6};
        int[] int3 = new int[]{7,8,9};

        //join 2 primitive type array
        int[] result2 = IntStream.concat(Arrays.stream(int1), Arrays.stream(int2)).toArray();

        //join 3 primitive type array, any better idea?
        int[] result3 = IntStream.concat(Arrays.stream(int1),
                IntStream.concat(Arrays.stream(int2), Arrays.stream(int3))).toArray();

        System.out.println(Arrays.toString(result2));

        System.out.println(Arrays.toString(result3));

        String[][] s4 = new String[][]{{"a", "b", "c"},{"a", "b", "c"}};
        String[][] s5 = new String[][]{{"d", "e", "f"},{"d", "e", "f"}};
        String[][] s6 = new String[][]{{"g", "h", "i"},{"d", "e", "f"}};

        Stream.of(s4,s5,s6).flatMap(Stream::of)

                .collect(Collectors.toSet()).forEach(System.out::println);
    }
    public static void main(String[] args) {
        Java8Concat jc = new Java8Concat();
        jc.java8Concat();
    }
}
