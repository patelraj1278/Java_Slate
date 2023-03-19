package dsa.easyproblems;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {

    private final int CACHE_SIZE;

    // store keys of cache
    private Deque<Integer> doublyQueue;

    // store references of key in cache
    private HashSet<Integer> hashSet;

    public LRUCache(int capacity) {
        CACHE_SIZE = capacity;
        doublyQueue = new LinkedList<>();
        hashSet = new HashSet<>();
    }

    public void refer(int page)
    {
        if(!hashSet.contains(page)){
            if (doublyQueue.size() == CACHE_SIZE) {
                System.out.println("Condition Hit"+doublyQueue.peek());
                int last = doublyQueue.removeLast();
                hashSet.remove(last);
            }
        }
        doublyQueue.push(page);
        hashSet.add(page);
    }

    public void printHash(){
        hashSet.forEach(x->{
            System.out.println(x);
        });
    }

    public void printQueue(){
        Iterator<Integer> itr = doublyQueue.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }

    public static void main(String [] args){

        //After Cache Capacity hit, If new element try to be add then remove from exisiting.
        LRUCache lc= new LRUCache(4);
        lc.refer(1);
        lc.refer(2);
        lc.refer(3);
        lc.refer(1);
        lc.refer(4);
        lc.refer(5);
        lc.refer(7);
        //lc.printHash();
        lc.printQueue();
    }
}
