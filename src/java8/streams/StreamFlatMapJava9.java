package java8.streams;

import java.util.*;
import java.util.stream.Collectors;

//Java 8 Stream – Convert List<List<String>> to List<String>
public class StreamFlatMapJava9 {


    //As title, we can use flatMap to convert it.
    public void convertListofListToList(){
        List<String> numbers = Arrays.asList("1", "2", "A", "B", "C1D2E3");
        List<List<String>> collect = numbers.stream().map(x -> new Scanner(x).findAll("\\D+").map(m -> m.group())
                .collect(Collectors.toList())).collect(Collectors.toList());
        collect.forEach(x -> System.out.println(x));


        List<String> numbers1 = Arrays.asList("1", "2", "A", "B", "C1D2E3");

        List<String> collect1 = numbers1.stream()
                .map(x -> new Scanner(x).findAll("\\D+")
                        .map(m -> m.group())
                        .collect(Collectors.toList())
                )									 	// List<List<String>>
                .flatMap(List::stream)					// List<String>
                .collect(Collectors.toList());


        collect1.forEach(x -> System.out.println(x));
    }

    public void flatMapTest(){
        Map<String,List<String>> iMap = new HashMap<>();
        List<String> iList = new ArrayList<>();
        iList.add("Raj");
        iList.add("Ami");
        iList.add("Heman");
        iMap.put("K1",iList);
        iMap.entrySet().stream()
                .flatMap(v -> v.getValue().stream())
                .forEach(v -> {
                        System.out.println(v);
                });

        iMap.forEach((k,v) -> {
            System.out.println("Key : " + k + ", Value : " + v);
        });


    }


    public static void main(String[] args){
        StreamFlatMapJava9 sf = new StreamFlatMapJava9();
        //sf.convertListofListToList();
        sf.flatMapTest();
    }
}
