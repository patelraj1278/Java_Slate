package dsa.sorting;

public class bubble {

    void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){

            }
        }

    }

    /* Prints the array */
    void printArray(int arr[]){
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
    }

    // Driver method to test above
    public static void main(String args[])
    {
        bubble ob = new bubble();
        int arr[] = { 5, 1, 4, 2, 8 };
        ob.bubbleSort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);

    }
}
