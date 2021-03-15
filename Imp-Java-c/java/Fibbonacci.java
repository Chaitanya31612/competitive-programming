import java.util.*;

public class Fibbonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[100];
        System.out.println(fib(n, dp));
        System.out.println(fibBU(n));
        System.out.println(fibO(n));
    }

    // Top down approch
    static int fib(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (dp[n] != 0) {
            return dp[n];
        }
        int ans = fib(n - 1, dp) + fib(n - 2, dp);
        return dp[n] = ans;
    }
    
    // Bottom up approach
    static int fibBU(int n) {
        int[] dp = new int[100];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Bottom up with optimised space complexity
    static int fibO(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}