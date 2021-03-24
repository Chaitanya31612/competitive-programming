import java.util.Scanner;
import java.util.Stack;

public class ReverseStack {

    public static void insert_bottom(Stack<Integer> stack, int elem) {
        if(stack.isEmpty()) {
           stack.push(elem);
        } else {

            int x = stack.pop();

            insert_bottom(stack, elem);

            stack.push(x);
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if(!stack.isEmpty()) {

            int x = stack.pop();
            reverse(stack);

            insert_bottom(stack, x);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
        System.out.println(stack.peek());
    }
}
