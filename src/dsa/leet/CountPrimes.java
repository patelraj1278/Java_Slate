package dsa.leet;

import java.util.Arrays;

public class CountPrimes {
    public static int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        int[] nums = new int[n];
        populateSieveArray(nums);
        return (int) Arrays.stream(nums).boxed().filter(e -> e != -1).count();
    }

    private static void populateSieveArray(int[] nums) {
        Arrays.fill(nums, 0, 2, -1);
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != -1) {
                for (int j = i + i; j < nums.length; j += i) {
                    nums[j] = -1;
                }
            }
        }
    }
    public static void main(String [] args){
        countPrimes(2);
    }
}
