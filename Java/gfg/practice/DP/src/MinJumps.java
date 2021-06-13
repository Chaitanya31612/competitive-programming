import java.util.Arrays;
import java.util.Scanner;

public class MinJumps {

    // time - 5.8s
    public static int minJumpsRec(int[] arr, int n) {
        if(n == arr.length - 1) {
            return 0;
        }

        if(arr[n] == 0) {
            return Integer.MAX_VALUE;
        }

        int ans = Integer.MAX_VALUE;
        for(int k = 1; k <= arr[n] && (n + k) < arr.length; k++) {
            int jumps = minJumpsRec(arr, n + k);

            if(jumps != Integer.MAX_VALUE && 1 + jumps < ans) {
                ans = 1 + jumps;
            }
        }

        return ans;
    }

    // Memoization
    public static int minJumpsMem(int[] arr, int n, int[] dp) {
        if(n == arr.length - 1) {
            return 0;
        }

        if(dp[n] != -2) {
            return dp[n];
        }

        if(arr[n] == 0) {
            return dp[n] = -1;
        }

        int ans = Integer.MAX_VALUE;
        for(int k = 1; k <= arr[n] && (k + n) < arr.length; k++) {
            int jumps = minJumpsMem(arr, k + n, dp);

//            System.out.println(jumps);

            if(jumps != -1 && jumps != Integer.MAX_VALUE && 1 + jumps < ans) {
                ans = 1 + jumps;
            }
        }

        if(ans == Integer.MAX_VALUE) {
            return dp[n] = -1;
        }

        return dp[n] = ans;
    }

    // DP
    public static int minJumpsDP(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        // to reach to first index is 0 steps
        dp[0] = 0;

        // dp[i] denotes the minimum no of ways to reach dp[i] from dp[0]
        for(int i = 1; i < n; i++) {
            // trying to reach ith index starting from 0
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++) {
//                arr[j] + j >= i denotes that from jth index we can move maximum till j + arr[j]
//                and that need to be larger than i for us to reach i
                if(arr[j] + j >= i && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
                }
            }
        }

        if(dp[n - 1] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[n - 1];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(minJumpsRec(arr, 0));
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -2);
        System.out.println(minJumpsMem(arr, 0, dp));
        System.out.println(minJumpsDP(arr));
    }
}

/* Sample
11
1 3 5 8 9 2 6 7 6 8 9

3

6
1 4 3 2 6 7

2
* */