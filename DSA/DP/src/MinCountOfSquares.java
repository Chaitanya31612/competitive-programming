import java.util.Arrays;
import java.util.Scanner;

public class MinCountOfSquares {

    /* recursive
    * eg - 10 = 3^2 + 1^2 */

    public static int minCount(int n) {
        if(n <= 3) {
            return n;
        }

        int min = n; // let it be through all ones
        for(int i = 1; i * i <= n; i++) {
            min = Math.min(min, (1 + minCount(n - i*i)));
        }

        return min;
    }


    /* using memoization - top down approach */
    public static int minCountM(int n) {
        int[] storage = new int[n + 1];
        Arrays.fill(storage, -1);
        return minCountM(n, storage);
    }

    private static int minCountM(int n, int[] storage) {
        if(n <= 3) {
            storage[n] = n;
            return storage[n];
        }

        int min = n;
        for(int i = 1; i * i <= n; i++) {
            if(storage[n - (i * i)] != -1) {
                min = storage[n - (i * i)];
            } else {
                min = Math.min(min, (1 + minCount(n - (i*i))));
            }
        }

        storage[n] = min;
        return storage[n];
    }


    /* using dp - bottom up
    * very fast */
    public static int minCountDP(int n) {
        int[] storage = new int[n + 1];
        // base conditions
        for(int i = 0; i <= 3; i++) {
            storage[i] = i;
        }

        for(int i = 4; i <= n; i++) {
            int min = i;
            for(int j = 1; j * j <= i; j++) {
                min = Math.min(min, 1 + storage[i - (j * j)]);
            }
            storage[i] = min;
        }

        return storage[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int n = sc.nextInt();

        long start = System.currentTimeMillis();
        System.out.println(minCountDP(n));
        long end = System.currentTimeMillis();
        System.out.println("It takes " +
                (end - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println(minCountM(n));
        end = System.currentTimeMillis();
        System.out.println("It takes " +
                (end - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println(minCount(n));
        end = System.currentTimeMillis();
        System.out.println("It takes " +
                (end - start) + "ms");
    }
}
