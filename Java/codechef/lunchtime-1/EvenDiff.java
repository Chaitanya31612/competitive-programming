import java.util.*;

public class EvenDiff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int even = 0, odd = 0, ans = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }

            if ((even == n && odd == 0) || (odd == n && even == 0)) {
                ans = 0;
            } else if (even > odd) {
                ans = odd;
            } else if (even < odd) {
                ans = even;
            }

            System.out.println(ans);
        }
    }
}
