import java.util.Scanner;

public class KthLCS {

    static long[] a, b;

    // i and j are current index of arrays a and b.
    public int kLCS(int i, int j, int k) {
        if(i == a.length || j == b.length) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        a = new long[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextLong();

        b = new long[n];
        for(int i = 0; i < m; i++)
            b[i] = sc.nextLong();

        KthLCS kt = new KthLCS();
        System.out.println(kt.kLCS(0, 0, k));
    }
}
