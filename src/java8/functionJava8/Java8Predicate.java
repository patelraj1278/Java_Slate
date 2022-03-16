package java8.functionJava8;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;

public class Java8Predicate {

    public void java8Predicate(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> collect = list.stream().filter(x -> x > 5).collect(Collectors.toList());
        System.out.println(collect); // [6, 7, 8, 9, 10]
    }

    public void java8Predicate1(){
        Predicate<Integer> noGreaterThanFive = x -> x < 5;
        Predicate<Integer> greateThanTwo = x -> x > 2;
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> collect1 =list.stream().filter(noGreaterThanFive).filter(greateThanTwo).collect(Collectors.toList());
        System.out.println(collect1); // [2,3]
    }


    public void java8OneOrMorePredicate(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> collect =list.stream().filter(x -> x > 5 && x < 8).collect(Collectors.toList());
        System.out.println(collect); // [2,3]

    }

    public void java8OneOrMorePredicateUsingAnd(){
        Predicate<Integer> noGreaterThanFive = x -> x < 5;
        Predicate<Integer> greateThanTwo = x -> x > 2;
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> collect = list.stream()
                .filter(noGreaterThanFive.and(greateThanTwo)).sorted(Comparator.reverseOrder()).max(Integer::compareTo).stream().collect(Collectors.toList());
        System.out.println(collect); // [4]
        Optional<Integer> opt = list.stream()
                .filter(noGreaterThanFive.and(greateThanTwo)).sorted(Comparator.naturalOrder()).findFirst();
        System.out.println(opt); // [3]
        Optional<Integer> opt1 = list.stream()
                .filter(noGreaterThanFive.and(greateThanTwo)).sorted(Comparator.reverseOrder()).findAny();
        System.out.println(opt1); // [3]
        List<Integer> collect1 = list.stream()
                .filter(noGreaterThanFive.and(greateThanTwo)).sorted(Comparator.reverseOrder()).min(Integer::compareTo).stream().collect(Collectors.toList());
        System.out.println(collect1); // [3]

        List<Integer> collect2 =list.stream().limit(3).collect(Collectors.toList());
        System.out.println(collect2); // [3]

        ToLongFunction<Integer> tl = x -> x.longValue();
        OptionalLong oLong = list.stream().mapToLong(tl).max();
        System.out.println(oLong.getAsLong()); // [10] as Long

    }

    public void java8OneOrMorePredicateUsingOr(){
        Predicate<String> lengthIs3 = x -> x.length() == 3;
        Predicate<String> startWithA = x -> x.startsWith("A");

        List<String> list = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");

        List<String> collect = list.stream()
                .filter(lengthIs3.or(startWithA))
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    public void java8OneOrMorePredicateUsingNegate(){
        Predicate<String> startWithA = x -> x.startsWith("A");

        List<String> list = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");

        List<String> collect = list.stream()
                .filter(startWithA.negate())
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    public void java8OneOrMorePredicateUsingTest(){
        List<String> list = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");
        List<String> retList = StringProcessor.filter(list,x -> x.startsWith("A") && x.length() == 3);
        System.out.println(retList);
    }

    public void java8OneOrMorePredicateUsingChain(){
        Predicate<String> startWithA = x -> x.startsWith("a");
        boolean result = startWithA.or(x -> x.startsWith("m")).test("mkyong");
        System.out.println(result);     // true

        // !(start with "a" and length is 3)
        boolean result2 = startWithA.and(x -> x.length() == 3).negate().test("abc");
        System.out.println(result2);    // false
    }

    public void java8OneOrMorePredicateInObject(){
        Hosting h1 = new Hosting(1, "amazon", "aws.amazon.com");
        Hosting h2 = new Hosting(2, "linode", "linode.com");
        Hosting h3 = new Hosting(3, "liquidweb", "liquidweb.com");
        Hosting h4 = new Hosting(4, "google", "google.com");
        List<Hosting> list = Arrays.asList(new Hosting[]{h1, h2, h3, h4});

        List<Hosting> result = HostingRespository.filterHosting(list,x -> x.getName().startsWith("g"));
        System.out.println("result : " + result);  // google
        List<Hosting> result2 = HostingRespository.filterHosting(list, HostingRespository.isDeveloperFriendly());
        System.out.println("result2 : " + result2); // linode


    }


    public static void main(String [] args){
        Java8Predicate jp = new Java8Predicate();
        //jp.java8Predicate();
        //jp.java8Predicate1();
        //jp.java8OneOrMorePredicate();
        //jp.java8OneOrMorePredicateUsingAnd();
        //jp.java8OneOrMorePredicateUsingOr();
        //jp.java8OneOrMorePredicateUsingNegate();
        //jp.java8OneOrMorePredicateUsingTest();
        //jp.java8OneOrMorePredicateUsingChain();
        jp.java8OneOrMorePredicateInObject();

    }
}

class StringProcessor{
    static List<String> filter(List<String> list, Predicate<String> predicate){
        return list.stream().filter(predicate::test).collect(Collectors.toList());
    }
}

class HostingRespository{
    static List<Hosting> filterHosting(List<Hosting> hosting,
                                       Predicate<Hosting> predicate) {
        return hosting.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    static Predicate<Hosting> isDeveloperFriendly() {
        return n -> n.getName().equals("linode");
    }
}