import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {

    /* to get nth fibonacci number - O(2^n) */
    public static int fib(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        return fib(n-1) + fib(n-2);
    }

    /* get nth fibonacci number using memoization
    * time - O(n)
    * Space - O(n+1) and stack
    * top down approach */

    public static int fibM(int n) {
        int storage[] = new int[n + 1];
        Arrays.fill(storage, -1);

        return fibM(n, storage);
    }

    public static int fibM(int n, int[] storage) {
        // base case
        if(n == 0 || n == 1) {
            storage[n] = n;
            return storage[n];
        }

        // check if value for fib call present in array
        if(storage[n] != -1) {
            return storage[n];
        }

        // if not present then calculate the values and store them in array
        storage[n] = fibM(n - 1, storage) + fibM(n - 2, storage);

        return storage[n];
    }


    /* get nth fibonacci number using DP
    * time - O(n)
    * bottom up approach
    * iterative solution, slightly better than memoization */
    public static int fibDP(int n) {
        int[] storage = new int[n + 1];
        storage[0] = 0;
        storage[1] = 1;

        for(int i = 2; i <= n; i++) {
            storage[i] = storage[i - 1] + storage[i - 2];
        }

        return storage[n];
    }


    /* Bottom up - dp space optimised */
    public static int fibDPBetter(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        int a = 0;
        int b = 1;
        int c = 1;
        for(int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long start = System.currentTimeMillis();
        System.out.println(fibDP(n));
        long end = System.currentTimeMillis();
        System.out.println("It takes " +
                (end - start) + "ms");

        System.out.println(fibM(n));
        end = System.currentTimeMillis();
        System.out.println("It takes " +
                (end - start) + "ms");

        System.out.println(fib(n));
        end = System.currentTimeMillis();
        System.out.println("It takes " +
                (end - start) + "ms");
    }
}
