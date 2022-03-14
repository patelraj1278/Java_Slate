package java8;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class LoopMap {

    public void loopListAndMapJava8(){

        Map<String,Integer> strMap = new HashMap<>();
        strMap.put("A", 10);
        strMap.put("B", 20);
        strMap.put("C", 30);
        strMap.put("D", 40);
        strMap.put("E", null);
        strMap.put("F", 60);

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add(null);
        list.add("D");
        list.add("E");

        /*//Java 7
        if (strMap != null) {
            for(Map.Entry<String,Integer> entry: strMap.entrySet()){
                System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
            }
        }*/

        /*//Java 7
        for(String str: list){
            System.out.println(str);
        }*/

        /*//Java 8 Lambda
        strMap.forEach( (k,v) -> {
            if (k != null && v!= null) {
                System.out.println("Key : " + k + ", Value : " + v);
            }
        });*/

        //Java 8 Loop
        //list.forEach(v -> System.out.println(v));
        //list.forEach(System.out::println);
        list.stream().filter(Objects::nonNull).forEach(System.out::println);
        list.stream()
                .filter(v -> v!=null)
                .forEach(v -> {
                    System.out.println(v.toLowerCase());
                });

        //Java 8 forEach and Consumer

    }

    public void consumerJava8(){
        // convert a String to a Hex
        List<String> list = Arrays.asList("abc", "java", "python");
        Stream<String> stream = Stream.of("abc", "java", "python");

        // convert a String to a Hex
        Consumer<String> printTextInHexConsumer = (String x) -> {
            StringBuilder sb = new StringBuilder();
            for(char c : x.toCharArray()){
                String hex = Integer.toHexString(c);
                sb.append(hex);
            }
            System.out.print(String.format("%n%-10s:%s", x, sb.toString()));
        };

        // pass a Consumer
        list.forEach(printTextInHexConsumer);
        stream.forEach(printTextInHexConsumer);
    }

    /*The forEach does not guarantee the stream’s encounter order,
    regardless of whether the stream is sequential or parallel. The result is obvious when run in a parallel mode.*/
    public void forEachOrdered(){
        Stream<String> s = Stream.of("a", "b", "c", "1", "2", "3");
        //s.parallel().forEach(x -> System.out.println(x));
        s.parallel().forEachOrdered(x -> System.out.println(x));
    }


    public static void main(String[] args){
        LoopMap lm = new LoopMap();

        //Java 8 Loop List & Map
        lm.loopListAndMapJava8();

        //Java 8 Consumer Example
        lm.consumerJava8();

        //ForEachOrdered Java 8
        lm.forEachOrdered();

    }

}
