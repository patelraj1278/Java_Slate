package quicktests;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CodeSignalTest3 {
    static int solution(int[] a, int[] b) {

        Set<Integer> findMax = new HashSet<>();
        int diff = 0;
        for(int i=0 ; i< a.length ; i++){
            for(int j=0 ; j< a.length; j++){
                diff = 0;
                if(j != i){
                    int[] c = Arrays.copyOf(a, a.length);
                    c[i]=a[j];
                    for(int k=0; k < c.length; k++){
                            diff += Math.abs(b[k] - c[k]);
                    }
                    findMax.add(diff);
                }
            }
        }
        //Arrays.stream(a).forEach(System.out::println);
        //findMax.stream().forEach(System.out::println);
        return findMax.stream().reduce(Integer::min).get().intValue();
    }

    public static void main(String args[]){
        CodeSignalTest3 cs = new CodeSignalTest3();
        //int[] a= new int[] {1,3,5,6,2,4,6,2,5,64,74,14,6,8,12,54,76,1,3,5,6,2,4,6,2,5,64,74,14,6,8,12,54,76,1,3,5,6,2,4,6,2,5,64,74,14,6,8,12,54,76};
        //int[] b= new int[] {5,1,3,34,6,7,24,6,7,9,23,5,76,8,2,4,65,1,3,5,6,2,4,6,2,5,64,74,14,6,8,12,54,76,1,3,5,6,2,4,6,2,5,64,74,14,6,8,12,54,76};
        int[] a= new int[] {1,5,8};
        int[] b= new int[] {1,3,5};
        long before = System.currentTimeMillis();
        System.out.println(cs.solution(a,b));
        long after = System.currentTimeMillis();
        System.out.println(after-before);
    }

}

class ArrayDifference {
    public static void main(String args[]){
        //int[] a= new int[] {1,3,5,6,2,4,6,2,5,64,74,14,6,8,12,54,76,1,3,5,6,2,4,6,2,5,64,74,14,6,8,12,54,76,1,3,5,6,2,4,6,2,5,64,74,14,6,8,12,54,76};
        //int[] b= new int[] {5,1,3,34,6,7,24,6,7,9,23,5,76,8,2,4,65,1,3,5,6,2,4,6,2,5,64,74,14,6,8,12,54,76,1,3,5,6,2,4,6,2,5,64,74,14,6,8,12,54,76};
        int[] a= new int[] {1,5,8};
        int[] b= new int[] {1,3,5};

//        System.out.println("Before Current date time in milliseconds : "+new Date().getTime());
        long start1 = System.currentTimeMillis();
        System.out.println(getTheMinimumDifference(a,b));
        long end1 = System.currentTimeMillis();
        System.out.println("Elapsed Time in mulli" +
                " seconds: "+ (end1-start1));
    }

    public static int getTheMinimumDifference(int[] a, int[] b){
        int result=Integer.MAX_VALUE;
        int mainTotal=0;
        if(a.length != b.length)
            return 0;
        int temp[] = new int[a.length];
        for(int i=0;i<b.length;i++){
            temp[i] = Math.abs(a[i] - b[i]);
            mainTotal += temp[i];
        }
        System.out.println(mainTotal);
        for(int i=0;i<a.length;i++){
            int total = Integer.MAX_VALUE;
            for(int j=0;j<a.length;j++) {
                total = Math.min(total,(mainTotal - temp[j])  + Math.abs(a[i] - a[j]));
                System.out.println(total);
            }
            result = Math.min(total,result);
        }
        return result;
    }
}