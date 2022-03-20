package java8.lambdaJava8.lambdaComparatorJava8;

import java.math.BigDecimal;
import java.util.*;

public class TestSorting {

    public void sortingWithoutLambda(){
        List<Developer> listDevs = getDevelopers();

        System.out.println("Before Sort");
        for (Developer developer : listDevs) {
            System.out.println(developer);
        }

        //sort by age
        Collections.sort(listDevs, new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getNo1()-o2.getNo1();
            }
        });

        //sort by name
        Collections.sort(listDevs, new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        //sort by salary
        Collections.sort(listDevs, new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getNo().compareTo(o2.getNo());
            }
        });

        System.out.println("After Sort");
        for (Developer developer : listDevs) {
            System.out.println(developer);
        }
    }

    public void sortingWitgLambda(){
        List<Developer> listDevs = getDevelopers();
        System.out.println("Before Sort Age");
        listDevs.forEach(developer -> System.out.println(developer));
        listDevs.sort(((o1, o2) -> o1.getNo1() - o2.getNo1()));
        System.out.println("After Sort Age");
        listDevs.forEach(developer -> System.out.println(developer));


        System.out.println("Before Sort Salary");
        listDevs.forEach(developer -> System.out.println(developer));
        //Sort by Salary
        //lambda
        listDevs.sort((Developer o1, Developer o2)->o1.getNo().compareTo(o2.getNo()));

        //lambda, valid, parameter type is optional
        //listDevs.sort((o1, o2)->o1.getNo().compareTo(o2.getNo()));
        System.out.println("After Sort Salary");
        listDevs.forEach(developer -> System.out.println(developer));

        System.out.println("Before Sort Name");
        listDevs.forEach(developer -> System.out.println(developer));
        //Sort by name
        //lambda
        listDevs.sort((Developer o1, Developer o2)->o1.getName().compareTo(o2.getName()));

        //lambda
        //listDevs.sort((o1, o2)->o1.getName().compareTo(o2.getName()));
        System.out.println("After Sort Name");
        listDevs.forEach(developer -> System.out.println(developer));
    }

    public void reverseSorting(){
        List<Developer> listDevs = getDevelopers();
        Comparator<Developer> cd = (o1, o2) -> o1.getNo().compareTo(o2.getNo());
        listDevs.stream().sorted(cd.reversed()).forEach(developer -> System.out.println(developer));
    }

    private static List<Developer> getDevelopers() {

        List<Developer> result = new ArrayList<Developer>();

        result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
        result.add(new Developer("alvin", new BigDecimal("80000"), 20));
        result.add(new Developer("jason", new BigDecimal("100000"), 10));
        result.add(new Developer("iris", new BigDecimal("170000"), 55));

        return result;

    }

    public static void main(String[] args) {
        TestSorting ts = new TestSorting();
        //ts.sortingWithoutLambda();
        //ts.sortingWitgLambda();
        ts.reverseSorting();
    }

}
