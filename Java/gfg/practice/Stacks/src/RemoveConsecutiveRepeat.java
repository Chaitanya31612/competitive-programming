import java.util.Scanner;
import java.util.Stack;

public class RemoveConsecutiveRepeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            long n = sc.nextLong();

            Stack<Long> stack = new Stack<>();
            while(n > 0) {
                long el = n % 10;
                if(stack.size() == 0 || stack.peek() != el) {
                    stack.push(el);
                }
                n = n / 10;
            }
            n = 0;
            while(!stack.isEmpty()) {
                n = n * 10 + stack.pop();
            }
            System.out.println(n);
        }
    }
}
