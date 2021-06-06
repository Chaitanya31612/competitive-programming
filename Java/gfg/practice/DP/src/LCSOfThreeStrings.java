import java.util.Scanner;

public class LCSOfThreeStrings {

    public String lcsString(String s1, String s2, int m, int n) {
        String[][] dp = new String[m + 1][n + 1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                dp[i][j] = "";
            }
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + s1.charAt(i - 1);
                } else {
                    String op1 = dp[i - 1][j];
                    String op2 = dp[i][j - 1];

                    if(op1.length() > op2.length()) {
                        dp[i][j] = op1;
                    } else {
                        dp[i][j] = op2;
                    }
                }
            }
        }

//        for(String[] a: dp) {
//            System.out.println(Arrays.toString(a));
//        }

        return dp[m][n];
    }

    public int LCSof3Brute(String A, String B, String C, int n1, int n2, int n3) {
        String lcs1 = lcsString(A, B, n1, n2);
        String lcs2 = lcsString(lcs1, C, lcs1.length(), n3);

        String lcs3 = lcsString(B, C, n2, n3);
        String lcs4 = lcsString(lcs3, A, lcs3.length(), n1);

        String lcs5 = lcsString(A, C, n2, n3);
        String lcs6 = lcsString(lcs5, B, lcs5.length(), n1);

        System.out.println(lcs1);
        System.out.println(lcs2);
        System.out.println(lcs3);
        System.out.println(lcs4);

        return Math.max(lcs2.length(), Math.max(lcs4.length(), lcs6.length()));
    }

    public int LCSof3(String A, String B, String C, int n1, int n2, int n3) {
        int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];


        for(int i = 1; i <= n1; i++) {
            for(int j = 1; j <= n2; j++) {
                for(int k = 1; k <= n3; k++) {
                    if((A.charAt(i - 1) == B.charAt(j - 1)) && (B.charAt(j - 1) == C.charAt(k - 1))) {
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    } else {
                        int op1 = dp[i-1][j][k];
                        int op2 = dp[i][j-1][k];
                        int op3 = dp[i][j][k-1];
                        int op4 = dp[i-1][j-1][k];
                        int op5 = dp[i][j-1][k-1];
                        int op6 = dp[i-1][j][k-1];

                        dp[i][j][k] = Math.max(op1, Math.max(op2, Math.max(op3, Math.max(op4, Math.max(op5, op6)))));

                    }
                }
            }
        }

//        for(String[] a: dp) {
//            System.out.println(Arrays.toString(a));
//        }

        return dp[n1][n2][n3];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        sc.nextLine();
        String A = sc.nextLine();
        String B = sc.nextLine();
        String C = sc.nextLine();

        LCSOfThreeStrings l = new LCSOfThreeStrings();
        System.out.println(l.LCSof3(A, B, C, n1, n2, n3));
    }
}

/* Sample
5 8 13
geeks
geeksfor
geeksforgeeks

5

4 4 4
abcd
efgh
ijkl

0

19 16 8
qduxwfnfozvsrtkjpre
pggxrpnrvystmwcy
syycqpev

1

11 11 7
ffmznimkkas
vwsrenzkycx
fxtlsgy

1
* */