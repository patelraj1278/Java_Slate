package java8.methodReferencesJava8;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Java8MethodReference {

    //1.1 This example prints a list of Strings, method reference to a static method SimplePrinter::print.
    public void staticMethodRefernce1(){
        List<String> list = Arrays.asList("A", "B", "C");

        // anonymous class
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                SimplePrinter.print(s);
            }
        });

        // lambda expression
        list.forEach(x -> SimplePrinter.print(x));

        // method reference
        list.forEach(SimplePrinter::print);
    }

    //1.2 This example converts a list of Strings into a list of Integers, method reference to a static method Integer::parseInt.
    public void staticMethodRefernce2(){
        List<String> list = Arrays.asList("1", "2", "3");

        // anonymous class
        List<Integer> collect1 = list.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        }).collect(Collectors.toList());
        System.out.println(collect1.get(0).getClass());


        // lambda expression
        List<Integer> collect2 = list.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        System.out.println(collect2.get(0).getClass());

        // method reference
        List<Integer> collect3 = list.stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(collect3.get(0).getClass());
    }

    //1.3 This example joins two Integer and returns a String. It passes a method reference static method IntegerUtils::join as an argument into another method that accepts a BiFunction.
    public void staticMethodRefernce3(){
        // anonymous class
        String result1 = playTwoArgument(1, 2, new BiFunction<Integer, Integer, String>() {
            @Override
            public String apply(Integer a, Integer b) {
                return IntegerUtils.join(a, b);
            }
        });
        System.out.println(result1);

        // lambda
        String result2 = playTwoArgument(1, 2, (a, b) -> IntegerUtils.join(a, b));
        System.out.println(result2);

        // method reference
        String result3 = playTwoArgument(1, 2, IntegerUtils::join);
        System.out.println(result3);
    }

    //2. Reference to an instance method of a particular object
    //2.1 This example sorts a list of Employee by salary.
    // We can reference to an instance method compareBySalary of a particular object ComparatorProvider.
    public void instanceMethodRefernce1(){
        List<Employee> list = Arrays.asList(
                new Employee("mkyong", 38, BigDecimal.valueOf(3800)),
                new Employee("zilap", 5, BigDecimal.valueOf(100)),
                new Employee("ali", 25, BigDecimal.valueOf(2500)),
                new Employee("unknown", 99, BigDecimal.valueOf(9999)));

        ComparatorProvider provider = new ComparatorProvider();
        list.sort(provider::compareByAge);
        list.forEach(x -> System.out.println(x));
    }

    //4.1 Reference to a default constructor.
    public void constructorMethodReference1(){
        // lambda
        Supplier<Map> obj1 = () -> new HashMap();   // default HashMap() constructor
        Map map1 = obj1.get();

        // method reference
        Supplier<Map> obj2 = HashMap::new;
        Map map2 = obj2.get();

        // lambda
        Supplier<Invoice> obj3 = () -> new Invoice(); // default Invoice() constructor
        Invoice invoice1 = obj3.get();

        // method reference
        Supplier<Invoice> obj4 = Invoice::new;
        Invoice invoice2 = obj4.get();

    }

    //4.2 Reference to a constructor which accepts an argument – Invoice(BigDecimal unitPrice)
    public void constructorMethodReference2(){
        List<BigDecimal> list = Arrays.asList(
                BigDecimal.valueOf(9.99),
                BigDecimal.valueOf(2.99),
                BigDecimal.valueOf(8.99));

        // lambda
        // List<Invoice> invoices = fakeInvoice(list, (price) -> new Invoice(price));

        // method reference
        List<Invoice> invoices = fakeInvoice(list, Invoice::new);

        invoices.forEach(System.out::println);
    }


    public static void main(String [] args){
        Java8MethodReference jmr = new Java8MethodReference();
        //jmr.staticMethodRefernce1();
        //jmr.staticMethodRefernce2();
        //jmr.staticMethodRefernce3();
        //jmr.instanceMethodRefernce1();
        //jmr.constructorMethodReference1();
        jmr.constructorMethodReference2();

        }

        private static <R> R playTwoArgument(Integer i1, Integer i2,
                                             BiFunction<Integer, Integer, R> func) {
            return func.apply(i1, i2);
        }

        static List<Invoice> fakeInvoice(List<BigDecimal> list, Function<BigDecimal, Invoice> func) {
            List<Invoice> result = new ArrayList<>();

            for (BigDecimal amount : list) {
                result.add(func.apply(amount));
            }
            return result;
        }
    }


class ComparatorProvider {
    public int compareByAge(Employee o1, Employee o2) {
        return o1.getAge().compareTo(o2.getAge());
    }

    public int compareByName(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }

    public int compareBySalary(Employee o1, Employee o2) {
        return o1.getAge().compareTo(o2.getAge());
    }
}

class SimplePrinter {
    public static void print(String str) {
        System.out.println(str);
    }
}

class IntegerUtils{

    public static String join(Integer a, Integer b) {
        return String.valueOf(a + b);
    }


}

