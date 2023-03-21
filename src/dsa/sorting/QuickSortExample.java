package dsa.sorting;

public class QuickSortExample {

    static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        return -1;
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
        quickSort(arr,0, arr.length-1);
    }
}
