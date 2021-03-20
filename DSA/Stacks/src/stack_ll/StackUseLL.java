package stack_ll;

import stack_array.StackEmptyException;

public class StackUseLL {
    public static void main(String[] args) throws StackEmptyException {
        StackUsingLL stack = new StackUsingLL();

        System.out.println(stack.size());
        System.out.println(stack.isEmpty());

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println(stack.size());
        System.out.println(stack.peek());

        stack.pop();
        System.out.println(stack.peek());
    }
}
