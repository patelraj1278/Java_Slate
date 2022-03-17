package java8.streams;

import java8.streams.model.Item;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamGroupBy {

    /*
    1. Group By, Count and Sort
    1.1 Group by a List and display the total count of it.
     */
    public void streamGroupBy1(){
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> result =items.stream().collect(Collectors.groupingBy(x -> x.toUpperCase(),Collectors.counting()));
        System.out.println(result);

        //OR
        Map<String, Long> result2 =items.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(result2);

        Map<String, Long> finalMap = new LinkedHashMap<>();
        //2 Add sorting.
        result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).forEachOrdered(x -> finalMap.put(x.getKey(),x.getValue()));
        System.out.println(finalMap);
    }

    //2.2 Group by the name + Count or Sum the Qty.
    public void streamGroupBy2(){
        //3 apple, 2 banana, others 1
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99")));

        Map<String, Long> counting = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.counting()));

        System.out.println(counting);

        Map<String, Integer> sum = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));

        System.out.println(sum);

        //2.2 Group by Price – Collectors.groupingBy and Collectors.mapping example.
        //group by price
        Map<BigDecimal, List<Item>> groupByPriceMap =
                items.stream().collect(Collectors.groupingBy(Item::getPrice));

        System.out.println(groupByPriceMap);

        // group by price, uses 'mapping' to convert List<Item> to Set<String>
        Map<BigDecimal, Set<String>> result =
                items.stream().collect(
                        Collectors.groupingBy(Item::getPrice,
                                Collectors.mapping(Item::getName, Collectors.toSet())
                        )
                );

        System.out.println(result);
    }


    public static void main(String [] args){
        StreamGroupBy sg = new StreamGroupBy();
        sg.streamGroupBy1();
        sg.streamGroupBy2();
    }
}
