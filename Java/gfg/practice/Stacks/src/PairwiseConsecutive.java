import java.util.Scanner;
import java.util.Stack;

public class PairwiseConsecutive {

    public static boolean pairWiseConsecutive(Stack<Integer> st) {
        if(st.size() % 2 != 0) {
          st.pop();
        }

        while(st.size() >= 2) {
            if(Math.abs(st.pop() - st.pop()) == 1) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        System.out.println(pairWiseConsecutive(stack));
    }
}
