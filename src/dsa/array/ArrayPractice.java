package dsa.array;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayPractice {

    public int findLargestArray(){
        int arr[] = {10, 4, 3, 50, 23, 90};
        /*Arrays.stream(arr)
                .boxed()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList())
                .forEach(System.out::println);*/

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public int findSecondLargestArray(){
        int arr[] = {10, 4, 3, 61, 23,51, 90};
        /*Integer result = Arrays.stream(arr).boxed()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .min(Comparator.naturalOrder())
                .get();
        */
        int max = Integer.MIN_VALUE;
        int second_max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                second_max=max;
                max = arr[i];
            }else if(arr[i] > second_max){
                second_max=arr[i];
            }
        }
        return second_max;
    }

    public void moveAllZeroToEnd(){
        int arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=arr.length-1; i>=0 ; i--){
            if(arr[i]!=0){
                queue.push(arr[i]);
            }else{
                queue.addLast(arr[i]);
            }
        }
        queue.stream().iterator().forEachRemaining(System.out::println);

        /*for(int i=0; i<arr.length ; i++){
            if(((i+1) < arr.length) && (arr[i]==0 && arr[i+1]!=0)){
                System.out.println("BEFORE=> arr[i]=>"+arr[i]+"arr[i+1]=>"+arr[i+1]);
                    int temp=arr[i+1];
                    arr[i+1]=arr[i];
                    arr[i]=temp;
                System.out.println("AFTER=> arr[i]=>"+arr[i]+"arr[i+1]=>"+arr[i+1]);
            }
        }
        Arrays.stream(arr).forEach(System.out::println);*/
    }

    public static void main(String [] args){
        ArrayPractice ap = new ArrayPractice();
        System.out.println(ap.findLargestArray());
        System.out.println(ap.findSecondLargestArray());
        ap.moveAllZeroToEnd();
    }
}
