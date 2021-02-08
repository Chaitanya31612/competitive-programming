import java.util.*;

public class MaxFun2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            Arrays.sort(a);
            long ax = a[0];
            long az = a[n - 1];
            long ans = 2 * (az - ax);

            System.out.println((ans));
            
            // System.out.println(Math.abs(ax - ay) + Math.abs(ay - az) + Math.abs(az - ax));
        }
    }
}
