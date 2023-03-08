/*
package quicktests;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickPractice1 {

    public void practiceStreamUsingListAndMap(){
        List<String> list = Arrays.asList("a","Ab","Az","b","c");
        list.forEach(System.out::println);
        list.forEach(x -> System.out.println(x.toUpperCase()));

        list.sort(Comparator.reverseOrder());
        list.forEach(System.out::println);
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        List<String> filteredlist = list.stream().filter(x -> x.startsWith("a") | x.startsWith("A"))
                .sorted(Comparator.comparing(String::length).reversed())
                .collect(Collectors.toList());
        filteredlist.forEach(System.out::println);

        List<Employee> empList = Arrays.asList(new Employee(1,"Raj",BigDecimal.valueOf(10000)),
                new Employee(2,"Ami",BigDecimal.valueOf(2000)),
                new Employee(3,"Heman",BigDecimal.valueOf(4000)),
                new Employee(3,"Roger",BigDecimal.valueOf(5000)));

        List<Employee> filteredList = empList.stream().filter(x -> x.getId() == 2).collect(Collectors.toList());
        filteredList.forEach(System.out::println);

        Employee emp = empList.stream()
                .reduce(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary))).get();
        System.out.println(emp);

        BigDecimal sum = empList.stream().map(x -> x.getSalary())
                .reduce((a,b) -> a.add(b)).get();
        System.out.println(sum);

        BigDecimal sum2 =  empList.stream().filter(x -> x.getName().equalsIgnoreCase("R"))
                .map(Employee::getSalary)
                .reduce((a,b) -> a.add(b)).orElse(BigDecimal.ZERO);
        System.out.println(sum2);

        BigDecimal sum3 =  empList.stream().filter(x -> x.getName().startsWith("R"))
                .map(Employee::getSalary)
                .reduce((a,b) -> a.add(b)).orElse(BigDecimal.ZERO);
        System.out.println(sum3);


        List<Employee> empListWithDept = Arrays.asList(new Employee(1,"Raj",BigDecimal.valueOf(10000)),
                new Employee(2,"Ami",BigDecimal.valueOf(2000),Arrays.asList(new Department(2,"CE"),new Department(2,"BE"))),
                new Employee(3,"Heman",BigDecimal.valueOf(4000),Arrays.asList(new Department(3,"DE"),new Department(2,"BE"))),
                new Employee(3,"Roger",BigDecimal.valueOf(5000),Arrays.asList(new Department(2,"CE"),new Department(2,"DE"))));

        List<String> deptName = empListWithDept.stream()
                .filter(x -> x.getDepartment() != null)
                .flatMap(Employee::getDepartmentStream)
                .map(x -> x.getName())
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        deptName.forEach(System.out::println);

        Map<Integer,List<Department>>  empMapWithDept = empListWithDept.stream()
                .filter(x -> x.getDepartment()!= null)
                .collect(Collectors.toMap(Employee::getId,Employee::getDepartment,(oldValue,newValue) -> oldValue,LinkedHashMap::new));
        empMapWithDept.forEach((k,v) -> System.out.println(k+""+v));

        Map<Integer,List<Department>>  sortedempMapWithKey = empMapWithDept.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldValue, newValue) -> oldValue, LinkedHashMap::new));
        sortedempMapWithKey.forEach((k,v) -> System.out.println(k+""+v));

        int[] inputArray = {1,2,3,4};
        List<Integer> newList = Arrays.stream(inputArray).boxed().collect(Collectors.toList());
        Integer i = newList.stream().max(Comparator.naturalOrder()).get();
        List<Integer> newList1 =newList.stream().filter(a -> a > 2).collect(Collectors.toList());

        newList.forEach(System.out::println);
        System.out.println(i);
        newList1.forEach(System.out::println);

        int[] intArray1 = {3, 6, -2, -5, 7, 3};

        List<Integer> bucket = new ArrayList<>();
        Arrays.stream(intArray1).reduce((a,b) -> {
            bucket.add(a*b);
            return b;
        });
        bucket.forEach(System.out::println);
        System.out.println(bucket.stream().max(Comparator.naturalOrder()));
        System.out.println(bucket.stream().max(Integer::compareTo));
    }


    public static void main(String [] args){
        QuickPractice1 qp = new QuickPractice1();
        qp.practiceStreamUsingListAndMap();

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
}*/
