package quicktests;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CodeSignalTest3 {
    int solution(int[] a, int[] b) {

        Set<Integer> findMax = new HashSet<>();
        int diff = 0;
        for(int i=0 ; i< a.length ; i++){
            for(int j=0 ; j< a.length; j++){
                diff = 0;
                if(j != i){
                    int[] c = Arrays.copyOf(a, a.length);
                    c[i]=a[j];
                    for(int k=0; k < c.length; k++){
                        if(c[k] < b[k]){
                            diff += b[k] - c[k];
                        }else{
                            diff += c[k] - b[k];
                        }
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
        System.out.println(cs.solution(new int[]{1,3,5}, new int[]{5,3,1}));
    }

}
