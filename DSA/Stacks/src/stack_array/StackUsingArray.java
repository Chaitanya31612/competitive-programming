package stack_array;

public class StackUsingArray {

    private int data[];
    private int top;

    public StackUsingArray() {
        data = new int[10];
        top = -1;
    }

    public StackUsingArray(int capacity) {
        data = new int[capacity];
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public int top() throws StackEmptyException {
        if(size() == 0) {
            // Stack Empty Exception
            StackEmptyException e = new StackEmptyException();
            throw e;
        }

        return data[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public void push(int elem) throws StackFullException {
        if(size() == data.length) {
            // Stack Full Exception
            StackFullException e = new StackFullException();
            throw e;
        }

        top++;
        data[top] = elem;
    }

    public void dynamic_push(int elem) {

        if(size() == data.length) {
            int[] temp = new int[2 * data.length];
            for(int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }

        top++;
        data[top] = elem;
    }

    public int pop() throws StackEmptyException {
        if(size() == 0) {
            // Stack Empty Exception
            StackEmptyException e = new StackEmptyException();
            throw e;
        }

        int temp = data[top];
        top--;
        return temp;
    }

    public void print() {
        for(int i = top; i >= 0; i--) {
            System.out.print(data[top] + " ");
        }
        System.out.println();
    }

}
