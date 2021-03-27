package lunchtimemarch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Dinner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = sc.nextInt();
        while (t-- > 0) {
            long a = sc.nextLong();
            long y = sc.nextLong();
            long x = sc.nextLong();

            if(y > a) {
                long ans = a*x + 1;
                System.out.println(ans);
            } else if(y == a) {
                long ans = a*x;
                System.out.println(ans);
            } else {
                long[] candles = new long[(int)a+1];
                candles[0] = 1;
                for(long i = 1; i <= a; i++) {
                    candles[(int)i] = candles[(int)i-1] + x;
                    if(i >= y) {
                        candles[(int)i] = candles[(int)i] - candles[(int)(i-y)];
                    }
                }

//                System.out.println(Arrays.toString(candles));
                System.out.println(candles[(int)a]);
            }
        }
    }
}
