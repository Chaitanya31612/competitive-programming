import java.util.Arrays;
import java.util.Scanner;

public class EditDistance {

    // this will give minimum number of operations (insert, delete, substitute) to make string s equal to string t
    public static int editDistance(String s, String t) {
        if(s.equals(t)) {
            return 0;
        }

        if(s.length() == 0) {
            // insert t characters
            return t.length();
        }

        if(t.length() == 0) {
            // delete all characters from s
            return s.length();
        }

        if(s.charAt(0) == t.charAt(0)) {
            return editDistance(s.substring(1), t.substring(1));
        } else {
            // insert
            int op1 = editDistance(s, t.substring(1));
            // delete
            int op2 = editDistance(s.substring(1), t);
            // substitute
            int op3 = editDistance(s.substring(1), t.substring(1));

            return 1 + Math.min(op1, Math.min(op2, op3));
        }
    }

    // execution time - 0.74s
    public static int editDistanceMem(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for(int[] a : dp)
            Arrays.fill(a, -1);

        return editDistanceMem(s, t, dp);
    }

    private static int editDistanceMem(String s, String t, int[][] dp) {
        int m = s.length();
        int n = t.length();

        if(dp[m][n] != -1) {
            return dp[m][n];
        }

        if(s.equals(t)) {
            return dp[m][n] = 0;
        }

        if(m == 0) {
            return dp[m][n] = n;
        }

        if(n == 0) {
            return dp[m][n] = m;
        }

        if(s.charAt(0) == t.charAt(0)) {
            dp[m][n] = editDistanceMem(s.substring(1), t.substring(1), dp);
        } else {
            int op1 = editDistanceMem(s, t.substring(1), dp);
            int op2 = editDistanceMem(s.substring(1), t, dp);
            int op3 = editDistanceMem(s.substring(1), t.substring(1), dp);

            dp[m][n] = 1 + Math.min(op1, Math.min(op2, op3));
        }

        return dp[m][n];
    }

    // execution time - 0.25s
    public static int editDistanceDP(String s, String t) {
        if(s.equals(t)) {
            return 0;
        }

        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for(int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                // check from last character
                if(s.charAt(m - i) == t.charAt(n - j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int op1 = dp[i][j - 1];
                    int op2 = dp[i - 1][j];
                    int op3 = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(op1, Math.min(op2, op3));
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();

        System.out.println(editDistance(s, t));
        System.out.println(editDistanceMem(s, t));
        System.out.println(editDistanceDP(s, t));

    }
}
