package java8.streams;


import java8.streams.model.Invoice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

//In Java 8, the Stream.reduce() combine elements of a stream and produces a single value.
public class StreamReduce {

    //A simple sum operation using a for loop.
    public void sumUsingReduce(){
        /*
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }

        System.out.println("sum : " + sum); // 55
        */


        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // 1st argument, init value = 0
        //identity = default or initial value.
        //BinaryOperator = functional interface, take two values and produces a new value.
        //int sum = Arrays.stream(numbers).reduce(0, (a,b) -> a+b);
        //Or
        int sum = Arrays.stream(numbers).reduce(0, Integer::sum); // 55
        System.out.println("sum : " + sum); // 55
    }


    public void mathOperation(){
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //2.1 Math operations.
        int sum = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);    // 55
        int sum2 = Arrays.stream(numbers).reduce(0, Integer::sum);      // 55
        int sum3 = Arrays.stream(numbers).reduce(0, (a, b) -> a - b);   // -55
        int sum4 = Arrays.stream(numbers).reduce(0, (a, b) -> a * b);   // 0, initial is 0, 0 * whatever = 0
        int sum5 = Arrays.stream(numbers).reduce(0, (a, b) -> a / b);   // 0

        //2.2 Max and Min.
        int max = Arrays.stream(numbers).reduce(0, (a, b) -> a > b ? a : b);  // 10
        int max1 = Arrays.stream(numbers).reduce(0, Integer::max);            // 10

        //2.2 Max and Min.
        int min = Arrays.stream(numbers).reduce(0, (a, b) -> a < b ? a : b);  // 10
        int min1 = Arrays.stream(numbers).reduce(0, Integer::min);            // 10

        System.out.println("max : " + max); // 55
        System.out.println("min : " + min); // 55

    }

    public void stringJoiner(){
        String[] strings = {"a", "b", "c", "d", "e"};

        // |a|b|c|d|e , the initial | join is not what we want
        String reduce = Arrays.stream(strings).reduce("", (a, b) -> a + "|" + b);

        // a|b|c|d|e, filter the initial "" empty string
        String reduce2 = Arrays.stream(strings).reduce("", (a, b) -> {
            if (!"".equals(a)) {
                return a + "|" + b;
            } else {
                return b;
            }
        });
        System.out.println(reduce2);

        // a|b|c|d|e , better uses the Java 8 String.join :)
        String join = String.join("|", strings);
        System.out.println(join);
    }

    //3. Map & Reduce
    //A simple map and reduce example to sum BigDecimal from a list of invoices.
    public void sumUsingMapAndReduce(){
        List<Invoice> invoices = Arrays.asList(
                new Invoice("A01", BigDecimal.valueOf(9.99), BigDecimal.valueOf(1)),
                new Invoice("A02", BigDecimal.valueOf(19.99), BigDecimal.valueOf(1.5)),
                new Invoice("A03", BigDecimal.valueOf(4.99), BigDecimal.valueOf(2))
        );

        //BigDecimal sum =invoices.stream().map(x -> x.getQty().multiply(x.getPrice())).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal sum =invoices.stream().map(x -> x.getQty().multiply(x.getPrice())).reduce(BigDecimal.ZERO,(a,b) -> a.add(b));
        System.out.println(sum);    // 49.955
        System.out.println(sum.setScale(2, RoundingMode.HALF_UP));  // 49.96
    }
    public static void main(String[] args){
        StreamReduce sr = new StreamReduce();
        sr.sumUsingReduce();
        sr.mathOperation();
        sr.stringJoiner();
        sr.sumUsingMapAndReduce();
    }
}
