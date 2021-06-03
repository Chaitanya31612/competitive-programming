import java.util.Arrays;
import java.util.Scanner;

public class nPrPermutation {

    // P(n,r) = P(n-1, r) + r*P(n-1,r-1)
    public static long nPr(int n, int r) {
        if(r > n)
            return 0;
        if(r == 0)
            return 1;

        return nPr(n-1, r) + r * nPr(n-1, r-1);
    }

    public static long nPrMem(int n, int r) {
        long[][] dp = new long[n + 1][r + 1];

        for(long[] a : dp)
            Arrays.fill(a, -1);

        return nPrMem(n, r, dp);
    }

    private static long nPrMem(int n, int r, long[][] dp) {
        if(dp[n][r] != -1)
            return dp[n][r];

        if(r > n)
            return dp[n][r] = 0;
        if(r == 0)
            return dp[n][r] = 1;

        return dp[n][r] = nPrMem(n - 1, r, dp) + r * nPrMem(n - 1, r - 1, dp);
    }

    public static long nPrDP(int n, int r) {
        long[][] dp = new long[n + 1][r + 1];

        for(int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= r; j++) {
                dp[i][j] = dp[i - 1][j]  + j * dp[i - 1][j - 1];
            }
        }

        return dp[n][r];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();

        System.out.println(nPrDP(n, r));
        System.out.println(nPrMem(n, r));
        System.out.println(nPr(n, r));
    }
}
