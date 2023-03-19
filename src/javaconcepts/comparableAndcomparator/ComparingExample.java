package javaconcepts.comparableAndcomparator;

import java8.lambdaJava8.lambdaComparatorJava8.Developer;

import java.util.*;
import java.util.stream.Collectors;

public class ComparingExample {

    public static void main(String args[]){
        List<Student> listStd = new ArrayList<>();
        listStd.add(new Student(1,"Ami",2000));
        listStd.add(new Student(2,"Raj",1000));
        listStd.add(new Student(3,"Mom",3000));

        //sort by salary using comparable
        //Collections.sort(listStd);
        //Java 7
        for(Student s : listStd){
            System.out.println(s);
        }

        //sort by Id using comparator
        Collections.sort(listStd, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getId()-o1.getId();
            }
        });
        //Java 7
        for(Student s : listStd){
            System.out.println(s);
        }

        //Java 8
        listStd.stream().sorted(Comparator.comparing(Student::getSalary).reversed()).collect(Collectors.toList()).forEach(System.out::println);
        listStd.stream().sorted(Comparator.comparingInt(Student::getId)).collect(Collectors.toList()).forEach(System.out::println);

        listStd.forEach(System.out::println);
    }
}
