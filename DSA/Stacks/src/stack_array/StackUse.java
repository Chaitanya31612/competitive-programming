package stack_array;

public class StackUse {
    public static void main(String[] args) throws StackFullException, StackEmptyException {
        StackUsingArray stack = new StackUsingArray();

        System.out.println(stack.size());
        System.out.println(stack.isEmpty());

        stack.push(10);
        stack.push(20);
        System.out.println(stack.pop());
        stack.push(30);

        System.out.println(stack.isEmpty());
        System.out.println(stack.size());

//        stack.pop();
//        stack.pop();
//        stack.pop();

        // push - initial 10
        // gives stackfullexception

//        stack.push(1);
//        stack.push(1);
//        stack.push(1);
//        stack.push(1);
//        stack.push(1);
//        stack.push(1);
//        stack.push(1);
//        stack.push(1);
//        stack.push(1);


        // dynamic_push
        stack.dynamic_push(1);
        stack.dynamic_push(1);
        stack.dynamic_push(1);
        stack.dynamic_push(1);
        stack.dynamic_push(1);
        stack.dynamic_push(1);
        stack.dynamic_push(1);
        stack.dynamic_push(1);
        stack.dynamic_push(1);
        System.out.println(stack.size());

        stack.print();
    }
}
