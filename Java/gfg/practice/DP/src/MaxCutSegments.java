import java.util.Scanner;

public class MaxCutSegments {

    public int maximizeCuts(int n, int x, int y, int z) {
        if(n < 0) {
            return -1;
        }

        if(n == 0) {
            return 0;
        }

        int max = -1;
        max = Math.max(max, maximizeCuts(n - x, x, y, z));
        max = Math.max(max, maximizeCuts(n - y, x, y, z));
        max = Math.max(max, maximizeCuts(n - z, x, y, z));
//        int op1 = maximizeCuts(n - x, x, y, z);
//        int op2 = maximizeCuts(n - y, x, y, z);
//        int op3 = maximizeCuts(n - z, x, y, z);

        if(max == -1) {
            return 0;
        }
        return 1 + max;
    }

    public int maximizeCutsDP(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];
        // base case
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            dp[i] = Integer.MIN_VALUE;

            if(i - x >= 0) {
                dp[i] = Math.max(dp[i], dp[i - x]);
            }
            if(i - y >= 0) {
                dp[i] = Math.max(dp[i], dp[i - y]);
            }
            if(i - z >= 0) {
                dp[i] = Math.max(dp[i], dp[i - z]);
            }

            // if we can cut
            if(dp[i] != Integer.MIN_VALUE) {
                dp[i]++;
            }
        }

        if(dp[n] == Integer.MIN_VALUE) {
            return 0;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        MaxCutSegments m = new MaxCutSegments();
        System.out.println(m.maximizeCuts(n, x, y, z));
        System.out.println(m.maximizeCutsDP(n, x, y, z));
    }
}

/* Sample
4
2 1 1

4

5
5 3 2

2
* */