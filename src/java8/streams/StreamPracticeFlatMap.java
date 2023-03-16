package java8.streams;

import java8.streams.model.Developer;
import java8.streams.model.LineItem;
import java8.streams.model.Order;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
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
        List<String> result1 = Stream.of(strArray1)
                .flatMap(Stream::of)
                .map(x -> x.toUpperCase()).collect(Collectors.toList());
        System.out.println(result1);

        /*
        I want to point out that dealing with more than one level of Stream is challenging, confusing, and error-prone, and we can use this Stream#flatMap to flatten the 2 levels Stream into one level Stream.
        Stream<String[]>      -> flatMap ->	Stream<String>
        Stream<Set<String>>   -> flatMap ->	Stream<String>
        Stream<List<String>>  -> flatMap ->	Stream<String>
        Stream<List<Object>>  -> flatMap ->	Stream<Object>
         */
    }
    /*
    This example uses .stream() to convert a List into a stream of objects, and each object contains a set of books, and we can use flatMap to produces a stream containing all the book in all the objects.

    In the end, we also filter out the book containing the word python and collect a Set to remove the duplicated book.


     */
    public void findAllBooksFlatMap(){

        Developer o1 = new Developer();
        o1.setName("mkyong");
        o1.addBook("Java 8 in Action");
        o1.addBook("Spring Boot in Action");
        o1.addBook("Effective Java (3nd Edition)");

        Developer o2 = new Developer();
        o2.setName("zilap");
        o2.addBook("Learning Python, 5th Edition");
        o2.addBook("Effective Java (3nd Edition)");

        List<Developer> list = new ArrayList<>();
        list.add(o1);
        list.add(o2);

        Set<String> collect =
                list.stream()
                        .map(x -> x.getBook())                              //  Stream<Set<String>>
                        .flatMap(x -> x.stream())                           //  Stream<String>
                        .filter(x -> !x.toLowerCase().contains("python"))   //  filter python book
                        .collect(Collectors.toSet());                       //  remove duplicated

        collect.forEach(System.out::println);

        //Or

        Set<String> collect2 = list.stream()
                //.map(x -> x.getBook())
                .flatMap(x -> x.getBook().stream())                 //  Stream<String>
                .filter(x -> !x.toLowerCase().contains("python"))   //  filter python book
                .collect(Collectors.toSet());

        collect2.forEach(System.out::println);


    }
    /*
        4. flatMap example – Order and LineItems
            This example is similar to the official flatMap JavaDoc example.

            The orders is a stream of purchase orders, and each purchase order contains a collection of line items, then we can use flatMap to produce a Stream or Stream<LineItem> containing all the line items in all the orders. Furthermore, we also add a reduce operation to sum the line items’ total amount.
     */
    public void sumOfLineItems(){
        List<Order> orders = findAll();

        // sum the line items' total amount
        BigDecimal sumOfLineItems = orders.stream()
                .flatMap(order -> order.getLineItems().stream())    //  Stream<LineItem>
                .map(line -> line.getTotal())                       //  Stream<BigDecimal>
                .reduce(BigDecimal.ZERO, BigDecimal::add);          //  reduce to sum all


        // sum the order's total amount
        BigDecimal sumOfOrder = orders.stream()
                .map(order -> order.getTotal())                     //  Stream<BigDecimal>
                .reduce(BigDecimal.ZERO, BigDecimal::add);          //  reduce to sum all

        System.out.println(sumOfLineItems);                         // 3194.20
        System.out.println(sumOfOrder);                             // 3194.20

    }

    /*
    6. flatMap and primitive type
    For primitive types like int, long, double, etc. Java 8 Stream also provide related flatMapTo{primative type} to flat the Stream of primitive type; the concept is the same.
     */
    public void flatMapAndPrimitive(){
        int[] array = {1, 2, 3, 4, 5, 6};
        //Stream<int[]>
        Stream<int[]> streamArray = Stream.of(array);
        //Stream<int[]> -> flatMap -> IntStream
        IntStream intStream = streamArray.flatMapToInt(x -> Arrays.stream(x));
        intStream.forEach(x -> System.out.println(x));


        //flatMapToLong -> LongStream
        long[] array1 = {1, 2, 3, 4, 5, 6};

        Stream<long[]> longArray = Stream.of(array1);

        LongStream longStream = longArray.flatMapToLong(x -> Arrays.stream(x));

        System.out.println(longStream.count());
    }

    /*
        3D Streams Iteration
     */
    public void flatMapAndStream(){
        int[][][] data = {
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                },
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }
        };

        IntStream result = Arrays.stream(data).flatMap(Stream::of).flatMapToInt(Arrays::stream);
        result.forEach(System.out::println);

        //To better help understand what is going on above, you can split the method invocations as follows:

        // the call to Arrays.stream yields a Stream<int[][]>
        Stream<int[][]> result1 = Arrays.stream(data);

        // the call to flatMap yields a Stream<int[]>
        Stream<int[]> result2 = result1.flatMap(Arrays::stream);
        result2.forEach(System.out::println);

        // the call to flatMapToInt yields a IntStream
        IntStream intStream = result2.flatMapToInt(Arrays::stream);
    }



    public static void main(String [] args){
        StreamPracticeFlatMap spm = new StreamPracticeFlatMap();
        spm.flatMapUsage1();
        spm.findAllBooksFlatMap();
        spm.sumOfLineItems();
        spm.flatMapAndPrimitive();
        spm.flatMapAndStream();
    }


    // create dummy records
    private static List<Order> findAll() {

        LineItem item1 = new LineItem(1, "apple", 1, new BigDecimal("1.20"), new BigDecimal("1.20"));
        LineItem item2 = new LineItem(2, "orange", 2, new BigDecimal(".50"), new BigDecimal("1.00"));
        Order order1 = new Order(1, "A0000001", Arrays.asList(item1, item2), new BigDecimal("2.20"));

        LineItem item3 = new LineItem(3, "monitor BenQ", 5, new BigDecimal("99.00"), new BigDecimal("495.00"));
        LineItem item4 = new LineItem(4, "monitor LG", 10, new BigDecimal("120.00"), new BigDecimal("1200.00"));
        Order order2 = new Order(2, "A0000002", Arrays.asList(item3, item4), new BigDecimal("1695.00"));

        LineItem item5 = new LineItem(5, "One Plus 8T", 3, new BigDecimal("499.00"), new BigDecimal("1497.00"));
        Order order3 = new Order(3, "A0000003", Arrays.asList(item5), new BigDecimal("1497.00"));

        return Arrays.asList(order1, order2, order3);

    }
}
