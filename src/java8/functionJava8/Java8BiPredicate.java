package java8.functionJava8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class Java8BiPredicate {

    public void java8BiPredicate() {
        BiPredicate<String, Integer> filter = (x, y) -> {
            return x.length() == y;
        };

        boolean result = filter.test("mkyong",6);
        System.out.println(result);  // true

        boolean result2 = filter.test("java", 10);
        System.out.println(result2); // false
    }

    public void java8BiPredicate1() {
        List<Domain> domains = Arrays.asList(new Domain("google.com", 1),
                new Domain("i-am-spammer.com", 10),
                new Domain("mkyong.com", 0),
                new Domain("microsoft.com", 2));
        BiPredicate<String, Integer> bi = (domain, score) -> {
            return (domain.equalsIgnoreCase("google.com") || score == 0);
        };

        // if google or score == 0
        List<Domain> result = filterBadDomain(domains, bi);
        System.out.println(result); // google.com, mkyong.com

        //  if score == 0
        List<Domain> result2 = filterBadDomain(domains, (domain, score) -> score == 0);
        System.out.println(result2); // mkyong.com, microsoft.com

        // if start with i or score > 5
        List<Domain> result3 = filterBadDomain(domains, (domain, score) -> domain.startsWith("i") && score > 5);
        System.out.println(result3); // i-am-spammer.com

        // chaining with or
        List<Domain> result4 = filterBadDomain(domains, bi.or(
                (domain, x) -> domain.equalsIgnoreCase("microsoft.com"))
        );
        System.out.println(result4); // google.com, mkyong.com, microsoft.com

    }



    public static void main(String [] args){
        Java8BiPredicate biPredicate = new Java8BiPredicate();
        biPredicate.java8BiPredicate();
        biPredicate.java8BiPredicate1();
    }

    static <T extends Domain> List<T> filterBadDomain(List<T> list, BiPredicate<String, Integer> biPredicate){
        return list.stream()
                .filter(x -> biPredicate.test(x.getName(), x.getScore()))
                .collect(Collectors.toList());
    }

}
