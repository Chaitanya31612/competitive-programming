import java.util.Scanner;

public class NCRBinomial {

    static int mod = (int)1e9 + 7;

    public static long nCr(int N, int R) {
        if(N < R)
            return 0;

        long[][] dp = new long[N + 1][R + 1];
        // base cases
        // when n is zero nCr is zero except 0C0
        for(int i = 1; i <= R; i++)
            dp[0][i] = 0;

        for(int i = 0; i <= N; i++) {
            // when r is 0 nCr is 1
            dp[i][0] = 1;

            // when r is 1 nCr is n
            dp[i][1] = i;
        }

        R = Math.min(R, N - R);

        for(int n = 1; n <= N; n++) {
            for(int r = 2; r <= R; r++) {
                if(n > r) {
                    dp[n][r] = (((n - r + 1) * dp[n][r - 1]) / r);
                } else if(n == r) {
                    dp[n][r] = 1;
                }
            }
        }

//        for(int[] a : dp) {
//            System.out.println(Arrays.toString(a));
//        }

        return dp[N][R] % mod;
    }

    public static int nCrPascal(int n, int r) {
        if(r == 0 || r == n)
            return 1;

        return nCrPascal(n - 1, r - 1) + nCrPascal(n - 1, r);
    }

    public static int nCrPascalDP(int n, int r) {
        if(n < r)
            return 0;

        int[][] dp = new int[n + 1][n + 1];

        for(int i = 0; i <= n; i++) {
            dp[i][0] = dp[i][n] = 1;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = ((dp[i - 1][j - 1]) % mod + (dp[i - 1][j]) % mod) % mod;
            }
        }

        return dp[n][r];
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();

        System.out.println(nCr(n, r));
        System.out.println(nCrPascalDP(n, r));
        System.out.println(nCrPascal(n, r));
    }

    static class nCrSol{
        static int min(int x, int y){
            if(x <= y)
                return x;
            return y;
        }

        static int nCr(int n, int r){
            int[] C = new int[r+1];
            for(int i = 0;i <= r;i++)
                C[i] = 0;
            // Top row of Pascal Triangle
            C[0] = 1;

            // One by constructs remaining rows of Pascal
            // Triangle from top to bottom
            for(int i = 0;i <= n;i++){
                // Fill entries of current row using previous
                // row values
                for(int j = min(i, r); j > 0; j--){
                    // nCj = (n-1)Cj + (n-1)C(j-1);
                    C[j] =(C[j] + C[j-1])%1000000007;
                }
            }
            return C[r]%1000000007;
        }
    }
}
