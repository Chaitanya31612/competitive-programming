import java.util.*;

public class Inflation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
            }
            
            long[] sum = new long[n];
            sum[0] = p[0];
            for (int i = 1; i < n - 1; i++) {
                sum[i] = p[i] + sum[i - 1];
            }

            long ans = 0;

            // for (int i = 1; i < n; i++) {
            //     long temp = p[i];
            //     long inc = Math.max((temp * (long) 100) - ((sum[i - 1] + ans) * (long) k), 0);
            //     System.out.println("inc = " + inc);
            //     /* reason for inc / k
            //         inc is (temp * (long) 100) - ((sum[i - 1] + ans) * (long) k)
            //         and it mean how much we should increase ((sum[i - 1] + ans) * (long) k) to make difference zero
            //         but we need the increase in sum so we divide ((sum[i - 1] + ans) * (long) k) this by k so to find
            //         net increase in sum and not the product.
            //     */
            //     double x = (double) inc / k;
            //     System.out.println("x = " + x);
            //     x = Math.ceil(x);
            //     System.out.println("xceil = " + x);
            //     ans += (long) x;
            //     System.out.println("ans = " + ans);
            // }

            for (int i = 1; i < n; i++) {
                double inf = (double) p[i] / (double) (sum[i - 1] + ans);

                if (inf <= (double) k / 100) {
                    continue;
                } else {
                    long temp = p[i];
                    long inc = (temp * (long) 100) - ((sum[i - 1] + ans) * (long) k);
                    double x = (double) inc / k;
                    x = Math.ceil(x);
                    ans += (long) x;
                }
            }

            System.out.println(ans);
        }
    }
}
