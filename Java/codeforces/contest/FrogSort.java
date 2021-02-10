import java.util.*;

public class FrogSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] w = new int[n];
            int[] l = new int[n];

            for (int i = 0; i < n; i++) {
                w[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                l[i] = sc.nextInt();
            }

            int ans = 0;
            if (n == 2) {
                if (w[0] < w[1]) {
                    ans = 0;
                } else {
                    if (l[0] == 1) {
                        ans = 2;
                    } else {
                        ans = 1;
                    }
                }
            }

            System.out.println(ans);
        }
    }
}
