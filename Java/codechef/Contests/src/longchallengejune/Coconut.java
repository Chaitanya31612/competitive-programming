package longchallengejune;

import java.util.Scanner;

public class Coconut {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            int xa = sc.nextInt();
            int xb = sc.nextInt();
            int Xa = sc.nextInt();
            int Xb = sc.nextInt();

            int ans = (Xa / xa) + (Xb / xb);

            System.out.println(ans);
        }
    }
}
