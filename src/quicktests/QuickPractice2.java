package quicktests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickPractice2 {
    public static void main(String [] args){
        Integer[] intArray = {1,2,3,4,5};
        List<Integer> listArray = new ArrayList(Arrays.stream(intArray).toList());

        List<Integer> listArray1 =  Arrays.stream(intArray).mapToInt(x -> x.intValue()).boxed().collect(Collectors.toList());

        listArray1.forEach(System.out::println);

        listArray1.stream().mapToInt(x -> x.shortValue()).boxed().collect(Collectors.toList());


    }
}
