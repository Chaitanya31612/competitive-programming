import java.util.Scanner;
import java.util.Stack;

public class NextGreater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        int finalMax = stack.peek();
        int max = stack.peek();
        ans[0] = -1;
        int j = 1;
        while(stack.size() > 1) {
            int temp = stack.pop();
            int secondLast = stack.peek();
            if(temp > secondLast) {
                if(temp > finalMax) {
                    finalMax = temp;
                }
                max = temp;
                ans[j++] = max;
            } else if(max > secondLast) {
                ans[j++] = max;
            } else {

                if(finalMax > secondLast) {
                    ans[j++] = finalMax;
                } else {
                    ans[j++] = -1;
                }
            }
        }

        for(int i = n-1; i >= 0; i--) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
