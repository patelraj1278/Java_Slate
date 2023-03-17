package dsa.searching;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EasyProblems {

    public void findMissingNumber(){
        int arr[] = {1, 2, 4, 6, 3, 8};
        /*Arrays.sort(arr);
        List<Integer> intList = new ArrayList<>();
        for(int i=arr[0]; i<=arr[arr.length-1]; i++){
            if( ((i+1) <= arr.length-1) && arr[i+1]-arr[i] != 1){
                intList.add(arr[i]+1);
            }
        }
        intList.forEach(System.out::println);*/
        Arrays.sort(arr);
        List<Integer> missingElementsList = new ArrayList<>();
        for(int i=0; i< arr.length; i++){
            if( ((i+1) < arr.length) && arr[i+1]-arr[i] != 1){
                missingElementsList.add(arr[i]+1);
            }
        }
        missingElementsList.forEach(System.out::println);
    }

    public int findMissingNumber_exactlyOne(){
        int arr[] = {1, 2, 4, 6, 3, 7, 8};
        Arrays.sort(arr);
        return IntStream.rangeClosed(arr[0],arr[arr.length-1]).sum() - IntStream.of(arr).sum();
    }

    public int findFirstRepeatingElement() {
        int arr[] = {10, 5, 3, 4, 3, 5, 6};
        HashSet<Integer> set = new HashSet<>();
        int flag = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (set.contains(arr[i])) {
                flag = i;
            } else {
                set.add(arr[i]);
            }
            if (flag != -1) {
                System.out.println("Repeated Element Found" + arr[flag]);
            } else {
                System.out.println("Element NOT Found");
            }
        }
        return flag;
    }

    public static void main(String [] args){
        EasyProblems ep = new EasyProblems();
        ep.findMissingNumber();
        //System.out.println(ep.findMissingNumber_1());
        //ep.findFirstRepeatingElement();
    }
}
