package dsa.leet;

import java.util.Arrays;

public class FirstPalindrome {
    public static String firstPalindrome(String[] words) {
        return Arrays.stream(words).filter(FirstPalindrome::isPalindrome).findFirst().orElse("");
    }

    public static boolean isPalindrome(String s) {
        return new StringBuilder().append(s).reverse().toString().equals(s);
    }
    public static void main(String [] args){
        System.out.println(firstPalindrome(new String[]{"efwf","ff"}));
    }
}
