import java.util.*;

public class SwapMinimise {
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
            int sum = 0;
            for (int i = 0; i < n-1; i++) {
                sum += Math.abs(a[i] - a[i + 1]);
            }
            System.out.println(sum);
        }
    }
}
