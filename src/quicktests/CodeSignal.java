package quicktests;

import java.util.*;
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

    public int[] codeSignal3(int[] a){

            List<Integer> iList = new ArrayList<>();
            String strArr = Arrays.stream(a).boxed()
                    .map(x -> String.valueOf(x))
                    .reduce("", (a1,b1) -> a1 + b1);

            iList=strArr.chars()
                    .mapToObj(c -> Character.getNumericValue(c))
                    .collect(Collectors.toList());

            Map<Integer,Long> iMap = iList.stream()
                    .collect(Collectors.groupingBy(x -> x.intValue(),Collectors.counting()));
            iMap.entrySet().stream().forEach(System.out::println);

            iMap.entrySet().stream().max(Map.Entry.comparingByValue()).stream().forEach(x -> {
                System.out.println("Found Entry which has Max Value From Map : "+x.getValue());
            });

            long maxValue =iMap.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
            System.out.println("Max Value :"+maxValue);

            iMap.entrySet().stream().filter(e -> e.getValue() == maxValue).forEach(x -> {
                System.out.println("Find All Keys Which has Max Value in Map Entry :"+x.getKey());
            });

            List<Integer> resultKeys = iMap.entrySet().stream()
                    .filter(e -> e.getValue() == maxValue)
                    .map(x -> x.getKey())
                    .collect(Collectors.toList());
            resultKeys.forEach(System.out::println);

            return iMap.entrySet().stream()
                .filter(e -> e.getValue() == maxValue)
                    .mapToInt(x -> x.getKey().intValue())
                    .toArray();
            //return intArr;
    }


    public int[] codeSignal4(int n, int[] a){
        int[] b = new int[a.length];
        for(int i=0;i < a.length; i++){
            if((i-1) >= 0 && (i+1) < a.length) {
                b[i] = a[i-1]+a[i]+a[i+1];
            }else if((i-1) < 0){
                b[i] = a[i]+a[i+1];
            }else if((i+1) >= a.length){
                b[i] = a[i-1]+a[i];
            }
        }
        Arrays.stream(b).boxed().forEach(System.out::println);
        return b;
    }

    boolean[] codeSignal5(int[] numbers, int left, int right) {

        boolean[] b = new boolean[numbers.length];
        for(int i=0 ; i< numbers.length ; i++){
            if(numbers[i] != 0){
                int x = numbers[i]/(i+1);
                if(numbers[i] % (i+1) == 0 && x >= left && x <= right){
                    b[i] = true;
                }else{
                    b[i] = false;
                }
            }else{
                b[i] = false;
            }
        }
        return b;
    }

    boolean codeSignal6(int[] numbers) {

        boolean result = false;
        result = isSortedArray(numbers,numbers.length);
        return result;
    }



    static boolean isSortedArray(int[] numbers,int arrLength){
        boolean result = false;
        if(arrLength == 0 || arrLength == 1){
            return true;
        }
        for(int i=0 ; i< numbers.length ; i++){
            if((i+1 < numbers.length) && numbers[i] < numbers[i+1]){
                result= true;
            }else{
                StringBuilder sb = new StringBuilder();
                numbers[i] = Integer.parseInt(sb.append(String.valueOf(numbers[i])).reverse().toString());
                sb.delete(0,sb.length());
                if(reSortAttempt(numbers,arrLength)){
                    result= true;
                    break;
                }else{
                    result= false;
                    continue;
                }
            }
        }
        return result;
    }

    static boolean reSortAttempt(int[] numbers,int arrLength){
        boolean result = false;
        for(int i=0 ; i< numbers.length ; i++){
            if((i+1 < numbers.length) && numbers[i] < numbers[i+1]){
                result =true;
            }else{
                result =false;
                break;
            }
        }
        return result;
    }

    public void isPrime(int number){
        boolean result = true;
        if(number < 0 || number == 0 || number == 1){
            result=false;
        }

        if(number > 2){
            for(int i= 2 ; i < number ; i++){
                if(number % i == 0){
                    result=false;
                    break;
                }
            }
        }

        if(result){
            System.out.println("This is Prime Number");
        }else{
            System.out.println("This is NOT Prime Number");
        }
    }

    int codeSignal7(String s) {
        int count = 0;
        if(s.length() > 2){
            for(int i=0 ; i < s.length() ; i++){
                for(int j=i+1; j < s.length();j++){
                    for(int k=j+1; k< s.length();k++){
                        String a =s.substring(i,j);
                        String b =s.substring(j,k);
                        String c =s.substring(k);
                        Set<String> set = new HashSet<>();
                        set.add(a+b);
                        set.add(b+c);
                        set.add(c+a);
                        if(set.size() == 3){
                            count++;
                        }
                    }
                }
                break;
            }
        }
        System.out.println("Final Count"+count);
        return count;
    }

    public boolean isPalindrome(String checkString){
        StringBuilder sb = new StringBuilder();
        sb.append(checkString);
        if(checkString.equals(sb.reverse().toString())){
            return true;
        }
        return false;
    }

    public String reverseString(String s){
        String result = "";
        for(int i=s.length()-1 ; i >=0 ; i--){
            result+= s.charAt(i);
            System.out.println(s.charAt(i));
        }
        return result;
    }


    public void printDuplicate(String s){
        Set<String> list = new HashSet<>();
        for(int i=0; i < s.length(); i++){
            for(int j=i+1; j < s.length() ; j++){
                if(!String.valueOf(s.charAt(i)).equalsIgnoreCase(String.valueOf(s.charAt(j)))){
                    list.add(String.valueOf(s.charAt(i)));
                }
            }
        }
        list.stream().forEach(System.out::println);
    }

    public void checkStringHasDigit(String s){
        s.chars().forEach(x -> {
            if(Character.isDigit(x)){
                System.out.println(Character.getNumericValue(x));
            }
        });
    }


    public void containVowel(String s){
        List<Character> charList = new ArrayList<>();
        charList.add('a');
        charList.add('e');
        charList.add('i');
        charList.add('o');
        charList.add('u');

        char [] chArr= s.toCharArray();

        for(int i=0 ; i < chArr.length ; i++){
            if(charList.contains(chArr[i])){
                System.out.println(chArr[i]);
            }
        }

        Arrays.stream(s.chars().toArray()).map(x -> Character.getNumericValue(x)).forEach(System.out::println);
    }

    public void printPermutation(String str, String ans){
        // If string is empty
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            // ith character of str
            char ch = str.charAt(i);
            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);
            // Recursive call
            printPermutation(ros, ans + ch);
        }
    }

    public int lengthOfLastWord(String s) {
        int count = 0;
        int idx = s.length() - 1;
        while (idx >= 0 && s.charAt(idx) == ' ') {
            idx--;
            System.out.println(idx);
        }
        while (idx >= 0 && s.charAt(idx) != ' ') {
            idx--;
            count++;
        }

        return count;
    }

    public static void main(String [] args){
        CodeSignal qp =  new CodeSignal();
        //qp.codeSignal1(new int[]{8, 5, 6, 16, 5},1,3); //[false, false, true, false, true].
        //qp.codeSignal2("aaacodedoc");
        //qp.stringSubStringOp();
        //qp.codeSignal3(new int[]{25, 2, 3, 57, 38, 41});
        //qp.codeSignal4(5, new int[]{9});
        //qp.codeSignal7("xxx");
        //qp.isPrime(17);
        //qp.lengthOfLastWord("   fly me   to   the moon  ");
        //qp.reverseString("Raj");
        //qp.printDuplicate("Great responsibility");
        //qp.checkStringHasDigit("s246t3g");
        //qp.containVowel("aregr");
        qp.printPermutation("abbewfe","");

    }
}
