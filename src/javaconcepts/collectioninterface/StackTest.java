package javaconcepts.collectioninterface;

import java.util.Stack;
import java.util.Vector;

public class StackTest {

    //Stack is LIFO
    public void test(){
        Stack<Integer> st = new Stack<>();
        System.out.println(st.push(1));
        System.out.println(st.push(2));
        System.out.println(st.peek());
        System.out.println(st.pop());
        while(st.iterator().hasNext()){
            System.out.println(st.pop());
        }

        //System.out.println(st.add(2));
        //System.out.println(st.empty());
        //System.out.println(st.capacity());
        //System.out.println(st.firstElement());
        //System.out.println(st.lastElement());

    }
    public static void main(String args[]) {
        StackTest st = new StackTest();
        st.test();

    }
}
