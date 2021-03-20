package stack_ll;

import stack_array.StackEmptyException;

public class StackUsingLLGeneric<T> {
    private NodeGeneric<T> top;
    private int size;

    public StackUsingLLGeneric() {
        top = null;
        size = 0;
    }

    public void push(T elem) {
        NodeGeneric<T> newNode = new NodeGeneric<>(elem);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() throws StackEmptyException {
        if(top == null) {
            StackEmptyException e = new StackEmptyException();
            throw e;
        }

        T temp = top.data;
        top = top.next;
        size--;
        return temp;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public T peek() throws StackEmptyException {
        if(top == null) {
//            StackEmptyException e = new StackEmptyException();
            throw new StackEmptyException();
        }

        return top.data;
    }

    public int size() {
        return size;
    }
}
