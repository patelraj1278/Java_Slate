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
            if(!itr.next().equals("Ravi")){
                itr.remove();
            }
        }
        System.out.println(list);


        //LinkedList
        LinkedList<String> al1 = new LinkedList<String>();
        al1.add("1");
        al1.add("2");
        al1.add("3");
        al1.add("4");
        al1.removeFirst();
        al1.remove(); //Remove from Head
        al1.poll();
        al1.pop();
        al1.peek();

        //peek
        //poll
        //pop
        //remove
        //add
        //offer

        //pop will throw NoSuchElementException() on empty list, whereas poll returns null.


        Iterator<String> itr1 = al1.iterator();
        while (itr.hasNext()) {
            System.out.println(itr1.next());
            itr.remove();
        }
        System.out.println(al1);

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
