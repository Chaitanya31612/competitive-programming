import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class MaxAreaHistogram {

    /* Time - O(n) */
    public int getMaxArea(int[] hist, int n) {
        Stack<Integer> s = new Stack<>();
        int maxArea = Integer.MIN_VALUE;

        int i = 0;
        // traverse from left to right
        while(i < n) {
            if(s.isEmpty() || hist[s.peek()] <= hist[i]) {
                s.push(i++);
            }
            // if next bar is smaller so it cannot contribute to max area
            else {
                int top = s.pop();
                // calculate area with top
                int currentArea = hist[top] * (s.isEmpty() ? i : (i - s.peek() - 1));

                maxArea = Math.max(maxArea, currentArea);
            }
        }

        while(!s.isEmpty()) {
            int top = s.pop();
            // calculate area with top
            int currentArea = hist[top] * (s.isEmpty() ? i : (i - s.peek() - 1));

            maxArea = Math.max(maxArea, currentArea);
        }
        return maxArea;
    }

    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        MaxAreaHistogram m = new MaxAreaHistogram();
        System.out.println(m.getMaxArea(arr, n));

    }
}

/* Sample Input
7
6 2 5 4 5 1 6

out
12
* */