package Mathematics;

import java.util.ArrayList;
import java.util.Scanner;

public class TotientCoprimes {

    // know as totient or Euler Phi function
    // used to find number of coprimes with a number smaller than that number

    public ArrayList<Integer> factors(int n) {
        Factorization f = new Factorization();
        ArrayList<Integer> primes = f.prime_sieve(n);

        return f.factorise(n, primes);
    }

    /*
    * eg -
    * phi(8) -> [1,3,5,7] (4)
    * phi(9) -> [1,2,4,5,7,8] (6)
    */
    public int totient(int n) {
        ArrayList<Integer> factors = factors(n);

        int phi = n;

        for(int p : factors) {
            phi *= (1 - (1/(double)p));
        }

        return phi;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        TotientCoprimes t = new TotientCoprimes();
        System.out.println(t.factors(n));
        System.out.println(t.totient(n));
    }
}
