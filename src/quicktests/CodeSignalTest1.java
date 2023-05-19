package quicktests;

import java.util.Arrays;

public class CodeSignalTest1 {
    String solution(String s) {
        String result = s;
        if(result.length() == 0 ){
            return result;
        }

        for(int i=1;i <= s.length();i++){
            String str = s.substring(0,i);
            if(isPalin(str)){
                if(str.length() > 2){
                    result=str.substring(i);
                    System.out.println(result);
                    solution(s.substring(i));
                }
            }
        }
        return result;
    }

    public boolean isPalin(String s){
        StringBuffer sb = new StringBuffer();
        sb.append(s);
        if(s.length() > 0 && sb.reverse().toString().equals(s)){
            sb.delete(0,s.length());
            return true;
        }else{
            sb.delete(0,s.length());
            return false;
        }
    }

    public static boolean isPalinDron(String str){
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
     }

    public static String reverserString(String str){
        char[] chars = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    public static void replaceString(String str){
        System.out.println("str = " + str.replaceAll("[^A-Za-z0-9]",""));
    }

    public static void main(String [] args){
        CodeSignalTest1 cs = new CodeSignalTest1();
        System.out.println("Result=>"+cs.solution("aaacodedocaff"));
        System.out.println(isPalinDron("aaacodedocaff"));
        replaceString("Hello3243()WOrds-");
    }
}
