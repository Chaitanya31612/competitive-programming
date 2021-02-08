import java.util.*;

public class MaxFun {

    // public static int search(int value, int[] a) {

    //     if (value < a[0]) {
    //         return a[0];
    //     }
    //     if (value > a[a.length - 1]) {
    //         return a[a.length - 1];
    //     }

    //     int lo = 0;
    //     int hi = a.length - 1;

    //     while (lo <= hi) {
    //         int mid = (hi + lo) / 2;

    //         if (value < a[mid]) {
    //             hi = mid - 1;
    //         } else if (value > a[mid]) {
    //             lo = mid + 1;
    //         } else {
    //             return a[mid];
    //         }
    //     }
    //     // lo == hi + 1
    //     return (a[lo] - value) < (value - a[hi]) ? a[lo] : a[hi];
    // }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Arrays.sort(a);
            // System.out.println(Arrays.toString(a));
            int ax = a[0], az = a[n - 1];
            int key = (ax + az) / 2;
            int ay, ans;

            if (a.length % 2 == 0) {
                int x = n / 2;
                int y = x - 1;

                int c1 = Math.abs(ax - a[x]) + Math.abs(a[x] - az) + Math.abs(az - ax);
                int c2 = Math.abs(ax - a[y]) + Math.abs(a[y] - az) + Math.abs(az - ax);

                if (c1 > c2) {
                    ay = x;
                } else {
                    ay = y;
                }
            } else {
                ay = a[(n-1) / 2];
            }
            // int[] ansArray = new int[n];
            // ansArray[0] = Integer.MIN_VALUE;
            // ansArray[n - 1] = Integer.MIN_VALUE;
            
            // long max = Long.MIN_VALUE;

            // for (int i = 1; i < n - 1; i++) {
            //     int c = a[i];
            //     ansArray[i] = Math.abs(ax - c) + Math.abs(c - az) + Math.abs(az - ax);

            //     if (ansArray[i] >= max) {
            //         max = ansArray[i];
            //         ay = a[i];
            //     }
            // }

            // System.out.println(Arrays.toString(ansArray));

            ans = Math.abs(ax - ay) + Math.abs(ay - az) + Math.abs(az - ax);
            System.out.println(ans);
        }
    }
}
