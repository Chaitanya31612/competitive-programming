package Mathematics;

import java.util.Scanner;

public class Prime {

    public static boolean isPrime(int n) {
        if(n == 1)
            return false;

        // if number is even it is always non prime
        if (n % 2 == 0)
            return false;

        for(int i = 3; i * i <= n; i += 2) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(isPrime(n));
    }
}
