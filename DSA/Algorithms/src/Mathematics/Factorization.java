package Mathematics;

import java.util.ArrayList;
import java.util.Scanner;

public class Factorization {

    public ArrayList<Integer> prime_sieve(int n) {
        boolean[] p = new boolean[n + 1];

        p[2] = true;

        for(int i = 3; i <= n; i += 2) {
            p[i] = true;
        }

        for(int i = 3; i * i <= n; i += 2) {
            if(p[i]) {
                for(int j = i * i; j <= n; j += i) {
                    p[j] = false;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= n; i++) {
            if(p[i])
                primes.add(i);
        }

        return primes;
    }


    public ArrayList<Integer> factorise(int m, ArrayList<Integer> primes) {
        ArrayList<Integer> factors = new ArrayList<>();

        int i = 0;
        int p = primes.get(0);

        // check for prime factors less than root m
        while(p * p <= m) {
            if(m % p == 0) {
                factors.add(p);
                while (m % p == 0) {
                    m = m / p;
                }
            }

            i++;
            p = primes.get(i);
        }

        // if m is not 1 then it is prime
        if(m != 1) {
            factors.add(m);
        }

        return factors;
    }

    static int[] p;

    public void modifiedSieve(int n) {
        p = new int[n + 1];

        for(int i = 2; i <= n; i++) {
            p[i] = i;
        }

        for(int i = 2; i * i <= n; i++) {
            if(p[i] == i) {
                for(int j = 2 * i; j <= n; j += i) {
                    if(p[j] == j)
                        p[j] = i;
                }
            }
        }
    }

    public void printFactors(int n) {
        modifiedSieve(n);

        while(n > 0) {
            if(p[n] == n) {
                System.out.println(n);
                return;
            }

            System.out.print(p[n] + " * ");
            n = n / p[n];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Factorization f = new Factorization();
//        ArrayList<Integer> primes = f.prime_sieve(n);
//
//        ArrayList<Integer> factors = f.factorise(n, primes);
//
//        System.out.println(factors);

        f.printFactors(n);

    }
}
