package dsa.mycode;


public class LinkedList {
    Node head;
    static class Node{
        int data;
        Node next;

        Node(int d){
            data=d;
            next=null;
        }
    }
    public static LinkedList insert(LinkedList list, int data){
        Node new_node = new Node(data);
        if(list.head == null){
            list.head = new_node;
        }else{
            Node last = list.head;
            while(last.next != null){
                last=last.next;
            }
            last.next=new_node;
        }
        return list;
    }

    public static void insert_at_position(LinkedList list, int data, int position){
        Node new_node = new Node(data);
        if(position < 1){
            System.out.println("Invalid Position");
        }
        if(position == 1){
            new_node.next=list.head;
            list.head = new_node;
            System.out.println("Node Data index:"+position+"--Data:"+list.head.data);
        }else{
            Node last = list.head;
            System.out.println("for position==>"+position);
            while(--position > 1){  //Put Pointer to N-1th of Position number.
                last=last.next;
            }
            System.out.println("Pointer at Data==>"+last.data+",last.next==>"+last.next);
            new_node.next=last.next;
            last.next=new_node;
        }
    }

    public static LinkedList delete_node_position(LinkedList list, int position){
        if(position < 1){
            System.out.println("Invalid Position");
        }
        if(position == 1){
            System.out.println("head next"+list.head+"head data"+list.head.data);
            list.head=list.head.next;
        }else{
            Node last = list.head;
            while(--position > 1){
                last=last.next;
            }
            last.next=last.next.next;
        }
        return list;
    }

    public static LinkedList reverseLinkedListUsingLinear(LinkedList list){
        Node current = list.head;
        Node prev = null;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        list.head=prev;

        return list;
    }

    public static void reverseLinkedListUsingRecursion(Node node){
        if(node.next == null){
            return;
        }
        reverseLinkedListUsingRecursion(node.next);
        node.next.next=node;
        node.next=null;
    }

    public static void recursiveReversePrint(Node node){
        if(node == null){
            System.out.println("Inside Node ");
            return;
        }
        recursiveReversePrint(node.next);
        System.out.println("Data "+node.data);
    }

    public static void recursivePrint(Node node){
        if(node == null){
            System.out.println("Inside Node ");
            return;
        }
        System.out.println("Data "+node.data);
        recursivePrint(node.next);

    }

    public static void printf(LinkedList list){
        System.out.println("Linked List: ");
        Node currNode = list.head;
        while(currNode != null){
            System.out.println("Node Data "+currNode.data);
            currNode = currNode.next;
        }
    }

    public static void main(String [] args){
        LinkedList ls = new LinkedList();
        printf(insert(ls,1));
        printf(insert(ls,2));
        printf(insert(ls,3));
        //insert_at_position(ls, 2, 1);
        //insert_at_position(ls, 3, 2);
        //insert_at_position(ls, 4, 3);
        //insert_at_position(ls, 5, 4);
        //insert_at_position(ls,6,2);
        printf(delete_node_position(ls,2));
        //recursiveReversePrint(ls.head);
        //recursivePrint(ls.head);
        printf(reverseLinkedListUsingLinear(ls));
        //reverseLinkedListUsingRecursion(ls.head); //Not Working
    }

}
