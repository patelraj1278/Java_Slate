package java8.streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamtoListConvert {

    //A Java 8 example to show you how to convert a Stream to a List via Collectors.toList
    public void convertStreamToList(){
        Stream<String> language = Stream.of("java", "python", "node");
        List<String> convertedList = language.collect(Collectors.toList());
        convertedList.forEach(System.out::println);

        //Yet another example, filter a number 3 and convert it to a List
        Stream<Integer> number = Stream.of(1, 2, 3, 4, 5);
        Predicate<Integer> pred = x -> x== 3;
        List<Integer> convertedList1 =  number.filter(pred.negate()).collect(Collectors.toList());
        convertedList1.forEach(System.out::println);
    }
    public static void main(String [] args){
        StreamtoListConvert sf = new StreamtoListConvert();
        sf.convertStreamToList();
    }
}
