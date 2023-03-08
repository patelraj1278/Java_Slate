package quicktests;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickTest4 {

    public void test1(){


        //Println
        List<String> list = Arrays.asList("one","two","three","four");
        list.forEach(System.out::println);
        list.forEach(x -> System.out.println("String Value : "+x.length()));

        //Count
        List<Integer> intList = Arrays.asList(4,2,1,3);
        intList.forEach(y -> System.out.println("Int Value : "+y.intValue()));
        System.out.println("Int Count ::=>"+intList.stream().count());

        String s = "efewewgewg";
        System.out.println("Length =>"+s.length());
        //Sort
        List<String> list1 = Arrays.asList("a","Ab","Az","Asz","c");
        list1.sort(Comparator.reverseOrder());
        list1.forEach(System.out::println);
        list1.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        //Filter & Sort
        list1.stream().filter(x -> x.startsWith("A") & x.endsWith("z"))
                .sorted(Comparator.comparing(String::length).reversed())
                .forEach(x -> {
                System.out.println("Filterd Out ::="+x);
            });

        //Filter
        List<Employee> empList = Arrays.asList(new Employee(1,"Raj",BigDecimal.valueOf(10000)),
                new Employee(2,"Heman",BigDecimal.valueOf(20000)));
        empList.stream().filter(x -> x.getName().startsWith("Raj")).collect(Collectors.toList()).forEach(x -> {
            System.out.println("Filtered Employee => "+x);
        });

        //Filter FlatMap
        List<Employee> empDptList = Arrays.asList(new Employee(1,"Raj",BigDecimal.valueOf(10000), Arrays.asList(new Department(1,"IT"))),
                new Employee(2,"Heman",BigDecimal.valueOf(20000),Arrays.asList(new Department(2,"House"))),
                new Employee(3,"Ami",BigDecimal.valueOf(20000),Arrays.asList(new Department(3,"House"))),
                new Employee(1,"Raj",BigDecimal.valueOf(10000), Arrays.asList(new Department(2,"Finance"))
                ));
        empDptList.stream()
                .filter(x -> x.getDepartment() != null)
                .flatMap(y -> y.getDepartment().stream())
                .filter(z -> z.getName().startsWith("House"))
                .collect(Collectors.toList()).forEach(x -> {
                    System.out.println("Filtered Record "+x);
                });

        //Filter FlatMap/Map
        empDptList.stream().map(x -> x.getDepartment().stream()
                .filter(y -> y.getName().startsWith("House"))
                .collect(Collectors.toList()))
                .forEach(x -> {
            System.out.println("Filtered MapRecord "+x);
        });

        empDptList.stream().flatMap(x -> x.getDepartmentStream())
                .map(y -> y.getName())
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
                .forEach(x -> {
                    System.out.println("Filtered flatMap"+x);
                });

        empDptList.stream().flatMap(x -> x.getDepartmentStream())
                .map(y -> y.getName())
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
                .forEach(x -> {
                    System.out.println("Filtered flatMap :"+x);
                });

        //Filter ToMap
        Map<String,List<Department>> empDeptMap = empDptList.stream().filter( x -> x.getDepartment() != null)
                .collect(Collectors.toMap(Employee::getName,Employee::getDepartment,(oldValue,newValue) -> oldValue,LinkedHashMap::new));
        empDeptMap.forEach((k,v) -> System.out.println("K:"+k+"V:"+v));

        Map<String,List<Department>>  sortedempMapWithKey = empDeptMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue, newValue) -> oldValue, LinkedHashMap::new));
        sortedempMapWithKey.forEach((k,v) -> System.out.println(k+""+v));

        //Integer
        int[] intArray = {2,5,1,3};
        System.out.println("Sum ::"+Arrays.stream(intArray).reduce(0,Integer::sum));
        Arrays.stream(intArray).sorted().forEach(System.out::println);


        //GroupBy
        Map<String,Long> empGroupBy = empDptList.stream().collect(Collectors.groupingBy(Employee::getName,Collectors.counting()));
        empGroupBy.forEach((k,v) -> System.out.println("K : "+k+"V :"+v));
    }
    public static void main(String [] args){
        QuickTest4 qt4 = new QuickTest4();
        qt4.test1();
    }

}

class Employee{
    private int id;
    private String name;
    private BigDecimal salary;
    private List<Department> department;

    public Employee(int id, String name, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee(int id, String name, BigDecimal salary, List<Department> department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public List<Department> getDepartment() {
        return department;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }


    public Stream<Department> getDepartmentStream() {
        return this.department.stream();
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}

class Department{
    private int id;
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}