package stack_ll;

import stack_array.StackEmptyException;

public class StackUsingLL {
    private Node top;
    private int size;

    public StackUsingLL() {
        top = null;
        size = 0;
    }

    public void push(int elem) {
        Node newNode = new Node(elem);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public int pop() throws StackEmptyException {
        if(top == null) {
            StackEmptyException e = new StackEmptyException();
            throw e;
        }

        int temp = top.data;
        top = top.next;
        size--;
        return temp;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public int peek() throws StackEmptyException {
        if(top == null) {
            StackEmptyException e = new StackEmptyException();
            throw e;
        }

        return top.data;
    }

    public int size() {
        return size;
    }
}
