package dsa.searching.recurssive;

import java.util.*;
import java.util.stream.Collectors;

public class SearchElement {

    public static String findStringUsingRecussriveSearch(String[] arr, int mostLeft, int mostRight, String toFind){
            if (mostRight < mostLeft){
                return "NA";
            }
            if(Objects.equals(arr[mostLeft], toFind)){
                return arr[mostLeft];
            }
            if(Objects.equals(arr[mostRight], toFind)){
                return arr[mostRight];
            }
        return findStringUsingRecussriveSearch(arr,mostLeft+1,mostRight-1,toFind);
    }

    public static int findIntegerUsingRecussriveSearch(int[] arr,int mostLeft, int mostRight,int toFind){
            if(mostRight < mostLeft){
                return -1;
            }

            if(arr[mostLeft] == toFind){
                return mostLeft;
            }
            if(arr[mostRight] == toFind){
                return mostRight;
            }
        return findIntegerUsingRecussriveSearch(arr,mostLeft+1,mostRight-1,toFind);
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

    static void findMissingNumber1(int[] arr){
       int diff=arr[0]-0;
       for(int i=0; i<arr.length; i++){
           if(arr[i] - i != diff){
               while(diff < arr[i] - i){
                    System.out.println(i+diff);
                    diff++;
               }
           }
       }
    }

    //Not Working
    static void findMissingNumber(int[] arr){
        List<Integer> missingNumbers = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        for (int i = 1; i <= Arrays.stream(arr).max().getAsInt(); i++) {
            if (!set.contains(i)) {
                missingNumbers.add(i);
            }
        }
        missingNumbers.forEach(System.out::println);
    }


    public static void main(String [] args){
        /*String[] str = {"Raj","Ami","Heman","aabc","kfnwe","kwqf","elkfnwel","ejfew"};
        String toFind = "s";
        int mostleft = 0;
        int mostRight = str.length-1;
        //System.out.println(findString(str,mostleft,mostRight,toFind));
        int result = findStringUsingCollectionBinarySearch(str,toFind);
        System.out.println(result);

        int[] arr= {10,3,4,5,6,7};
        Arrays.sort(arr);
        System.out.println(findIntegerUsingBinarySearch(arr,0,arr.length-1,7));
        System.out.println(findIntegerUsingRecussriveSearch(arr,0,arr.length-1,11));*/

        /*int[] arr1= {10,3,4,5,6,7};
        int low = 0;
        int high = arr1.length-1;
        Arrays.sort(arr1);
        findMissingNumber(arr1);*/
        int[] arr1= {10,3,4,5,6,7};
        Arrays.sort(arr1);
        findMissingNumber1(arr1);
    }
}
