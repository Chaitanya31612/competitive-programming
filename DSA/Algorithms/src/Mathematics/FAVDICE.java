package Mathematics;

import java.util.Scanner;

public class FAVDICE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();

            double ans = 0;

            for(int i = 1; i <= n; i++) {
                ans += (double)n / (double)i;
            }

            System.out.printf("%.2f%n", ans);
        }
    }
}
