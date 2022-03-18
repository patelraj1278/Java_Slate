package java8.streams;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamReUse {

    //For whatever reason, you really want to reuse a Stream, try the following Supplier solution :
    public void streamReUseFail(){
        String[] array = {"a", "b", "c", "d", "e"};
        Stream<String> stream = Arrays.stream(array);

        // loop a stream
        stream.forEach(x -> System.out.println(x));

        // reuse it to filter again! throws IllegalStateException
        long count = stream.filter(x -> "b".equals(x)).count();
        System.out.println(count);
    }

    //For whatever reason, you really want to reuse a Stream, try the following Supplier solution :
    public void streamReUse(){
        String[] array = {"a", "b", "c", "d", "e"};

        Supplier<Stream<String>> streamSupplier = () -> Stream.of(array);

        //get new stream
        streamSupplier.get().forEach(x -> System.out.println(x));

        //get another new stream
        long count = streamSupplier.get().filter(x -> "b".equals(x)).count();
        System.out.println(count);
    }
    public static void main(String [] args){
        StreamReUse su = new StreamReUse();
        su.streamReUseFail();
        su.streamReUse();

    }
}
