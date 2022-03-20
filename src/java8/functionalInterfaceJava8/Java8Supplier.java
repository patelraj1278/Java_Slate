package java8.functionalInterfaceJava8;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Java8Supplier<T> {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    //1.1 This example uses Supplier to return a current date-time.
    public void java8Supplier1(){
        Supplier<LocalDateTime> s = () -> LocalDateTime.now();
        LocalDateTime time = s.get();
        System.out.println(time);

        Supplier<String> s1 = () -> dtf.format(LocalDateTime.now());
        String time2 = s1.get();

        System.out.println(time2);
    }

    //2. Returns a Supplier
    public void java8Supplier2(){
        Java8Supplier<String> obj = new Java8Supplier();

        List<String> list = obj.supplier().get();
    }

    //3. Factory
    //3.1 A simple factory method to return a Developer object.
    public void java8Supplier3(){
        Employee emp = factory(Employee::new);
        System.out.println(emp);

        Employee emp1 = factory(() -> new Employee("mkyong"));
        System.out.println(emp1);
    }

    public static void main(String[] args) {
        Java8Supplier js = new Java8Supplier();
        js.java8Supplier1();
        js.java8Supplier2();
        js.java8Supplier3();

    }

    public Supplier<List<T>> supplier(){
        // lambda
        // return () -> new ArrayList<>();

        // constructor reference
        return ArrayList::new;
    }

    public static Employee factory(Supplier<? extends Employee> s){
        Employee employee = s.get();
        if (employee.getName() == null || "".equals(employee.getName())) {
            employee.setName("default");
        }
        employee.setSalary(BigDecimal.ONE);
        employee.setStart(LocalDate.of(2017, 8, 8));

        return employee;
    }
}
