package quicktests;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class QuickPractice2 {
    public boolean anagramOrNot(){
        String s1 = "hello";
        String s2 = "eholl";

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);
        Stream.of(c1,c2).forEach(System.out::println);

        BiPredicate<String,String> biPred = (x,y) -> {
            if(x.equalsIgnoreCase(y)){
                return true;
            }else{
                return false;
            }
        };
        return doMatching(c1,c2,biPred);
    }

    public static boolean doMatching(char[] c1, char[] c2 , BiPredicate<String,String> biPred){
            return biPred.test(String.valueOf(c1),String.valueOf(c2));
    }

    public static void main(String [] args){

        QuickPractice2 qp = new QuickPractice2();
        System.out.println(qp.anagramOrNot());
    }
}
