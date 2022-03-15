package java8.functionJava8;

import java.util.*;
import java.util.function.Function;

public class Java8Function {

    public void java8Function1(String s){
        Function<String,Integer> func = t -> t.length();
        Integer result = func.apply(s);
        System.out.println(result);
    }

    public void java8ChainFunction(String s){
        Function<String,Integer> func = t -> t.length();

        Function<Integer, Integer> func2 = x -> x * 2;

        Integer result =  func.andThen(func2).apply(s);
        System.out.println(result);
    }

    public void java8ListToMapUsingFunction(){
        List<String> list = Arrays.asList("node", "c++", "java", "javascript");

        // lambda
        Map<String, Integer> map = convertListToMap(list, x -> x.length());
        System.out.println(map);    // {node=4, c++=3, java=4, javascript=10}

        // method reference
        Map<String, Integer> map2 = convertListToMap(list,this::getLength);
        System.out.println(map2);

    }


    public void java8ListToListUsingFunction(){

        List<String> list = Arrays.asList("NODE", "C++", "JAVA", "JAVASCRIPT");

        // lambda
        List<String> returnList1 = convertListToList(list, x-> x.toLowerCase());

        // method reference
        List<String> returnList2 = convertListToList(list,this::getLowerCase);

        returnList1.forEach(System.out::println);
        returnList2.forEach(System.out::println);
    }


    public static void main(String [] args){

        Java8Function jf = new Java8Function();
        jf.java8Function1("mkyong");
        jf.java8ChainFunction("mkyong");
        jf.java8ListToMapUsingFunction();
        jf.java8ListToListUsingFunction();
    }

    public <T,R> Map<T,R> convertListToMap(List<T> list,Function<T,R> func){
        Map<T, R> result = new HashMap<>();

        for(T t: list){
            result.put(t, func.apply(t));
        }
        return result;
    }

    public Integer getLength(String str) {
        return str.length();
    }


    public <T,R> List<R> convertListToList(List<T> list, Function<T,R> func){
        List<R> result = new ArrayList<>();
        for(T t : list){
            result.add(func.apply(t));
        }
        return result;
    }

    public String getLowerCase(String str){
        return str.toLowerCase();
    }
}
