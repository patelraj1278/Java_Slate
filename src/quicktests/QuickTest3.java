package quicktests;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public class QuickTest3 {
    Map<String,Integer> iMap = new HashMap<>();

    public void test(int target){
        int[] n = new int[]{3,4,6,7,8,9,1,3};
        for(int i=0; i < n.length; i++){
            for(int j=i+1 ; j < n.length ; j++){
                /*if(n[i] + n[j] == target){
                    System.out.println("Number1 -> :"+ n[i]+ "Number2 -> :"+n[j]);
                }*/
                int distance = target - (n[i] + n[j]);
                String combo = "No1:"+n[i]+"No2:"+n[j];
                //System.out.println(distance);
                iMap.put(combo,distance);
             }
        }

        int result = iMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .mapToInt(x -> x.getValue())
                .reduce(Integer::min).getAsInt();
        System.out.println(result);

        int max = iMap.entrySet().stream().mapToInt(x -> x.getValue())
                .max().getAsInt();

        int min = iMap.entrySet().stream().mapToInt(x -> x.getValue())
                .min().getAsInt();
        System.out.println("Max:"+max+"Min:"+min);


    }



//Int : 1
//Shared Experience
//Equal
//ArrayList & LinkedList
//Immutability
//Find total problem
//Find closest --> done till distance

//Int : 2
//Hasmap internally works
//Kafka huge traffic to topic - how to resolve
//Functional interface
//Logging & Exception
//Spring vs Spring boot
//Graphl query purpose
//AWS

    public static void main(String [] args){
        QuickTest3 qt = new QuickTest3();
        qt.test(10);
    }
}
