package dsa.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostFrequestCount {

    public int findMostFrequent(int[] arr) {

        /*return Arrays.stream(arr).boxed()
                .collect(Collectors.groupingByConcurrent(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .findFirst().orElse(Map.entry(0,0L)).getKey();*/

         /*return Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                 .max(Map.Entry.comparingByValue()).orElse(Map.entry(0,0L)).getKey();*/

        Map<Integer,Integer> iMap = new HashMap<>();

        for(int i=0; i< arr.length; i++){
            iMap.put(arr[i],iMap.getOrDefault(arr[i],0)+1);
        }
        return iMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(Map.entry(0,0)).getKey();


    }

    // Driver program
    public static void main(String[] args) {
        MostFrequestCount mfc = new MostFrequestCount();
        int[] arr = {5,3,1,2,1,4,1,3,3,3,3};
        System.out.println(mfc.findMostFrequent(arr));
    }
}
