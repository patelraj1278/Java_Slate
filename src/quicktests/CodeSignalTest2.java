package quicktests;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class CodeSignalTest2 {
    long[] solution(int[] arr, int[][] queries) {
        long[] b = new long[queries.length];
        List<Integer> lstInt = new LinkedList<>();
        for(int p=0 ; p< queries.length; p++){
            //lstInt.add(queries[p]);
        }
        printCombination(arr,arr.length,queries.length);
        //lstInt.stream().forEach(System.out::println);
        return new long[]{1,0,0};
    }

    static void combinationUtil(int arr[], int n, int r, int index,
                                int data[], int i)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            for (int j=0; j<r; j++)
                System.out.print(data[j]+" ");
                System.out.println("");
            return;
        }

        // When no more elements are there to put in data[]
        if (i >= n)
            return;

        // current is included, put next at next location
        data[index] = arr[i];
        combinationUtil(arr, n, r, index+1, data, i+1);

        // current is excluded, replace it with next (Note that
        // i+1 is passed, but index is not changed)
        combinationUtil(arr, n, r, index, data, i+1);
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static void printCombination(int arr[], int n, int r)
    {
        // A temporary array to store all combination one by one
        int data[]=new int[r];

        // Print all combination using temporary array 'data[]'
        combinationUtil(arr, n, r, 0, data, 0);
    }

    public static void main(String [] args){
        CodeSignalTest2 cs = new CodeSignalTest2();
        int[] arr = new int[]{1,2,3,4,5};
        int[][] queries = new int[][]{{1, 2, 4}, {2, 4, 3},{1, 1, 1}};
        cs.solution(arr,queries);
    }
}


