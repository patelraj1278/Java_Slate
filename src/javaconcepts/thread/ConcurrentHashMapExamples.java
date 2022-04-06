package javaconcepts.thread;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExamples {

    public static void main(String args[]) {
        // Creates a ConcurrentHashMap with default capacity
        ConcurrentHashMap programmingLanguages = new ConcurrentHashMap();
        System.out.println("Empty ConcurrentHashMap : " + programmingLanguages);

        // Adding objects into ConcurrentHashMap
        programmingLanguages.put("Java", Integer.valueOf(18));
        programmingLanguages.put("Scala", Integer.valueOf(10));
        programmingLanguages.put("C++", Integer.valueOf(31));
        programmingLanguages.put("C", Integer.valueOf(41));
        System.out.println("ConcurrentHashMap with four mappings : " + programmingLanguages);


        // Checking if a key exists in ConcurrentHashMap or not

        boolean isJavaExist = programmingLanguages.containsKey("Java");
        boolean isPythonExist = programmingLanguages.containsKey("Python");
        System.out.printf("Does Programming language Map has %s? %b %n", "Java", isJavaExist);
        System.out.printf("Does Programming language Map contains %s? %b %n", "Python", isPythonExist);



        // Retrieving values from ConcurrentHashMap in Java
        int howOldIsJava = (int) programmingLanguages.get("Java");
        int howOldIsC = (int) programmingLanguages.get("C");
        System.out.printf("How old is Java programming langugae? %d years %n", howOldIsJava);
        System.out.printf("How old is C langugae? %d years %n", howOldIsC);

        // Checking if a value exists in ConcurrentHashMap
        boolean is41Present = programmingLanguages.containsValue(Integer.valueOf(41));
        boolean is31Present = programmingLanguages.containsValue(Integer.valueOf(31));
        System.out.printf("Does value 41 is present in ConcurrentHashMap? %b %n", is41Present);
        System.out.printf("Does value 31 is present in ConcurrentHashMap? %b %n", is31Present);


        // Finding Size of ConcurrentHashMap
        int numberOfMappings = programmingLanguages.size();
        System.out.printf("ConcurrentHashMap %s, contains %d mappings %n", programmingLanguages, numberOfMappings);

        // Loop over ConcurrentHashMap in Java
        Set<Map.Entry<String, Integer>> entrySet = programmingLanguages.entrySet();
        for (Map.Entry mapping : entrySet) {
            System.out.printf("Key : %s, Value: %s %n", mapping.getKey(), mapping.getValue()); }



        // PutIfAbsent Example - Adding keys only // if its not present in ConcurrentHashMap
        System.out.printf("Before : %s %n", programmingLanguages);

        programmingLanguages.putIfAbsent("Java", 22);

        // Already exists
        System.out.printf("After : %s %n", programmingLanguages);
        programmingLanguages.put("Python", 23);

        // Added
        System.out.printf("After : %s %n", programmingLanguages);

        // Replacing a Mapping in ConcurrentHashMap
        programmingLanguages.replace("Java", 20);
        System.out.println("ConcurrentHashMap After replace : " + programmingLanguages);


        // Removing key values from ConcurrentHashMap
        programmingLanguages.remove("C++");
        System.out.println("ConcurrentHashMap After remove : " + programmingLanguages);


        // Removing Keys, while Iterating over ConcurrentHashMap
        Iterator keys = programmingLanguages.keySet().iterator();
        while (keys.hasNext()) {
            System.out.printf("Removing key %s from ConcurrentHashMap %n", keys.next()); keys.remove();
        }

        // How to check if ConcurrentHashMap is empty
        boolean isEmpty = programmingLanguages.isEmpty();
        System.out.printf("Is ConcurrentHashMap %s is empty? %b ", programmingLanguages, isEmpty);


    }
}
