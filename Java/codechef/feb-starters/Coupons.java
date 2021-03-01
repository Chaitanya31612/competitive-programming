import java.util.*;

public class Coupons {

    static int sum(int[] arr) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
        }

        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int d = sc.nextInt();
            int c = sc.nextInt();
            int[] A = new int[3];
            int[] B = new int[3];

            for (int i = 0; i < 3; i++) {
                A[i] = sc.nextInt();
            }
            for (int i = 0; i < 3; i++) {
                B[i] = sc.nextInt();
            }

            int Asum = sum(A);
            int Bsum = sum(B);

            String ans = "";
            if (Asum >= 150 && Bsum >= 150) {
                if ((Asum + Bsum + c) < (Asum + Bsum + 2 * d)) {
                    ans = "YES";
                } else {
                    ans = "NO";
                }
            } else if (Asum >= 150 || Bsum >= 150) {
                if ((Asum + Bsum + c + d) < (Asum + Bsum + 2 * d)) {
                    ans = "YES";
                } else {
                    ans = "NO";
                }
            } else {
                ans = "NO";
            }
            System.out.println(ans);
        }
    }
}