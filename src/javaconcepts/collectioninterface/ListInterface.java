package javaconcepts.collectioninterface;

import java.util.*;

public class ListInterface {
    public static void main(String args[]) {


        //ArrayList
        ArrayList<String> list = new ArrayList<String>();//Creating arraylist
        list.add("Ravi");//Adding object in arraylist
        list.add("Vijay");
        list.add("Ravi");
        list.add("Ajay");
        //Traversing list through Iterator
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        //LinkedList
        LinkedList<String> al1 = new LinkedList<String>();
        al1.add("Ravi");
        al1.add("Vijay");
        al1.add("Ravi");
        al1.add("Ajay");
        Iterator<String> itr1 = al1.iterator();
        while (itr.hasNext()) {
            System.out.println(itr1.next());
        }

        //Vector
        Vector<String> v1 = new Vector<String>();
        v1.add("Ayush");
        v1.add("Amit");
        v1.add("Ashish");
        v1.add("Garima");
        Iterator<String> itr2 = v1.iterator();

        while (itr2.hasNext()) {
            System.out.println(itr2.next());
        }

        //Stack
        Stack<String> stack = new Stack<String>();
        stack.push("Ayush");
        stack.push("Garvit");
        stack.push("Amit");
        stack.push("Ashish");
        stack.push("Garima");
        stack.pop();
        System.out.println("Peek :"+stack.peek());
        Iterator<String> itr3=stack.iterator();
        while(itr3.hasNext()){
            System.out.println(itr3.next());
        }
    }
}
