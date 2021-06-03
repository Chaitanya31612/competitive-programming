import java.util.Arrays;
import java.util.Scanner;

public class GoldMine {

    public static int maxGoldRec(int n, int m, int[][] M) {
        int[][] dp = new int[n + 1][m + 1];
        for(int[] a: dp)
            Arrays.fill(a, -1);

        int ans = -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            max = maxGoldMem(i, 0, n, m, M, dp);
            if(max > ans)
                ans = max;
        }

        return ans;
    }

    private static int maxGoldRecUtil(int i, int j, int n, int m, int[][] M) {
        if(i < 0 || i >= n || j < 0 || j >= m) {
            return 0;
        }


        // right
        int op1 = maxGoldRecUtil(i, j + 1, n, m, M);
        // right up
        int op2 = maxGoldRecUtil(i - 1, j + 1, n, m, M);
        // right down
        int op3 = maxGoldRecUtil(i + 1, j + 1, n, m, M);

        return M[i][j] + Math.max(op1, Math.max(op2, op3));
    }

    public static int maxGoldMem(int i, int j, int n, int m, int[][] M, int[][] dp) {
        if(i < 0 || i >= n || j < 0 || j >= m) {
            return 0;
        }

        if(dp[i][j] != -1)
            return dp[i][j];

        // right
        int op1 = maxGoldMem(i, j + 1, n, m, M, dp);
        // right up
        int op2 = maxGoldMem(i - 1, j + 1, n, m, M, dp);
        // right down
        int op3 = maxGoldMem(i + 1, j + 1, n, m, M, dp);

        return dp[i][j] = M[i][j] + Math.max(op1, Math.max(op2, op3));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] M = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                M[i][j] = sc.nextInt();
            }
        }

        System.out.println(maxGoldRec(n, m, M));
    }
}

/* Sample Input
3 3
1 3 3
2 1 4
0 6 4

12
* */