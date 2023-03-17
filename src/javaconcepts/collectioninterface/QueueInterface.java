package javaconcepts.collectioninterface;

import java.util.*;

public class QueueInterface {
    public static void main(String args[]) {
        Queue<String> queue = new PriorityQueue<String>();
        queue.add("Amit Sharma");
        queue.add("Vijay Raj");
        queue.add("JaiShankar");
        queue.add("Raj");
        System.out.println("head:" + queue.element());
        System.out.println("head:" + queue.peek());
        System.out.println("iterating the queue elements:");
        Iterator itr = queue.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        queue.remove(); //Remove From Head
        queue.poll(); //Remove From Head
        System.out.println("after removing two elements:");
        Iterator<String> itr2 = queue.iterator();
        while (itr2.hasNext()) {
            System.out.println(itr2.next());
        }

        //Creating Deque and adding elements
        Deque<String> deque = new ArrayDeque<String>();
        deque.add("Gautam");
        deque.add("Karan");
        deque.add("Ajay"); //Add to the Tail
        deque.remove();  //Remove From Head
        deque.offer("Hello"); //Add to the Tail - Use for Capacity Restricted Queue
        deque.push("Hi"); //Add to The Head
        //deque.pop(); //Remove From Tail
        for (String str : deque) {
            System.out.println(str);
        }
    }
}
