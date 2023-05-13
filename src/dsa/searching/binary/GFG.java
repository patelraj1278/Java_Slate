package dsa.searching.binary;

import java.util.Arrays;

public class GFG {

    static int binaryRecurrsiveSearch(int arr[], int low, int high, int key) {
            if(high >= 1){
                 int mid = low + (high - 1) / 2;
                 if(arr[mid] == key){
                        System.out.println("Key Fonund");
                        return mid;
                 }
                 if(arr[mid] > key) {
                     return binaryRecurrsiveSearch(arr,low, mid - 1 , key);
                 }
                 return binaryRecurrsiveSearch(arr,mid + 1, high , key);
            }
        return -1;
    }

    static int binaryLinerSearch(int[] arr , int key){
             int low = 0;
             int high= arr.length -1 ;
            while(low <= high){
                int mid = low + (high - 1) / 2;
                if(arr[mid] == key){
                    return mid;
                }
                if(arr[mid] < key){
                    low = mid + 1; //searching towards Right side since Key is greater than Mid
                }else{
                    high = mid - 1; //seaching towards Left Side since Key is Less than Mid
                }
            }
           return -1;
    }
    public static void main(String [] args){
        int v[]={3, 1, 4, 5, 6};
        /*int result = binaryRecurrsiveSearch(Arrays.stream(v).sorted().toArray(),0, v.length - 1, 3);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index "
                    + result);*/

        int result1 = binaryLinerSearch(Arrays.stream(v).sorted().toArray(),3);
        if (result1 == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index "
                    + result1);

    }
}
