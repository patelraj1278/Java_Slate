package java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSorting {

    //1.1 Sort a List with Comparator.naturalOrder()
    public void streamSorting1(){
        List<String> list = Arrays.asList("9", "A", "Z", "1", "B", "Y", "4", "a", "c");
         /*
		List<String> sortedList = list.stream()
			.sorted(Comparator.naturalOrder())
			.collect(Collectors.toList());

        List<String> sortedList = list.stream()
			.sorted((o1,o2)-> o1.compareTo(o2))
			.collect(Collectors.toList());
		*/

        List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
        sortedList.forEach(System.out::println);
    }


    //1.2 Sort a List with Comparator.reverseOrder()
    public void streamSorting2(){
        List<String> list = Arrays.asList("9", "A", "Z", "1", "B", "Y", "4", "a", "c");
         /*
		List<String> sortedList = list.stream()
			.sorted((o1,o2)-> o2.compareTo(o1))
			.collect(Collectors.toList());
		*/

        List<String> sortedList = list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        sortedList.forEach(System.out::println);
    }


    //2. List Objects
    //1.1 Sort by age, natural order.
    public void streamSorting3(){
        List<User> users = Arrays.asList(
                new User("C", 30),
                new User("D", 40),
                new User("A", 10),
                new User("B", 20),
                new User("E", 50));

        List<User> sortedList = users.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .collect(Collectors.toList());

        sortedList.forEach(System.out::println);
    }

    public static void main(String [] args){
        StreamSorting ss = new StreamSorting();
        //ss.streamSorting1();
        //ss.streamSorting2();
        ss.streamSorting3();
    }


}

class User {

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
