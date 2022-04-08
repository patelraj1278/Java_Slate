package javaconcepts.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetInterface {
    public static void main(String args[]) {

        //Creating HashSet and adding elements
        HashSet<String> set = new HashSet<String>();
        set.add("Ravi");
        set.add("Vijay");
        set.add("Ravi");
        set.add("Ajay");
        //Traversing elements
        Iterator<String> itr = set.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        LinkedHashSet<String> set1 = new LinkedHashSet<String>();
        set1.add("Ravi");
        set1.add("Vijay");
        set1.add("Ravi");
        set1.add("Ajay");
        Iterator<String> itr1 = set1.iterator();
        while (itr1.hasNext()) {
            System.out.println(itr1.next());
        }

        //Creating and adding elements
        TreeSet<String> set2 = new TreeSet<String>();
        set2.add("Ravi");
        set2.add("Vijay");
        set2.add("Ravi");
        set2.add("Ajay");
        //traversing elements
        Iterator<String> itr2 = set.iterator();
        while (itr2.hasNext()) {
            System.out.println(itr2.next());
        }
   }
}
