package dsa.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class QuickSortExample {

    static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    static void quickSort(int[] arr, int low, int high){
            if(low < high){
                int pi = partition(arr,low,high);
                quickSort(arr,low,pi-1);
                quickSort(arr,pi+1,high);
            }

    }
    public static void main(String [] args){
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        System.out.println("Unsorted array: " + Arrays.toString(arr));
        quickSort(arr,0, arr.length-1);
        System.out.println("Sorted array: " + Arrays.toString(arr));

        String[] arr1 = {"banana", "apple", "orange", "grape"};
        System.out.println("Unsorted array: " + Arrays.toString(arr1));
        Arrays.sort(arr1, new StringLengthComparator());
        System.out.println("Sorted array: " + Arrays.toString(arr1));
    }
}

class StringLengthComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }
}
