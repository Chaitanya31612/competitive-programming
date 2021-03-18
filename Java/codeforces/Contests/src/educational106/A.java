package educational106;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int k1 = sc.nextInt();
            int k2 = sc.nextInt();
            int w = sc.nextInt();
            int b = sc.nextInt();

            String ans = "";

            if(n == 1) {
                if((k1 == 1 && k2 == 0) && (k1 == 0 && k2 == 1)) {
                    ans = "NO";
                }
            }

            if(k1 == n && k2 == n) {
                if(w == n && b == 0) {
                    ans = "YES";
                } else {
                    ans = "NO";
                }
            } else if(k1 == 0 && k2 == 0) {
                if(w == 0 && b == n) {
                    ans = "YES";
                } else {
                    ans = "NO";
                }
            }

            if(w + b == 0) {
                ans = "YES";
            }

            else {
                int count_white = 0, count_black = 0;

                count_white = k1 <= k2 ? k1 : k2;

                int diff = Math.abs(k1 - k2);
                if((diff&1) == 1) {
                    diff--;
                }
                count_white += diff/2;


                count_black = k1 <= k2 ? n - k2 : n - k1;
                count_black += diff/2;

//                System.out.println(count_white);
//                System.out.println(count_black);

                if(count_white >= w && count_black >= b) {
                    ans = "YES";
                } else {
                    ans = "NO";
                }
            }
            System.out.println(ans);
        }
    }
}
