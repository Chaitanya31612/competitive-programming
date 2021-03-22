package present;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class KGoodness {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int tt = 1; tt <= t; ++tt) {
            int n = in.nextInt();
            int k = in.nextInt();
            in.nextLine();
            String s = in.nextLine();

            int count = 0;
            for(int i = 0; i < s.length()/2; i++) {
                if(s.charAt(i) != s.charAt(n - i - 1)) {
                    count++;
                }
            }

            int ans = 0;
            if(count == k) {
                ans = 0;
            } else {
                ans = Math.abs(count - k);
            }

            System.out.println("Case #" + tt + ": " + ans);
        }
    }
}
