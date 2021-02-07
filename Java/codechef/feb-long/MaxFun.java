import java.util.*;

public class MaxFun {

    public static int search(int value, int[] a) {

        if (value < a[0]) {
            return a[0];
        }
        if (value > a[a.length - 1]) {
            return a[a.length - 1];
        }

        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = (hi + lo) / 2;

            if (value < a[mid]) {
                hi = mid - 1;
            } else if (value > a[mid]) {
                lo = mid + 1;
            } else {
                return a[mid];
            }
        }
        // lo == hi + 1
        return (a[lo] - value) < (value - a[hi]) ? a[lo] : a[hi];
    }
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
            int ay = search(key, a);

            // System.out.println(ax + " " + az + " " + key + " " + Arrays.binarySearch(a, key) + " " + search(key, a));

            int ans = Math.abs(ax - ay) + Math.abs(ay - az) + Math.abs(az - ax);
            System.out.println(ans);
        }
    }
}
