import java.util.Arrays;

public class LCS {

    public static int lcs(String s, String t) {
        if(s.length() == 0 || t.length() == 0) {
            return 0;
        }

        if(s.charAt(0) == t.charAt(0)) {
            return 1 + lcs(s.substring(1), t.substring(1));
        } else {
            int op1 = lcs(s, t.substring(1));
            int op2 = lcs(s.substring(1), t);

            /* op3 can be ignored because this will be implicitly encountered in first two calls */
//            int op3 = lcs(s.substring(1), t.substring(1));

            return Math.max(op1, op2);
        }
    }


    /* Memoization - top down
    * time - O((m+1)(n+1)
    * m, n - size of first and second */
    public static int lcsM(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] storage = new int[m + 1][n + 1];

        for(int[] row : storage) {
            Arrays.fill(row, -1);
        }

        return lcsM(s, t, storage);
    }

    private static int lcsM(String s, String t, int[][] storage) {
        int m = s.length();
        int n = t.length();

        if(storage[m][n] != -1) {
            return storage[m][n];
        }

        if(m == 0 || n == 0) {
            storage[m][n] = 0;
            return storage[m][n];
        }


        if(s.charAt(0) == t.charAt(0)) {
            storage[m][n] = 1 + lcsM(s.substring(1), t.substring(1), storage);
        } else {
            int op1 = lcsM(s, t.substring(1), storage);
            int op2 = lcsM(s.substring(1), t, storage);
            storage[m][n] = Math.max(op1, op2);
        }
        return storage[m][n];
    }


    public static int lcsDP(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] storage = new int[m + 1][n + 1];

        for(int i = 0; i <= n; i++) {
            storage[i][0] = 0;
        }

        for(int j = 0; j <= m; j++) {
            storage[0][j] = 0;
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                // we have to compare from last as our answer is at [m][n]
                if(s.charAt(m - i) == t.charAt(m - j)) {
                    storage[i][j] = 1 + storage[i - 1][j - 1];
                } else {
                    int op1 = storage[i][j - 1];
                    int op2 = storage[i - 1][j];

                    storage[i][j] = Math.max(op1, op2);
                }
            }
        }

        return storage[m][n];
    }



    public static void main(String[] args) {
        String s = "adgei";
        String t = "abegi";

        long start, end;

        start = System.currentTimeMillis();
        System.out.println(lcsDP(s, t));
        end = System.currentTimeMillis();
        System.out.println("It takes " +
                (end - start) + "ms");


        start = System.currentTimeMillis();
        System.out.println(lcsM(s, t));
        end = System.currentTimeMillis();
        System.out.println("It takes " +
                (end - start) + "ms");


        start = System.currentTimeMillis();
        System.out.println(lcs(s, t));
        end = System.currentTimeMillis();
        System.out.println("It takes " +
                (end - start) + "ms");
    }
}
