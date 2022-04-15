package quicktests;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class CodeSignal {

    public boolean[] codeSignal1(int[] numbers, int left, int right){
        List<Integer> inputList = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        boolean[] result = compute(inputList,left,right);
        System.out.println(Arrays.toString(result));
        return result;
    }

    static boolean[] compute(List<Integer> inputList, int left, int right){

        boolean[] bArr = new boolean[inputList.size()];
        for(int i=0 ; i <= inputList.size()-1 ; i++){
            if(inputList.get(i) % (i+1) == 0){
                int pre = inputList.get(i) / (i+1);
                if(pre >= left && pre <= right){
                    bArr[i]= true;
                }else{
                    bArr[i]= false;
                }
            }
        }
        return bArr;
    }

    public void codeSignal2(String input){
        System.out.println("input->"+input);
        char[] ch = input.toCharArray();
        List<String> strList = new LinkedList<>();
        if(input.length() > 0) {
            for (int i = 0; i < ch.length; i++) {
                //System.out.println(input.substring(0,i));
                if (isPalindrome(input.substring(0, i)) && input.substring(0, i).length() > 2) {
                    strList.add("-"+input.substring(0, i)+"-");
                    codeSignal2(input.substring(i));
                }else if(input.substring(0, i).length() == 0){
                    strList.add("-"+input.substring(0, i)+"-");
                }
            }
        }
        strList.stream().forEachOrdered(System.out::println);
    }

    public void stringSubStringOp(){
        String hello = "Hello";
        char[] ch = hello.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            System.out.println(hello.substring(0,1));
            System.out.println(hello.substring(1,hello.length()));
            break;
        }

    }

    public boolean isPalindrome(String checkString){
        StringBuilder sb = new StringBuilder();
        sb.append(checkString);
        if(checkString.equals(sb.reverse().toString())){
            return true;
        }
        return false;
    }

    public static void main(String [] args){
        CodeSignal qp =  new CodeSignal();
        //qp.codeSignal1(new int[]{8, 5, 6, 16, 5},1,3); //[false, false, true, false, true].
        qp.codeSignal2("aaacodedoc");
        //qp.stringSubStringOp();
    }
}
