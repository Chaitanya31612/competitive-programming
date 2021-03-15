import java.util.Arrays;

public class min_coins {
    public static void main(String[] args) {
        int n = 15;
        int[] coins = { 1, 7, 10 };
        int[] dp = new int[100];
        System.out.println(minCoinsTD(n, coins, coins.length, dp));
        System.out.println(Arrays.toString(dp));
        // System.out.println(minCoinsBU(n, coins, coins.length));
    }

    static int minCoinsTD(int n, int[] coins, int T, int[] dp) {
        // Base case
        if (n == 0) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < T; i++) {
            if (n - coins[i] >= 0) {
                int subprob = minCoinsTD(n - coins[i], coins, T, dp);
                ans = Integer.min(ans, subprob + 1);
            }
        }
        return dp[n] = ans;
    }

    static int minCoinsBU(int n, int[] coins, int T) {
        int[] dp = new int[100];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int t = 0; t < T; t++) {
                if (i - coins[t] >= 0) {
                    int subprob = dp[i - coins[t]];
                    dp[i] = Math.min(dp[i], subprob+1);
                }
            }
        }
        return dp[n];
    }
}