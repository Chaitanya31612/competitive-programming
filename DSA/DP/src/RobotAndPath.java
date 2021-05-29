import java.util.Scanner;

public class RobotAndPath {
//https://www.codechef.com/problems/CD1IT4

    static int[][] dp;
    static int mod = (int)1e9 + 7;

    public static int numPaths(int m, int n) {
        // edge case
        // if the first block is block then there is no way to reach the end block by right and down move
        if(dp[0][0] == -1){
            return 0;
        }

        // condition for first column - only one way if not blocked
        for(int i = 0; i < m; i++) {
            if(dp[i][0] == -1) {
                break;
            }
            // otherwise put 1 which means that there is 1 way to reach
            dp[i][0] = 1;
        }

        // condition for first row - only one way if not blocked
        for(int j = 0; j < n; j++) {
            if(dp[0][j] == -1) {
                break;
            }
            // otherwise put 1 which means that there is 1 way to reach
            dp[0][j] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(dp[i][j] == -1) {
                    continue;
                }

                // left cell not blocked
                if(dp[i][j - 1] != -1) {
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % mod;
                }
                // top element
                if(dp[i - 1][j] != -1) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod;
                }
            }
        }

        if(dp[m - 1][n - 1] == -1) {
            return -1;
        }
        return dp[m - 1][n - 1];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // rows
        int m = sc.nextInt();
        // cols
        int n = sc.nextInt();
        // blockage
        int k = sc.nextInt();

        dp = new int[m][n];
        for(int i = 0; i < k; i++) {
            int r = sc.nextInt();
            int co = sc.nextInt();
            dp[r -1][co - 1] = -1;
        }

        System.out.println(numPaths(m, n));
    }
}
