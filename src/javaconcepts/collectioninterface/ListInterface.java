package javaconcepts.collectioninterface;

import java.util.*;
import java.util.stream.Collectors;

public class ListInterface {
    public static void main(String args[]) {


        //ArrayList
        ArrayList<String> list = new ArrayList<String>();//Creating arraylist
        list.add("Ravi");//Adding object in arraylist
        list.add("Vijay");
        list.add("Ravi");
        list.add("Ajay");
        list.removeIf(x-> x.equalsIgnoreCase("Vijay"));
        //Traversing list through Iterator
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            if(itr.next().equals("Ravi")){
                itr.remove();
            }
        }
        System.out.println("Final List Result=>"+list);


        //LinkedList
        LinkedList<String> al1 = new LinkedList<String>();
        al1.add("3");
        al1.addFirst("1");
        al1.addLast("4");
        al1.add("2");
        al1.stream().forEach(System.out::println);

        System.out.println("Peek=>"+al1.peek());  //Peek From Head
        System.out.println("Peek First =>"+al1.peekFirst()); //Peek From Head
        System.out.println("Peek Last=>"+al1.peekLast()); ////Peek From Tail

        System.out.println("Offer=>"+al1.offer("5"));  //Add Element to Head - Capacity Driven
        System.out.println("Offer First=>"+al1.offerFirst("0")); //Add Element to Head - Capacity Driven
        System.out.println("Offer Last=>"+al1.offerLast("6")); //Add Element to Last - Capacity Driven
        System.out.println(al1);

        System.out.println("POP =>"+al1.pop());  //Get TAIL
        System.out.println("POLL ->"+al1.poll()); //Get HEAD
        System.out.println("POLL First->"+al1.pollFirst()); //Get HEAD
        System.out.println("POLL First->"+al1.pollLast()); //Get TAIL
        al1.push("10"); //ADD to HEAD
        System.out.println(al1);

        //add,addFirst,addLast
        //offer,offerFirst,offerLast
        //peek,peekFirst,peekLast
        //pop  ->
        //poll,pollFirst,pollLast
        //remove,removeFirst,removeLast

        //pop will throw NoSuchElementException() on empty list, whereas poll returns null
        //The remove() and poll() methods differ only in their behavior when the queue is empty: the remove() method throws an exception, while the poll() method returns null.
        //pop will throw NoSuchElementException() on empty list, whereas poll returns null.
        //Deque push() will push element to the HEAD where Stack push() willpush element to TAIL.

        Iterator<String> itr1 = al1.iterator();
        while (itr1.hasNext()) {
            if(itr1.next().equals("10")){
                itr1.remove();
            }
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
        stack.ensureCapacity(5);
        stack.add("Raj");
        stack.push("Ayush");
        stack.push("Garvit");
        stack.push("Amit");
        stack.push("Ashish");
        stack.push("Garima");
        System.out.println(stack);
        System.out.println("Pop :"+stack.pop());
        System.out.println("Peek :"+stack.peek());
        stack.push("Ami");
        System.out.println("firstElement :"+stack.firstElement());
        System.out.println("lastElement :"+stack.lastElement());
        System.out.println("Search Int :"+stack.search("Amit"));

        Iterator<String> itr3=stack.iterator();
        while(itr3.hasNext()){
            System.out.println(itr3.next());
        }

        //Stack vs Deque push()

        Stack<String> myStack = new Stack<>();
        myStack.push("I am at the bottom.");
        myStack.push("I am in the middle.");
        myStack.push("I am at the top.");

        Iterator<String> it2=myStack.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
        /* assertThat(it).toIterable().containsExactly(
              "I am at the bottom.",
              "I am in the middle.",
              "I am at the top.");*/

        Deque<String> myStack1 = new ArrayDeque<>();
        myStack1.push("I am at the bottom.");
        myStack1.push("I am in the middle.");
        myStack1.push("I am at the top.");

        Iterator<String> itr4=myStack1.iterator();
        while(itr4.hasNext()){
            System.out.println(itr4.next());
        }
        /*assertThat(it).toIterable().containsExactly(
          "I am at the top.",
          "I am in the middle.",
          "I am at the bottom.");*/


    }
}
