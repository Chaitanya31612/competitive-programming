package Mathematics;

import java.util.Arrays;
import java.util.Scanner;

public class SegmentedSieve {


    public static boolean[] sieve(int n) {
        boolean[] p = new boolean[n];
        p[2] = true;
        for(int i = 3; i < n; i += 2) {
            p[i] = true;
        }

        for (int i = 3; i < n; i += 2) {
            if(p[i]) {
                for(int j = i * i; j < n; j += i) {
                    p[j] = false;
                }
            }
        }

        return p;
    }


    public static boolean[] getPrimes(int a, int b, boolean[] p) {
        boolean[] primes = new boolean[b - a + 1];
        Arrays.fill(primes, true);
        for(int i = 0; i < p.length; i++) {
            for(int j = a; j <= b; j++) {
                if(p[i]) {
                    // if two arrays overlapped
                    if(i == j)
                        continue;
                    if(j % i == 0) {
                        primes[j - a] = false;
                    }
                }
            }
        }

        return primes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        // segmented sieve is used to find prime numbers in a given range
        int rootb = (int)Math.ceil(Math.sqrt(b));
        boolean[] p = sieve(rootb);
        boolean[] primes = getPrimes(a, b, p);

        for(int i = 2; i < primes.length; i++) {
            if(primes[i])
                System.out.println(a + i);
        }
    }
}
