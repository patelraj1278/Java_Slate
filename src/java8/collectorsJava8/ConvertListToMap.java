package java8.collectorsJava8;

import java8.functionalInterfaceJava8.consumerJava8.Hosting;

import java.util.*;
import java.util.stream.Collectors;

public class ConvertListToMap {

    public void convertListToMap(){
        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));

        // key = id, value - websites
        Map<Integer,String> map1 = list.stream().collect(Collectors.toMap(Hosting::getId,Hosting::getName));
        System.out.println("Result 1 : " + map1);

        // key = name, value - websites
        Map<String, Long> map2 = list.stream().collect(
                Collectors.toMap(Hosting::getName, Hosting::getWebsites));
        System.out.println("Result 2 : " + map2);

        // Same with result1, just different syntax
        // key = id, value = name
        Map<Integer, String> map3 = list.stream().collect(
                Collectors.toMap(x -> x.getId(), x -> x.getName()));
        System.out.println("Result 3 : " + map3);
    }

    public void convertListToMapAndDuplicate(){
        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "digitalocean.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));

        list.add(new Hosting(6, "linode.com", 100000)); // new line

        //Here To Map Takes 4 parameters (Key to Be, Value to Be, mergeFunction to resolve conflict of Key duplicate, TreeMap as Supplier )
        Map<String, Long> map2 = list.stream().collect(
                Collectors.toMap(Hosting::getName, Hosting::getWebsites, (existing,replacement) -> existing, TreeMap::new));
        System.out.println("Result  : " + map2);

    }
    public static void main(String[] args) {
        ConvertListToMap cMap = new ConvertListToMap();
        cMap.convertListToMap();
        cMap.convertListToMapAndDuplicate();
    }
}
