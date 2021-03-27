//package easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EvenOdds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        long n = sc.nextLong();
        long k = sc.nextLong();

        long ans;
        double oddNo = Math.ceil((double)n / (double) 2);
        if((k <= oddNo)) {
            // odd
            ans = k*2 - 1;
        }
        else {
            // even
            ans = (k - (long)oddNo) * 2;
        }

        System.out.println(ans);
    }
}
