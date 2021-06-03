import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class CatalanNumber {

    // this program gives nth catalan number
    /*
    for n = 0 , C = 1
    else Cn+1 = (Sum 0-n)Ci * Cn-i-1
    * */
    public static long catalanNumber(int n) {
        if(n <= 1) {
            return 1;
        }
        long res = 0;
        for(int i = 0; i < n; i++) {
            res += catalanNumber(i) * catalanNumber(n - i - 1);
        }
        return res;
    }

    public static long catalanNumberMem(int n) {
        long[] dp = new long[n + 1];

        Arrays.fill(dp, -1);

        return catalanNumberMem(n, dp);
    }

    private static long catalanNumberMem(int n, long[] dp) {
        if(dp[n] != -1)
            return dp[n];

        if(n <= 1)
            return dp[n] = 1;

        long res = 0;
        for(int i = 0; i < n; i++) {
            res += catalanNumberMem(i, dp) * catalanNumberMem(n - i - 1, dp);
        }

        return dp[n] = res;
    }

//    public static int catalanNumberDP(int n) {
//        int[] dp = new int[n + 1];
//
//        dp[0] = dp[1] = 1;
//
//        for(int i = 2; i <= n; i++) {
//            for(int j = 0; j < n; j++) {
//                dp[i] += dp[j] * dp[n - j - 1];
//            }
//        }
//    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
//        System.out.println("Recursion");
//        for(int i = 0; i <= n; i++) {
//            System.out.print(catalanNumber(i) + " ");
//        }
//
//        System.out.println("\nMemoization");
//        for(int i = 0; i <= n; i++) {
//            System.out.print(catalanNumberMem(i) + " ");
//        }

        BigInteger b = new BigInteger("-1");
        b = new BigInteger("1");
        System.out.println(b);

        BigInteger a = new BigInteger(String.valueOf(b));
    }
}
