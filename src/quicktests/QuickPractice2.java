package quicktests;

import java8.collectorsJava8.Hosting;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Function;
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

    public void quickPractice(){
        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));

        Map<String,Integer> strMap = new HashMap<>();
        strMap.put("A", 10);
        strMap.put("B", 20);
        strMap.put("C", 30);
        strMap.put("D", 40);
        strMap.put("E", null);
        strMap.put("F", 60);

        list.stream().sorted(Comparator.comparing(Hosting::getId)).collect(Collectors.toList());

        List<String> list1 = new ArrayList<>();
        list1.add("liquidweb.com");
        list1.add("linode.com");
        list1.add( "digitalocean.com");
        list1.add("aws.amazon.com");
        list1.add("mkyong.com");

        list1.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        list1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        Collections.sort(list1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        list1.stream().forEach(System.out::println);

        for(Map.Entry entry : strMap.entrySet()){
                System.out.println("Key -"+entry.getKey()+"Value -"+entry.getValue());
        }

        strMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(x -> {
            if(x.getValue() != null && x.getValue().intValue() == 10){
                System.out.println(x.getKey());
            }
        });

        int[] i = new int[]{3,5,1,2,6};
        int[] j = new int[]{7,1,3,5,7};
        int[] k = new int[]{8,5,3,6,7};

        int[] merged = Stream.of(i,j,k).flatMapToInt(IntStream::of)
                .toArray();
        System.out.println("Total ->"+Arrays.stream(merged).sum());
        System.out.println("Max ->"+Arrays.stream(merged).max().getAsInt());
        Arrays.stream(i).boxed().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        Arrays.stream(i).boxed()
                .filter(x -> {
                    if(x.intValue() == 5){
                        return true;
                    }else{
                        return false;
                    }
                }).forEach(System.out::println);

        int j1 = Arrays.stream(i).boxed().reduce((a,b) -> a+b ).get();
        System.out.println("j1 ="+j1);

        String s = Arrays.stream(i).boxed().reduce(0,Integer::sum).toString();
        System.out.println("s ="+s);


    }

    public void switchCase(char i){

        String name = switch(i) {
            case 'a' -> "One";
            case 'b' -> "Two";
            case 'c','d','e' -> "Three";
            default -> "Four";
        };

        System.out.println(name);
    }

    enum practiceEnum {
        ONE("NAME"),
        TWO("TWO"),
        THREE("THREE");

        String name;
        practiceEnum(String s){
            this.name=s;
        }
        public String getValue() {
            return name;
        }

        @Override
        public String toString() {
            return "practiceEnum{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String [] args){

        QuickPractice2 qp = new QuickPractice2();
        //System.out.println(qp.anagramOrNot());
        //qp.findOddNumberFromRange();
        qp.codeSignal1(new int[]{8, 5, 6, 16, 5},1,3); //[false, false, true, false, true].
        qp.convertListToMap();
        qp.quickPractice();
        qp.switchCase('e');
        System.out.println(practiceEnum.ONE.ordinal());
        System.out.println(practiceEnum.ONE.name());
        System.out.println(practiceEnum.ONE.getValue());
        for(Enum enm : practiceEnum.values()){
            System.out.println(enm);
        }

    }


}

