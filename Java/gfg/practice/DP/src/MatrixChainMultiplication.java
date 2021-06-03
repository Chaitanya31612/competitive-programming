import java.util.Arrays;
import java.util.Scanner;

public class MatrixChainMultiplication {

    public static int minMultiplication(int[] p, int i, int j) {
        // for single matrix there will be no multiplication
        if(i == j)
            return 0;

        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            int count = minMultiplication(p, i, k) + minMultiplication(p, k + 1, j) + (p[i-1] * p[k] * p[j]);
            min = Math.min(min, count);
        }
        return min;
    }

    public static int minMultiplicationMem(int[] p, int i, int j) {
        int[][] dp = new int[j + 1][j + 1];
        for(int[] a: dp)
            Arrays.fill(a, -1);

        return minMultiplicationMem(p, i, j, dp);
    }

    private static int minMultiplicationMem(int[] p, int i, int j, int[][] dp) {
        if(i < 0 || j < 0 || i > p.length || j > p.length)
            return 0;
        if(i == j)
            return dp[i][j] = 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            int count = minMultiplicationMem(p, i, k, dp) + minMultiplicationMem(p, k + 1, j, dp) + (p[i-1] * p[k] * p[j]);
            min = Math.min(min, count);
        }
        return dp[i][j] = min;
    }

    public static int minMultiplicationDP(int[] p, int n) {
        int[][] dp = new int[n][n];

        for(int d = 1; d < n - 1; d++) {
            for(int i = 1; i < n - d; i++) {
                int j = i + d;

                int min = Integer.MAX_VALUE;
                for(int k = i; k <= j - 1; k++) {
                    int count = dp[i][k] + dp[k + 1][j] + (p[i - 1] * p[k] * p[j]);

                    if(count < min)
                        min = count;
                }
                dp[i][j] = min;
            }
        }

        for(int[] a: dp)
            System.out.println(Arrays.toString(a));

        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(minMultiplication(arr, 1, n - 1));

        System.out.println(minMultiplicationMem(arr, 1, n - 1));

        System.out.println(minMultiplicationDP(arr, n));
    }
}

/* Sample
5
40 20 30 10 30

26000
* */