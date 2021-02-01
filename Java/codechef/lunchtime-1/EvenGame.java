import java.util.*;

public class EvenGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int sign = -1, sum = 0;
            for (int i = 0; i < n; i++) {
                sign = -1 * sign;
                a[i] *= sign;
                sum += a[i];
            }

            int ans;
            if (sum % 2 == 0) {
                ans = 1;
            } else {
                ans = 2;
            }

            System.out.println(ans);
        }
    }
}
