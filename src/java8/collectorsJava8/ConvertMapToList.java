package java8.collectorsJava8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertMapToList {

    public void mapToList1(){
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "apple");
        map.put(20, "orange");
        map.put(30, "banana");
        map.put(40, "watermelon");
        map.put(50, "dragonfruit");

        // split a map into 2 List
        List<Integer> resultSortedKey = new ArrayList<>();

        List<String> resultValues = map.entrySet().stream()
                //sort a Map by key and stored in resultSortedKey
                .sorted(Map.Entry.<Integer, String>comparingByKey().reversed())
                .peek(e -> resultSortedKey.add(e.getKey()))
                .map(x -> x.getValue())
                // filter banana and return it to resultValues
                .filter(x -> !"banana".equalsIgnoreCase(x))
                .collect(Collectors.toList());

        resultSortedKey.forEach(System.out::println);
        resultValues.forEach(System.out::println);

    }

    public void mapToList2(){

        Map<Integer, String> map = new HashMap<>();
        map.put(10, "apple");
        map.put(20, "orange");
        map.put(30, "banana");
        map.put(40, "watermelon");
        map.put(50, "dragonfruit");

        System.out.println("\n1. Export Map Key to List...");
        List<Integer> result = new ArrayList(map.keySet());
        result.forEach(System.out::println);

        System.out.println("\n2. Export Map Value to List...");
        List<String> result2 = new ArrayList(map.values());
        result2.forEach(System.out::println);


        Map<Integer, String> map1 = new HashMap<>();
        map1.put(10, "apple");
        map1.put(20, "orange");
        map1.put(30, "banana");
        map1.put(40, "watermelon");
        map1.put(50, "dragonfruit");

        System.out.println("\n1. Export Map Key to List...");
        List<Integer> result1 = map1.keySet().stream()
                .collect(Collectors.toList());
        result1.forEach(System.out::println);

        System.out.println("\n2. Export Map Value to List...");
        List<String> result3 = map1.values().stream()
                .collect(Collectors.toList());
        result3.forEach(System.out::println);

        System.out.println("\n3. Export Map Value to List..., say no to 10");
        List<Integer> result4 = map1.keySet().stream().filter(x -> x != 10).collect(Collectors.toList());
        result4.forEach(System.out::println);
    }
    public static void main(String[] args) {
        ConvertMapToList cm = new ConvertMapToList();
        //cm.mapToList1();
        cm.mapToList2();
    }
}
