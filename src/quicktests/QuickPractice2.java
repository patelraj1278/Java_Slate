package quicktests;

import java8.collectorsJava8.Hosting;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

    public void findOddNumberFromRange(){
        IntStream.rangeClosed(0,11).filter(x -> x % 2 != 0 && x != 0).forEach(System.out::println);
    }

    public static boolean doMatching(char[] c1, char[] c2 , BiPredicate<String,String> biPred){
            return biPred.test(String.valueOf(c1),String.valueOf(c2));
    }

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

    //ListToMap
    public void convertListToMap(){
        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));


        Map<Integer,String> imap = list.stream().collect(Collectors.toMap(x -> x.getId(), x -> x.getName() ,(old, existing) -> old, HashMap::new));

        imap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(x -> x.getKey(),y -> y.getValue()));

        imap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach((x) -> {
            System.out.println(x.getKey());
            System.out.println(x.getValue());
        });
        List<String> iList = imap.entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());
        iList.forEach(System.out::println);

        iList.stream().sorted(Comparator.naturalOrder());
        list.stream().sorted(Comparator.comparing(Hosting::getId)).collect(Collectors.toList());

        int[] i = new int[]{3,5,1,4,7};
        Arrays.sort(i);
        int i1 = Arrays.stream(i).boxed().sorted(Integer::compareTo).reduce(1, Integer::min ).intValue();
        System.out.println(i1);

        Stream.iterate(0, (x) -> x+1).limit(10).forEach(System.out::println);

        IntStream.rangeClosed(0,10)
                .filter(x -> x != 5)
                .forEach(System.out::println);
    }

    public static void main(String [] args){

        QuickPractice2 qp = new QuickPractice2();
        //System.out.println(qp.anagramOrNot());
        //qp.findOddNumberFromRange();
        qp.codeSignal1(new int[]{8, 5, 6, 16, 5},1,3); //[false, false, true, false, true].
        qp.convertListToMap();
    }


}

