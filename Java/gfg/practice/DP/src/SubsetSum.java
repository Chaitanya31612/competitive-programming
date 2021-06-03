import java.util.Arrays;
import java.util.Scanner;

public class SubsetSum {
//    https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1

    public static int arraySum(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }

        return sum;
    }

    public static boolean isSubsetSum(int n, int[] arr, int sum) {
        if(n == 0 && sum != 0) {
            return false;
        }
        if(sum == 0) {
            return true;
        }

        if(arr[n - 1] > sum) {
            return isSubsetSum(n - 1, arr, sum);
        }

        return isSubsetSum(n - 1, arr, sum) || isSubsetSum(n - 1, arr, sum - arr[n - 1]);
    }

    public static boolean isSubsetSumMem(int n, int[] arr, int sum) {
        int[][] dp = new int[n + 1][sum + 1];

        for(int[] a : dp)
            Arrays.fill(a, -1);

        return isSubsetSumMem(n, arr, sum, dp);
    }

    private static boolean isSubsetSumMem(int n, int[] arr, int sum, int[][] dp) {
        // -1 - initial, 1 - true, 0 - false
        if(dp[n][sum] != -1)
            return dp[n][sum] == 1;

        if(n == 0 && sum != 0) {
            dp[n][sum] = 0;
            return false;
        }

        if(sum == 0) {
            dp[n][sum] = 1;
            return true;
        }

        return isSubsetSumMem(n - 1, arr, sum, dp) || isSubsetSumMem(n - 1, arr, sum - arr[n - 1], dp);
    }

    public static boolean isSubsetSumDP(int n, int[] arr, int sum) {
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for(int i = 1; i <= sum; i++)
            dp[0][i] = false;

        for(int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= sum; j++) {
                boolean op1 = dp[i - 1][j];
                boolean op2 = false;
                if(j - arr[i - 1] >= 0) {
                    op2 = dp[i - 1][j - arr[i - 1]];
                }

                if(op1 || op2)
                    dp[i][j] = true;
                else
                    dp[i][j] = false;
            }
        }

        return dp[n][sum];
    }

    public static int equalPartition(int N, int[] arr) {
        int sum = arraySum(arr);
        // if sum is odd then it cannot be divided into two equal subsets
        if((sum&1) == 1) {
            return 0;
        }

        return isSubsetSumDP(N, arr, sum / 2) ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(equalPartition(n, arr));

    }
}

/* Sample
4
1 5 11 5

1

3
1 3 5

0
* */