package dsa.mycode;

public class Queue {

    private int[] data;
    private int front;
    private int rear;
    private int size;

    public Queue(int capacity) {
        data = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public int size() {
        return size;
    }

    public void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % data.length;
        data[rear] = value;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = data[front];
        front = (front + 1) % data.length;
        size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return data[front];
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("Queue: " + queue);

        int element = queue.dequeue();
        System.out.println("Dequeued element: " + element);

        System.out.println("Queue: " + queue);

        int frontElement = queue.peek();
        System.out.println("Front element: " + frontElement);

        System.out.println("Queue size: " + queue.size());

        queue.enqueue(6);
        System.out.println("Queue: " + queue);
    }
}