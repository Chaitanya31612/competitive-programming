import java.util.Scanner;

public class KOrderedLCS {
    static int n, m;
    static long[] a, b;

    // i and j are current index of arrays a and b.
    public int kLCS(int i, int j, int k) {
        if(i == n || j == m) {
            return 0;
        }

        if(a[i] == b[j]) {
            return 1 + kLCS(i + 1, j + 1, k);
        } else {
            int op1 = Integer.MIN_VALUE;
            if(k > 0)
                op1 = 1 + kLCS(i + 1, j + 1, k - 1);

            int op2 = kLCS(i + 1, j, k);
            int op3 = kLCS(i, j + 1, k);

            return Math.max(op1, Math.max(op2, op3));
        }
    }

    // Using Memoization
    static int[][][] dp;

    public int kLCSMem(int i, int j, int k) {
        if(i == n || j == m) {
            return 0;
        }

        if(dp[i][j][k] != -1) {
            return dp[i][j][k];
        }

        if(a[i] == b[j]) {
            return dp[i][j][k] = 1 + kLCSMem(i + 1, j + 1, k);
        } else {
            int op1 = Integer.MIN_VALUE;
            if(k > 0)
                op1 = 1 + kLCSMem(i + 1, j + 1, k - 1);

            int op2 = kLCSMem(i + 1, j, k);
            int op3 = kLCSMem(i, j + 1, k);

            return dp[i][j][k] = Math.max(op1, Math.max(op2, op3));
        }
    }

    public int kLCSDP(int k) {
        // base case
        int[][][] storage = new int[n + 1][m + 1][k + 1];
        for(int i = 0; i <= n; i++) {
            for(int kv = 0; kv <= k; kv++) {
                storage[i][0][kv] = 0;
            }
        }

        for(int j = 0; j <= m; j++) {
            for(int kv = 0; kv <= k; kv++) {
                storage[0][j][kv] = 0;
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(a[n - i] == b[m - j]) {
                    storage[i][j][k] = 1 + storage[i - 1][j - 1][k];
                } else {
                    int op1 = Integer.MIN_VALUE;
                    if(k > 0)
                        op1 = 1 + storage[i - 1][j - 1][k - 1];

                    int op2 = storage[i][j - 1][k];
                    int op3 = storage[i - 1][j][k];

                    storage[i][j][k] = Math.max(op1, Math.max(op2, op3));
                }
            }
        }

        print3D(storage, n, m, k);
        return storage[n][m][k];
    }

    public void print3D(int[][][] arr, int n, int m, int k) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int kv = 0; kv <= k; kv++)
                    System.out.print(arr[i][j][kv] + " ");
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int k = sc.nextInt();

        a = new long[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = sc.nextLong();

        b = new long[m + 1];
        for (int i = 1; i <= m; i++)
            b[i] = sc.nextLong();

        KOrderedLCS kt = new KOrderedLCS();
        System.out.println(kt.kLCS(1, 1, k));

        dp = new int[n + 1][m + 1][k + 1];
//        for(int i = 0; i < n; i++)
//            for(int[] a: dp[i])
//                Arrays.fill(a, -1);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                for (int kval = 0; kval <= k; kval++)
                    dp[i][j][kval] = -1;


        System.out.println(kt.kLCSMem(1, 1, k));

        kt.print3D(dp, n, m, k);
        System.out.println(kt.kLCSDP(k));
    }
}

/* Sample Input

5 5 1
1 2 3 4 5
5 3 1 4 2

3

5 5 4
1 2 3 4 5
5 3 4 1 2

4
* */