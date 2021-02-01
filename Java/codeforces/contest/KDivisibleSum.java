import java.util.*;

public class KDivisibleSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int ans = 0;

            if (n == 1) {
                ans = k;
            } else if (n == k || (n % k == 0) || k == 1) {
                ans = 1;
            } else if (k > n) {
                if (k % n == 0) {
                    ans = k / n;
                } else {
                    ans = ((k - (k%n)) / n) + 1;
                }
            } else if (k < n) {
                ans = 2;
            }

            System.out.println(ans);
        }
    }
}
