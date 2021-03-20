import java.util.Scanner;
import java.util.Stack;

public class StackClass<T> {

    public static int getMin(Stack<Integer> s) {
        Stack<Integer> temp = s;
        int min = Integer.MAX_VALUE;
        while(!temp.isEmpty()) {
            if(temp.peek() < min) {
                min = temp.peek();
            }
            temp.pop();
        }
        return min;
    }

    public static void print(Stack<Integer> stack) {
        Stack<Integer> temp = stack;
        while(!temp.isEmpty()) {
            System.out.print(temp.pop() + " ");
        }
        System.out.println();
    }

    public static Stack<Integer> takeInput() {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int data = sc.nextInt();
        while(data != -1) {
            stack.push(data);
            data = sc.nextInt();
        }

        return stack;
    }
}
