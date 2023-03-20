package javaconcepts.collectioninterface;

import java.util.Stack;

public class StackTest {

    //Stack is LIFO
    public void test(){
        Stack<Integer> st = new Stack<>();
        System.out.println(st.push(1));
        System.out.println(st.push(2));
        System.out.println(st.peek()); //GET TAIL
        System.out.println(st.pop()); //GET TAIL
        while(st.iterator().hasNext()){
            System.out.println(st.pop()); //GET TAIL
        }
        System.out.println(st.push(5));
        System.out.println(st.search(5));
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
