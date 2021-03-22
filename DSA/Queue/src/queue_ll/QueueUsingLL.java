package queue_ll;

import queue_array.QueueEmptyException;

public class QueueUsingLL<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public QueueUsingLL() {
        this.front = null;
        this.rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public T front() throws QueueEmptyException {
        if(isEmpty()) {
            throw new QueueEmptyException();
        }

        return front.data;
    }

    public void enqueue(T element) {
        // insertion at rear end
        Node<T> newNode = new Node<>(element);
        newNode.next = null;
        if(isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T dequeue() throws QueueEmptyException {
        // deletion at front end
        if(isEmpty()) {
            throw new QueueEmptyException();
        }

        T temp = front.data;
        if(front == rear) {
            front = rear = null;
        } else {
            front = front.next;
        }
        size--;
        return temp;
    }
}
