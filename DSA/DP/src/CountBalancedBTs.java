import java.util.Scanner;

public class CountBalancedBTs {

    /* count balanced binary trees of height h */
    static int mod = (int)Math.pow(10, 9) + 7;
    public static int countBalancedBT(int h) {
        if(h <= 1) {
            return 1;
        }

        int x = countBalancedBT(h - 1);
        int y = countBalancedBT(h - 2);

        /* total combination includes
        * number of (h-1)(h-1)
        * 2*(h-1)(h-2) */

        long res1 = ((long)x * x); // long is used because x*x may not stored in long but value is int
        long res2 = ((long)x * y * 2);
        int value1 = (int)(res1 % mod);
        int value2 = (int)(res2 % mod);
        // mod is used to keep the value in integer range
        return (value1 + value2) % mod;
    }


    /* memoization */
    public static int countBalancedBTM(int h) {
        int[] storage = new int[h + 1];
        return countBalancedBTM(h, storage);
    }

    private static int countBalancedBTM(int h, int[] storage) {
        if(h <= 1) {
            storage[h] = 1;
            return storage[h];
        }

        int x = 0, y = 0;
        if(storage[h - 1] != 0) {
            x = storage[h - 1];
        } else {
            x = countBalancedBT(h - 1);
        }

        if(storage[h - 2] != 0) {
            y = storage[h - 2];
        } else {
            y = countBalancedBT(h - 2);
        }

        /* total combination includes
                * number of (h-1)(h-1)
                * 2*(h-1)(h-2) */

        long res1 = ((long)x * x);
        long res2 = ((long)x * y * 2);
        int value1 = (int)(res1 % mod);
        int value2 = (int)(res2 % mod);

        storage[h] = (value1 + value2) % mod;
        return storage[h];
    }


    /*DP*/
    public static int countBalancedBTDP(int h) {
        int[] storage = new int[h + 1];
        storage[0] = 1;
        storage[1] = 1;

        for(int i = 2; i <= h; i++) {
            int x = storage[i - 1];
            int y = storage[i - 2];

            long res1 = ((long)x * x);
            long res2 = ((long)x * y * 2);
            int value1 = (int)(res1 % mod);
            int value2 = (int)(res2 % mod);
            storage[i] = (value1 + value2) % mod;
        }

        return storage[h];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter height");
        int h = sc.nextInt();

        /*DP*/
        long start = System.currentTimeMillis();
        System.out.println(countBalancedBTDP(h));
        long end = System.currentTimeMillis();
        System.out.println("It takes " +
                (end - start) + "ms");

        /*Memoization*/
        start = System.currentTimeMillis();
        System.out.println(countBalancedBTM(h));
        end = System.currentTimeMillis();
        System.out.println("It takes " +
                (end - start) + "ms");

        /*recursive*/
        start = System.currentTimeMillis();
        System.out.println(countBalancedBT(h));
        end = System.currentTimeMillis();
        System.out.println("It takes " +
                (end - start) + "ms");
    }
}
