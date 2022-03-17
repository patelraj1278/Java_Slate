package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//1.1 Review the below structure. It consists of a 2 levels Stream or a 2d arrays.
/*
# Stream<String[]>
# Stream<Stream<String>>
# String[][]

[
  [1, 2],
  [3, 4],
  [5, 6]
]
In Java 8, we can use the flatMap to convert the above 2 levels Stream into one Stream level or a 2d array into a 1d array.


# Stream<String>
# String[]

[1, 2, 3, 4, 5, 6]
 */
public class StreamPracticeFlatMap {

    //2.1 It’s challenging to process a Stream containing more than one level, like Stream<String[]> or Stream<List<LineItem>> or Stream<Stream<String>>. And we flat the 2 levels Stream into one level, like Stream<String> or Stream<LineItem>, so that we can easily loop the Stream and process it.
    //
    //Review the below example, before and after applying flatMap on a Stream.
    //
    //2.2 Below is a 2d array, and we can use Arrays.stream or Stream.of to convert it into a Stream, and it produces a Stream of String[] or Stream<String[]>.
    /*
        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

          // array to a stream
          Stream<String[]> stream1 = Arrays.stream(array);

          // same result
          Stream<String[]> stream2 = Stream.of(array);
        or like this.


        [
          [a, b],
          [c, d],
          [e, f]
        ]
     */
    public void flatMapUsage1(){
        String[][] strArray = new String[][]{{"a","b"},{"c","d"},{"e","f"},{"g","h"}};
        // convert array to a stream
        Stream<String[]> strStream = Arrays.stream(strArray);

        List<String[]> result =strStream.filter(x -> {
            for(String s : x){
                if(s.equals("a")){
                    return false;
                }

            }
            return true;
        }).collect(Collectors.toList());

        // print array
        result.forEach(x -> System.out.println(Arrays.toString(x)));


        //Or
        String[][] strArray1 = new String[][]{{"a","b"},{"c","d"},{"e","f"},{"g","h"}};
        List<String> result1 = Stream.of(strArray1).flatMap(Stream::of).map(x -> x.toUpperCase()).collect(Collectors.toList());
        System.out.println(result1);

        /*
        I want to point out that dealing with more than one level of Stream is challenging, confusing, and error-prone, and we can use this Stream#flatMap to flatten the 2 levels Stream into one level Stream.
        Stream<String[]>      -> flatMap ->	Stream<String>
        Stream<Set<String>>   -> flatMap ->	Stream<String>
        Stream<List<String>>  -> flatMap ->	Stream<String>
        Stream<List<Object>>  -> flatMap ->	Stream<Object>
         */
    }
    public static void main(String [] args){
        StreamPracticeFlatMap spm = new StreamPracticeFlatMap();
        spm.flatMapUsage1();
    }
}
