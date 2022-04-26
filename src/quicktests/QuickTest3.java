package quicktests;

import java.util.*;
import java.util.function.BinaryOperator;

public class QuickTest3 {

    public void test(int target){
        int[] n = new int[]{3,4,6,7,8,9,1,3};

        for(int i=0; i < n.length; i++){
            for(int j=i+1 ; j < n.length ; j++){
                /*if(n[i] + n[j] == target){
                    System.out.println("Number1 -> :"+ n[i]+ "Number2 -> :"+n[j]);
                }*/
                int distance = target - (n[i] + n[j]);
                if(distance == target){
                    System.out.println("Number1 -> :"+ n[i]+ "Number2 -> :"+n[j]);
                }
            }
        }


        //lst.stream().forEach(System.out::println);
        //lst.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        //lst.stream().reduce(BinaryOperator.maxBy(Comparator.)).get();
    }

//Shared Experience
//Equal
//ArrayList & LinkedList
//Immutability
//Find total problem
//Find closest --> done till distance


    public static void main(String [] args){
        QuickTest3 qt = new QuickTest3();
        qt.test(10);
    }
}
