package lunchtimemarch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Motivation2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = sc.nextInt();
        while(t-- > 0) {
            long n = sc.nextLong();
            long x = sc.nextLong();

            long max = Long.MIN_VALUE;
            for(int it = 0; it < n; it++) {
                long s = sc.nextLong();
                long r = sc.nextLong();

                if(r > max && s <= x) {
                    max = r;
                }
            }

            System.out.println(max);
        }
    }
}
