import java.util.*;

public class INTVS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int notsol = 0;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();

                if (a[i] == -1) {
                    notsol++;
                }
            }

            int sol = n - notsol;
            String ans;

            boolean slow = false, allone = true;
            for (int i = 0; i < n; i++) {
                if (a[i] > k) {
                    slow = true;
                }
                if (a[i] > 1) {
                    allone = false;
                }
            }

            if ((double)sol < Math.ceil((double)n / 2)) {
                ans = "Rejected";
            } else if (slow) {
                ans = "Too Slow";
            } else if (allone && notsol == 0) {
                ans = "Bot";
            } else {
                ans = "Accepted";
            }

            System.out.println(ans);
        }
    }
}
