package dsa.searching.recurssive;

import java.util.Arrays;
import java.util.Collections;

public class SearchElement {

    public static String findStringUsingRecussriveSearch(String[] arr, int mostLeft, int mostRight, String toFind){
            if (mostRight < mostLeft){
                return "NA";
            }
            if(arr[mostLeft] == toFind){
                return arr[mostLeft];
            }
            if(arr[mostRight] == toFind){
                return arr[mostRight];
            }
        return findStringUsingRecussriveSearch(arr,mostLeft+1,mostRight-1,toFind);
    }

    public static int findIntegerUsingBinarySearch(int[] arr, int mostLeft, int mostRight, int toFind){
        if(mostRight>=mostLeft){
            int mid= mostLeft + (mostRight-mostLeft) / 2;

            if(arr[mid] == toFind){
                return mid;
            }
            if(arr[mid] > toFind){
                return findIntegerUsingBinarySearch(arr,mostLeft,mid-1,toFind);
            }else {
                return findIntegerUsingBinarySearch(arr,mid+1,mostRight,toFind);
            }
        }
        return -1;
    }

    public static int findStringUsingCollectionBinarySearch(String[] arr, String toFind){
            int result = Collections.binarySearch(Arrays.asList(arr),toFind);
            if(result > 0){
                return result;
            }
        return -1;
    }


    public static void main(String [] args){
        String[] str = {"Raj","Ami","Heman","aabc","kfnwe","kwqf","elkfnwel","ejfew"};
        String toFind = "s";
        int mostleft = 0;
        int mostRight = str.length-1;
        //System.out.println(findString(str,mostleft,mostRight,toFind));
        int result = findStringUsingCollectionBinarySearch(str,toFind);
        System.out.println(result);

        int[] arr= {10,3,4,5,6,7};
        Arrays.sort(arr);
        System.out.println(findIntegerUsingBinarySearch(arr,0,arr.length-1,7));


    }
}
