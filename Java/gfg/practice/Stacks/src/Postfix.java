import java.util.Scanner;
import java.util.Stack;

public class Postfix {

    public static int evaluatePostFix(String str) {
        // *, /, + and -.
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '*') {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b*a);
            } else if(ch == '/') {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            } else if(ch == '-') {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            } else if(ch == '+') {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b+a);
            } else {
                int num = Integer.parseInt(String.valueOf(ch));
                stack.push(num);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(evaluatePostFix(str));
    }
}
