package java8.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*Streams have a BaseStream.close() method and implement AutoCloseable, but nearly all stream instances do not actually need to be closed after use. Generally, only streams whose source is an IO channel (such as those returned by Files.lines(Path, Charset)) will require closing. Most streams are backed by collections, arrays, or generating functions, which require no special resource management. (If a stream does require closing, it can be declared as a resource in a try-with-resources statement.)*

 */
public class StreamCloseConcept {

    //1. For normal Stream like this, the stream instance does not need to be closed after use.
    public void noNeedToClose(){
        Stream<String> stream = Stream.of("A", "B", "C");
        List<String> filter = stream.filter(x -> !x.equalsIgnoreCase("B"))
                .collect(Collectors.toList());

        // no need close the stream.
        //stream.close();

        System.out.println(filter); // [A, C]

    }

    //2. For Stream whose source are an IO channel, close it with try-with-resources
    public void streamNeedToClose(){
        String path = "c:\\projects\\app.log";

        // auto close
        try (Stream<String> lines = Files.lines(Paths.get(path))) {

            String content = lines.collect(Collectors.joining(System.lineSeparator()));
            System.out.println(content); // [A, C]
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String [] args){
        StreamCloseConcept scc = new StreamCloseConcept();
        scc.noNeedToClose();
        scc.streamNeedToClose();
    }
}
