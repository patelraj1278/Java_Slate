package java8.streams;

import java8.streams.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//In this tutorial, we will show you few Java 8 examples to demonstrate the use of Streams
// filter(), collect(), findAny() and orElse()
public class StreamPracticeFindAnyOrElseFilter {

    public void filterAndCollect(){

        //1. Streams filter() and collect()
        List<String> lines = Arrays.asList("spring", "node", "mkyong");
        Optional<String> collect1 = lines.stream().filter(x -> x.equalsIgnoreCase("mkyong")).findAny();
        System.out.println(collect1);

        List<String> filteredlines =  lines.stream().filter(x -> x.equalsIgnoreCase("mkyong")).collect(Collectors.toList());
        filteredlines.forEach(System.out::println);

        String collect2 = lines.stream().filter(x -> x.equalsIgnoreCase("abc")).findAny().orElse("Raj");
        System.out.println(collect2);


        String collect3 = lines.stream().filter(x -> x.equalsIgnoreCase("abc1")).findAny().orElseGet(() -> "Raj2");
        System.out.println(collect3);

        //2. Streams filter(), findAny() and orElse()
        List<Person> newList = Arrays.asList(
                new Person("Raj",32),
                new Person("Ami",30)
        );
        Person p = newList.stream().filter(x -> x.getName().equalsIgnoreCase("Heman")).findAny().orElse(new Person("Prisha",3));
        System.out.println(p);

        Person result1 = newList.stream()
                .filter((p1) -> "jack".equals(p1.getName()) && 20 == p1.getAge())
                .findAny()
                .orElse(null);

        System.out.println("result 1 :" + result1);

        //or like this
        Person result2 = newList.stream()
                .filter(p2 -> {
                    if ("jack".equals(p2.getName()) && 20 == p2.getAge()) {
                        return true;
                    }
                    return false;
                }).findAny()
                .orElse(null);

        System.out.println("result 2 :" + result2);

        //3. Streams filter() and map()
        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

        String name = persons.stream()
                .filter(x -> "jack".equals(x.getName()))
                .map(Person::getName)                        //convert stream to String
                .findAny()
                .orElse("");

        System.out.println("name : " + name);

        List<String> collect = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);

        //Predicate & BiPredicate - perform test & return boolean
        //Supplier & BiSupplier - Just supply & does not accept anything
        //Consumer & BiConsumer - Just consumer & does not return anything
        //Function & BiFunction - Supply & Consumer both
        //UnaryOperation & Binary Operation - Unary accepts single input & return single output of Same type (extends Function), Binary accepts two input & return one output of Same Type (extends Bi Function)

    }

    public static void main(String []  args){
        StreamPracticeFindAnyOrElseFilter sp = new StreamPracticeFindAnyOrElseFilter();
        sp.filterAndCollect();
    }
}
