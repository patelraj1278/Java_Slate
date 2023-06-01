package dsa.leet;

public class ArrayPartition {
    public static int arrayPairSum(int[] nums) {
        int[] counter = new int[20001];
        for (int num : nums) {
            counter[num + 10000]++;
        }
        int sum = 0;
        boolean pickFirst = true;
        for (int i = 0; i < counter.length; i++) {
            while (counter[i] > 0) {
                if (pickFirst) {
                    sum += i - 10000;
                }
                pickFirst = !pickFirst;
                counter[i]--;
            }
        }
        return sum;
    }
    public static void main(String [] args){
        System.out.println(arrayPairSum(new int[] {1,4,5,6,2}));
    }
}
