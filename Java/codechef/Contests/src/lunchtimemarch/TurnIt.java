package lunchtimemarch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TurnIt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = sc.nextInt();
        while(t-- > 0) {
            long u = sc.nextLong();
            long v = sc.nextLong();
            long a = sc.nextLong();
            long s = sc.nextLong();

            if(u == 1 && v == 1) {
                System.out.println("YES");
            } else {
                long cal = (long)Math.pow(u, 2) - 2 * a * s;
                long vsqred = (long)Math.pow(v,2);

                System.out.println(cal);
                System.out.println(vsqred);
                if(cal > vsqred) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }
    }
}
