package dsa.searching.linear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GFG {

    public static int search(int arr[], int x) {
        //Linear Search Approach
        /*for(int i=0; i < arr.length ; i++){
            if(arr[i] == x){
                return x;
            }
        }
        return -1;*/

        //Collection Approach
        if(Arrays.asList(arr).contains(x)){
            return x;
        }else{
            return -1;
        }
    }

    public static int recurssiveSearch(int arr[], int size, int key){
        if(size == 0){
            return -1;
        }
        if(arr[size - 1] == key){
            return size - 1 ;
        }else{
            return recurssiveSearch(arr, size - 1, key);
        }
    }

    public static void main(String [] args){
        int arr[] = { 2, 3, 4, 10, 40 };
        int x = 10;
        int result = search(arr, x);
        if (result == -1)
            System.out.print(
                    "Element is not present in array\n");
        else
            System.out.print("Element is present at index \n"
                    + result);


        int key = 4;

        // Function call to find key
        int index = recurssiveSearch(arr, arr.length, key);
        if (index != -1)
            System.out.println(
                    "The element " + key + " is found at "
                            + index + " index of the given array.\n");
        else
            System.out.println("The element " + key
                    + " is not found.");
    }

}
