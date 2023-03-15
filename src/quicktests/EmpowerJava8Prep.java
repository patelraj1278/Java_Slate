package quicktests;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmpowerJava8Prep {

    public void mostFrequent(){
        int[] i = new int[5];
        i[0] = 3;
        i[1] = 1;
        i[2] = 2;
        i[3] = 4;

        int[] arr = { 40, 50, 30, 40, 50, 30, 30, 40};

        System.out.println("Get Min ::"+Arrays.stream(arr).reduce((x,y) -> Integer.min(x,y)).getAsInt());
        System.out.println("Get Sum ::"+Arrays.stream(arr).reduce((x,y) -> Integer.sum(x,y)).getAsInt());
        System.out.println("Get Max ::"+Arrays.stream(arr).reduce((x,y) -> Integer.max(x,y)).getAsInt());
        StringBuilder sb = new StringBuilder();
                Arrays.stream(arr).mapToObj(String::valueOf)
                .map(x -> sb.append(x).reverse())
                        .forEach(System.out::println);

        Map<Boolean, List<Integer>> partitionBy = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(x -> x > 30));
        partitionBy.entrySet().forEach(x -> {
            System.out.println("Partition Key::"+x.getKey()+"Partition Value::"+x.getValue());
        });
        System.out.println("Get Max ::"+Arrays.stream(arr).summaryStatistics().getMax());
        System.out.println("Get Sum ::"+Arrays.stream(arr).summaryStatistics().getSum());
        System.out.println("Get Sum ::"+Arrays.stream(arr).reduce(0, Integer::sum));
        Map<Long,Long> result = Arrays.stream(arr).boxed().map(x -> x.longValue())
                        .collect(Collectors.groupingBy(Long::longValue,Collectors.counting()));
        result.entrySet().forEach(x -> {
            System.out.println("Key :"+x.getKey()+"Value :"+x.getValue());
        });
        Map.Entry<Long,Long> entry = result.entrySet().stream().collect(Collectors.maxBy(Map.Entry.comparingByValue())).get();
        System.out.println("mostFrequent Entry => "+entry);

        System.out.println("Get Count ::"+Arrays.stream(arr).summaryStatistics().getCount());
        System.out.println("Get Distinct Count ::"+Arrays.stream(arr).distinct().summaryStatistics().getCount());
        System.out.println("Get Average ::"+Arrays.stream(arr).summaryStatistics().getAverage());
        System.out.println("Get Min ::"+Arrays.stream(arr).summaryStatistics().getMin());


    }

    public void getAccumelator(){
        int[] i1 = {1,4,5,6,7};

        Collector<Integer, ArrayList<Integer> , List<Integer>> accountListCollector = Collector.of(
                ArrayList::new, //Supplier - Supplier
                ArrayList::add, //Accumelator - BiConsumer
                (l1,l2) -> {l1.addAll(l2); return l1; }, //BinaryOperator - Combiner
                Collections::unmodifiableList // Function - Finisher
        );

        List<Integer> resultList = Arrays.stream(i1).boxed().collect(accountListCollector);
        System.out.println("Final Accumalator Result ::=>"+resultList);
    }
    public List<Integer> getListOfInteger(){
        List<Integer> list = Arrays.asList(5,3,3,5,6);
        //list.stream().sorted().forEach(System.out::println);
        //list.stream().distinct().sorted().forEach(System.out::println);
        Map<Integer,Long> result = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        result.entrySet().forEach(x -> {
            System.out.println("Key :"+x.getKey()+"Value :"+x.getValue());
        });

        result.forEach((k,v) -> {
            System.out.println("Hello Key :"+k+"Hello Value :"+v);
        });

        System.out.println("Max Key ::"+result.keySet().stream().collect(Collectors.maxBy(Comparator.naturalOrder())).get());
        System.out.println("Get Value From Map Using Above Key::"+result.get(result.keySet().stream().collect(Collectors.maxBy(Comparator.naturalOrder())).get()));
        System.out.println("Min Value ::"+result.values().stream().collect(Collectors.minBy(Comparator.naturalOrder())).get());
        result.entrySet().stream().filter(x -> x.getKey().toString().equalsIgnoreCase("6")).forEach(x -> {
            System.out.println("Filtered Value :"+ x.getValue() );
        });


        Optional<Map.Entry<Integer,Long>> result2 = result.entrySet().stream().collect(Collectors.maxBy(Comparator.comparing(x -> x.getValue())));
        result2.stream().forEach(x -> {
            System.out.println("Max Occurred Found Key:"+x.getKey()+"Max Occurred Found Value:"+x.getValue());
        });

        return list;
    }

    public List<String> getListOfString(){
        List<String> list = Arrays.asList("23","155","32","44");
        list.stream().forEach(x -> {
            System.out.println(x.length());
        });

        list.stream().filter(x -> x.length() > 2).forEach(System.out::println);

        return list;
    }

    public static void main(String [] args){
        EmpowerJava8Prep emp = new EmpowerJava8Prep();
        //emp.getListOfString();
        //emp.getListOfInteger();
        //emp.mostFrequent();
        emp.getAccumelator();
    }

}
