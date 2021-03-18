package contest708;

import java.util.Scanner;

public class C3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] ans = new int[3];
            if((n&1) == 1) {
                ans[0] = 1;
                ans[1] = ans[2] = n / 2;
            } else {
                if(n % 4 == 0) {
                    ans[0] = n/2;
                    ans[1] = ans[2] = n / 4;
                } else {
                    ans[0] = 2;
                    ans[1] = ans[2] = n / 2 - 1;
                }
            }

            for(int i = 0; i < 3; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
