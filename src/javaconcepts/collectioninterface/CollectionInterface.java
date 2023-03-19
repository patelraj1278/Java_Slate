package javaconcepts.collectioninterface;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CollectionInterface {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        // inserts the specified element in this collection
        set.add(2);
        set.add(5);
        System.out.println("Initial collection :"+set);
        //it adds all the elements of specified collection in the invoking collection.
        Collections.addAll(set, 11, 12, 13, 14, 15);
        System.out.println("Final Collection : "+set);
        //returns the total size of the collection
        int size =set.size();
        System.out.println("Size of Collection : "+size);
        //It returns a Boolean value true if this queue contains the specified element.
        Boolean val=set.contains(5);
        if (val){
            System.out.println("5 is present in the collection");
        }
        else{
            System.out.println("5 is not present in the collection");
        }
        //It removes all the elements automatically from this collection.
        set.clear();
        System.out.println("Elements in collection : "+set);
    }
}
