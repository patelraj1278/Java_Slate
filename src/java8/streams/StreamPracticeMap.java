package java8.streams;

import java8.streams.model.Staff;
import java8.streams.model.StaffPublic;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPracticeMap {

    //1.1 Simple Java example to convert a list of Strings to upper case.
    public void listOfStringToUpperCase(){

        List<String> alpha = Arrays.asList("a", "b", "c", "d");
        List<String> filteredAlpha = alpha.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());
        filteredAlpha.forEach(System.out::println);

        //Or
        List<String> filteredAlpha2 = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
        filteredAlpha2.forEach(System.out::println);

        // Extra, streams apply to any data type.
        List<Integer> num = Arrays.asList(1,2,3,4,5);
        List<Integer> collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println(collect1); //[2, 4, 6, 8, 10]

    }

    //2. List of objects -> List of String
    //2.1 Get all the name values from a list of the staff objects.
    public void listOfStringsOperation(){
        List<Staff> staff = Arrays.asList(
                new Staff("mkyong", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );
        List<String> getNames = staff.stream().map(Staff::getName).collect(Collectors.toList());
        System.out.println(getNames);
    }

    //3. List of objects -> List of other objects
    //3.1 This example shows you how to convert a list of staff objects into a list of StaffPublic objects.
    public void listOfObjectToListOfStings(){
        List<Staff> staff = Arrays.asList(
                new Staff("mkyong", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );

        List<StaffPublic> staffPublics = staff.stream().map(temp -> {
            StaffPublic newObj = new StaffPublic();
            newObj.setAge(temp.getAge());
            newObj.setName(temp.getName());
            if(temp.getName().equalsIgnoreCase("mkyong")){
                newObj.setExtra("MkYong Rocks");
            }
            return newObj;
        }).collect(Collectors.toList());

        System.out.println(staffPublics);
    }

    public static void main(String []  args){
        StreamPracticeMap sp = new StreamPracticeMap();
        //sp.listOfStringToUpperCase();
        //sp.listOfStringsOperation();
        sp.listOfObjectToListOfStings();
    }
}
