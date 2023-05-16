package dsa.searching.linear;

import java.util.*;

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

    public static void reverseString(String s){
        char[] ch = s.toCharArray();
        int left = 0;
        int right = s.length()-1;

        while(left < right){
            char temp= ch[left];
            ch[left]= ch[right];
            ch[right]=temp;
            left++;
            right--;
        }

        System.out.println(new String(ch));
    }

    public static void reverseStringUsingStack(String s){
        Stack<Character> stack = new Stack<>();

        for(int i=0; i < s.length(); i++){
            stack.push(s.charAt(i));
            if(s.charAt(i) == ' '){
                while(stack.isEmpty() == false){
                    System.out.print(stack.pop());
                }
                System.out.print(" ");
            }
        }

        while(stack.isEmpty() == false){
            System.out.print(stack.pop());
        }
    }

    public static void twoSum(){
        int[] dataArr= {1,2,3,4,5};
        int target=6;
        Map<Integer,Integer> iMap = new HashMap<>();
        for(int i=0; i< dataArr.length; i++){
            int diff=target-dataArr[i];
            if(iMap.containsKey(diff)){
                System.out.println("Map Entry ==>"+iMap.get(diff)+"Map Value ==>"+i);
            }
            System.out.println();
            iMap.put(dataArr[i],i);
        }
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            System.out.println(currentSum);
            maxSum = Math.max(maxSum, currentSum);
            //System.out.println(maxSum);
        }
        return maxSum;
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

        String str = "Hello, World!";


        reverseString(str);
        reverseStringUsingStack(str);
        twoSum();

        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int maxSubarraySum = maxSubArray(nums);
        System.out.println("Maximum subarray sum: " + maxSubarraySum);
    }

}
