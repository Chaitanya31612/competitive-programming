package Mathematics;

import java.util.Scanner;

public class ChineseRemainder {

    public int product(int[] num) {
        int res = 1;

        for (int j : num) {
            res *= j;
        }

        return res;
    }

    public int[] getPP(int[] num, int prod) {
        int[] pp = new int[num.length];
        for(int i = 0; i < num.length; i++) {
            pp[i] = prod / num[i];
        }

        return pp;
    }

    public int[] getInv(int[] pp, int[] num) {
        GCD g = new GCD();
        int[] inv = new int[num.length];
        for(int i = 0; i < num.length; i++) {
            inv[i] = g.MulModInverse(pp[i], num[i]);
        }

        return inv;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] num = new int[n];
        int[] rem = new int[n];

        for(int i = 0; i < n; i++)
            num[i] = sc.nextInt();

        for(int i = 0; i < n; i++)
            rem[i] = sc.nextInt();

        ChineseRemainder c = new ChineseRemainder();
        int prod = c.product(num);

        // each index store product of all other terms
        int[] pp = c.getPP(num, prod);

        // multiplicative inverse of every each index
        int[] inv = c.getInv(pp, num);

        int res = 0;

        for(int i = 0; i < n; i++) {
            res = (res % prod + (rem[i] * pp[i] * inv[i]) % prod) % prod;
        }

        System.out.println(res);
    }

}
