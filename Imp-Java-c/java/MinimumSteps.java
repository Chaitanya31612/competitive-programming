import java.util.*;

public class MinimumSteps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[100];
        System.out.println(minSteps(n, dp));
        System.out.println(minStepsBU(n));
    }

    // Top down approach
    static int minSteps(int n, int[] dp) {
        // Base case
        if (n == 1) {
            return 0;
        }
        // Rec case
        // lookup in array
        if (dp[n] != 0) {
            return dp[n];
        }

        // Compute if not known
        int op1, op2, op3;
        op1 = op2 = op3 = Integer.MAX_VALUE;
        if (n % 3 == 0) {
            op1 = minSteps(n / 3, dp) + 1;
        }
        if (n % 2 == 0) {
            op2 = minSteps(n / 2, dp) + 1;
        }
        op3 = minSteps(n - 1, dp) + 1;

        int ans = Math.min(Math.min(op1, op2), op3);
        return dp[n] = ans;
    }
    // Bottom up approach
    static int minStepsBU(int n) {
        int[] dp = new int[100];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int op1, op2, op3;
            op1 = op2 = op3 = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                op1 = dp[i / 3];
            }
            if (i % 2 == 0) {
                op2 = dp[i / 2];
            }
            op3 = dp[i - 1];
            dp[i] = Math.min(Math.min(op1, op2), op3) + 1;
        }
        
        return dp[n];
    }
}