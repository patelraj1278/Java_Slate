package javaconcepts.collectioninterface;

import java.util.*;

public class SetInterface {
    public static void main(String args[]) {

        //Creating HashSet and adding elements
        HashSet<String> set = new HashSet<String>();
        set.add("Ravi");
        set.add("Vijay");
        set.add("Ravi");
        set.add("Ajay");
        //Traversing elements
        /*Iterator<String> itr = set.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }*/

        LinkedHashSet<String> set1 = new LinkedHashSet<String>();
        set1.add("Ravi");
        set1.add("Vijay");
        set1.add("Ravi");
        set1.add("Ajay");
       /* Iterator<String> itr1 = set1.iterator();
        while (itr1.hasNext()) {
            System.out.println(itr1.next());
        }*/

        //Creating and adding elements
        TreeSet<String> set2 = new TreeSet<String>();
        set2.add("1");
        set2.add("2");
        set2.add("3");
        set2.add("4");
        //traversing elements
        /*Iterator<String> itr2 = set.iterator();
        while (itr2.hasNext()) {
            System.out.println(itr2.next());
        }*/
        System.out.println(set2.subSet("2",true,"3",false));

        System.out.println("Poll First:=>"+set2.pollFirst());
        System.out.println(set2.headSet("3",true));
        NavigableSet<String> bs = set2.descendingSet();
        //System.out.println(bs.subSet("1",true,"3",false));
        System.out.println(bs.headSet("3",true));

   }
}
