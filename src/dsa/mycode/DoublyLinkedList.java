package dsa.mycode;

public class DoublyLinkedList {

    class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }


        Node head;

        public DoublyLinkedList() {
            this.head = null;
        }

        public void addNode(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head  = newNode;
            } else {
                head.prev = newNode;
                newNode.next = head;
                head = newNode;
            }
        }

        public void printList() {
            Node current = head;
            if (current == null) {
                System.out.println("List is empty");
                return;
            }
            System.out.println("Nodes of doubly linked list: ");
            while (current != null) {
                System.out.print(" Previous "+current.prev+" Current "+current.data + " Next "+ current.next.data+"\n");
                current = current.next;
            }
        }

        public static void main(String [] args){
            DoublyLinkedList dls = new DoublyLinkedList();
            dls.addNode(1);
            dls.addNode(2);
            dls.addNode(3);
            dls.printList();

        }
}

