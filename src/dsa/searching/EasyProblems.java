package dsa.searching;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EasyProblems {

    public void findMissingNumber(){
        int arr[] = {1, 2, 4, 6, 3, 8};
        /*Arrays.sort(arr);
        List<Integer> intList = new ArrayList<>();
        for(int i=arr[0]; i<=arr[arr.length-1]; i++){
            if( ((i+1) <= arr.length-1) && arr[i+1]-arr[i] != 1){
                intList.add(arr[i]+1);
            }
        }
        intList.forEach(System.out::println);*/
        Arrays.sort(arr);
        List<Integer> missingElementsList = new ArrayList<>();
        for(int i=0; i< arr.length; i++){
            if( ((i+1) < arr.length) && arr[i+1]-arr[i] != 1){
                missingElementsList.add(arr[i]+1);
            }
        }
        missingElementsList.forEach(System.out::println);
    }

    public int findMissingNumber_exactlyOne(){
        int arr[] = {1, 2, 4, 6, 3, 7, 8};
        Arrays.sort(arr);
        return IntStream.rangeClosed(arr[0],arr[arr.length-1]).sum() - IntStream.of(arr).sum();
    }

    public int findFirstRepeatingElement() {
        int arr[] = {10, 5, 3, 4, 3, 5, 6};
        HashSet<Integer> set = new HashSet<>();
        int flag = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (set.contains(arr[i])) {
                flag = i;
            } else {
                set.add(arr[i]);
            }
            if (flag != -1) {
                System.out.println("Repeated Element Found" + arr[flag]);
            } else {
                System.out.println("Element NOT Found");
            }
        }
        return flag;
    }

    public void findPairWithDiff(int arr[], int diff){
        for(int i=0; i<arr.length;i++){
            for(int j=i+1; j<arr.length;j++){
                    if(Math.abs(arr[i]-arr[j])==diff){
                        System.out.println("Diff Found=>"+arr[i]+"->"+arr[j]);
                    }
            }
        }
    }

    public int[] twoSumClosest(int[] nums,int target){
            Arrays.sort(nums);
            int left = 0;
            int right = nums.length-1;
            int[] result = {-1,-1};
            int diff = Integer.MAX_VALUE;

            while(left < right){
                int sum=nums[left] + nums[right];
                if(Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    result[0] = left;
                    result[1] = right;
                }
                if(sum > target) {
                    right --;
                }else {
                    left ++;
                }
            }
        return result;
    }

    public void threeSortedArr(){
        int ar1[] = {1, 5, 10, 20, 40, 80};
        int ar2[] = {6, 5, 7, 20, 80, 100};
        int ar3[] = {3, 5, 15, 20, 30, 70, 120};

        Integer result =Stream.of(ar1,ar2,ar3)
                .flatMap(x-> Arrays.stream(x).boxed())
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .findFirst().orElse(Map.entry(0,0L)).getKey();
        System.out.println("Common=>"+result);
    }

    public void findIncreaseAndDecrease(){
        int arr[] = {120, 100, 80, 20, 0};
        int result = arr[arr.length-1];
        for(int i=0; i<arr.length; i++){
            if((i+1) < arr.length && arr[i] > arr[i+1]){
                result=arr[i];
                break;
            }
        }
        System.out.println(result);
    }

    public void findFrequencyNDevideK(int arr[],int n , int k){
            int freqCount = Math.round(n/k);
            System.out.println(freqCount);

            Arrays.stream(arr).boxed()
                    .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                    .entrySet().stream()
                    .filter(x->x.getValue() > freqCount)
                    .collect(Collectors.toList())
                    .forEach(System.out::println);

        Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        NavigableMap<String,String> map = new TreeMap<>();
        map.put("1","Raj");
        map.put("2","Ami");
        map.put("3","Heman");
        System.out.println(map.firstEntry());
        System.out.println(map.lastEntry());
        //System.out.println(map.pollFirstEntry());
        //System.out.println(map.pollLastEntry());
        SortedMap<String,String> sMap = map.headMap("Heman");
        sMap.entrySet().forEach(System.out::println);

    }

    public void reverseString(){
        String s = "GeeksQuiz Geeks";
        System.out.println(s);
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != ' '){
                stack.push(s.charAt(i));
            }else{
                while(!stack.isEmpty()){
                    System.out.print(stack.pop());
                }
                System.out.print(" ");
            }

        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }

    public void reverseQueue(){
        Deque<Integer> deque = new ArrayDeque<>();
        int[] arr =  {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        for(int i=0 ; i<arr.length; i++){
            deque.push(arr[i]);
        }
        deque.add(25);
        deque.stream().forEach(System.out::println);
    }

    public void reverseWithStack() {
        Stack<Integer> stack = new Stack<>();
        int[] arr =  {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        for(int i=arr.length-1; i >=0 ; i--){
            stack.push(arr[i]);
        }
        stack.stream().forEach(System.out::println);
    }

    public int twoSumLessThanK(int[] arr, int k){
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
        int i=0;
        int j=arr.length-1;
        int ans=-1;
        while(i < j){
            if(arr[i]+arr[j] >= k){
                System.out.println("Here K=>"+arr[i]+",J=>"+arr[j]);
                j--;
            }else{
                System.out.println("There K=>"+arr[i]+",J=>"+arr[j]);
                ans= Math.max(ans,arr[i]+arr[j]);
                i++;
            }
        }
        return ans;
    }


    public static void main(String [] args){
        EasyProblems ep = new EasyProblems();
        //ep.findMissingNumber();
        //System.out.println(ep.findMissingNumber_1());
        //ep.findFirstRepeatingElement();
        //ep.findPairWithDiff(new int[]{5, 20, 3, 2, 50, 80},78);
        //int[] result = ep.twoSumClosest(new int[]{1, 2, 3, 4, 5},10);
        //Arrays.stream(result).forEach(System.out::println);
        //ep.threeSortedArr();
        //ep.findIncreaseAndDecrease();
        /*int[] arr= {3, 1, 2, 2, 1, 2, 3, 3};
        int n = arr.length;
        int k = 4;
        ep.findFrequencyNDevideK(arr,n,k);*/
        //ep.reverseString();
        //ep.reverseQueue();
        //ep.reverseWithStack();
        int[] arr= {34,23,1,24,75,33,54,8};
        ep.twoSumLessThanK(arr,60);
    }
}
