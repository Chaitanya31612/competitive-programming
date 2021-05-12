package Mathematics;

import java.util.Scanner;

public class SieveOfEratostenes {

    public static void primeSieve(boolean[] primes, int n) {
        // set all value as true initially
        for(int i = 2; i < n; i++) {
            primes[i] = true;
        }

        for (int i = 2; i < n; i++) {
            if(primes[i]) {
                for(int j = 2 * i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }

    }

    public static void primeSieveBetter(boolean[] primes, int n) {
        primes[2] = true;
        for(int i = 3; i < n; i += 2) {
            primes[i] = true;
        }

        for (int i = 3; i < n; i += 2) {
            if(primes[i]) {
                for(int j = i * i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        boolean[] primes = new boolean[n + 1];

        long startTime, endTime;
        startTime = System.nanoTime();
        primeSieve(primes, n + 1);
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        primeSieveBetter(primes, n + 1);
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        for(int i = 2; i < n + 1; i++) {
            if(primes[i])
                System.out.println(i);
        }
    }
}
