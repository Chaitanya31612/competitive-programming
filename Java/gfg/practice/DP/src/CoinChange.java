import java.util.Scanner;

public class CoinChange {

    // this give the total possible number of ways
    static int ans = 0;
    public static int minCoins(int[] S, int m, int n) {
        if(n == 0) {
            ans++;
            return 0;
        }

        int a = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            if(n - S[i] >= 0) {
                int subAns = 1 + minCoins(S, m, n - S[i]);
                a = Math.min(a, subAns);
            }
        }

        return a;
    }

    public static long coinChangeDP(int[] S, int m, int n) {
        // each index of the dp array indicates number of coins required for n = i
        long[] dp = new long[n + 1];

        // base case
        dp[0] = 1;

        // traversing all the coins and for each coins finding number of ways
        for(int i = 0; i < m; i++) {
            for(int j = S[i]; j <= n; j++) {
                dp[j] += dp[j - S[i]];
            }
        }

        return dp[n];
    }

    public static int coinChange(int[] S, int m, int n) {
        // when n becomes 0 means we found a solution
        if(n == 0) {
            return 1;
        }

        if(n < 0) {
            return 0;
        }

        if(m <= 0) {
            return 0;
        }

        return coinChange(S, m - 1, n) + coinChange(S, m, n - S[m - 1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] S = new int[m];
        for(int i = 0; i < m; i++) {
            S[i] = sc.nextInt();
        }

        System.out.println(coinChangeDP(S, m, n));
    }
}
