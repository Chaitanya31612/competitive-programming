import java.util.Scanner;

public class KnaksackDP {

    public static int knapsack(int n, int W, int[] val, int[] wt) {
        int[][] dp = new int[n + 1][W + 1];

        for(int i = 0; i < n; i++) {
            for(int w = 1; w <= W; w++) {
                if(wt[i] <= w) {
                    dp[i+1][w] = Math.max(val[i] + dp[i][w-wt[i]], dp[i][w]);
                } else {
                    dp[i+1][w] = dp[i][w];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int w = sc.nextInt();

        int[] val = new int[n];
        int[] wt = new int[n];

        for(int i = 0; i < n; i++)
            val[i] = sc.nextInt();

        for(int i = 0; i < n; i++)
            wt[i] = sc.nextInt();

        System.out.println(knapsack(n, w, val, wt));
    }
}
