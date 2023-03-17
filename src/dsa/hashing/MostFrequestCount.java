package dsa.hashing;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MostFrequestCount {

    public int findMostFrequent(int[] arr){

        /*return Arrays.stream(arr).boxed()
                .collect(Collectors.groupingByConcurrent(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .findFirst().orElse(Map.entry(0,0L)).getKey();*/

         return Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                 .collect(Collectors.toList())
                 .stream()
                 .max(Map.Entry.comparingByValue()).get().getKey();
    }

    // Driver program
    public static void main(String[] args) {
        MostFrequestCount mfc = new MostFrequestCount();
        int[] arr = {5,3,1,2,1,4,1,3,3};
        System.out.println(mfc.findMostFrequent(arr));
    }
}
