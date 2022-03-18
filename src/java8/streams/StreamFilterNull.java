package java8.streams;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilterNull {

    public void findNullFromStream(){

        Stream<String> language = Stream.of("java", "python", "node", null, "ruby", null, "php");
        List<String> nullValues = language.filter(x -> x != null).collect(Collectors.toList());
        nullValues.forEach(System.out::println);
        //Or
        //List<String> result = language.filter(Objects::nonNull).collect(Collectors.toList());
        //result.forEach(System.out::println);
    }

    public static void main(String [] args){
        StreamFilterNull sf = new StreamFilterNull();
        sf.findNullFromStream();
    }
}
