import java.util.Arrays;

public class MinCoins {

    /* DP - bottom up */
    public static int minCoinsDP(int[] coins, int n) {
        int[] storage = new int[n + 1];
        Arrays.fill(storage, Integer.MAX_VALUE);
        storage[0] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0) {
                    int subAns = storage[i - coins[j]];
                    storage[i] = Math.min(storage[i], subAns + 1);
                }
            }
        }

        return storage[n];
    }


    /* Memoization - top down */
    private static int minCoinsM(int[] coins, int n, int[] storage) {
        if(n == 0) {
            return 0;
        }

        if(storage[n] != -1) {
            return storage[n];
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            if(n - coins[i] >= 0) {
                int subAns = minCoins(coins, n - coins[i]);
                ans = Math.min(ans, subAns + 1);
            }
        }

        storage[n] = ans;
        return storage[n];
    }

    public static int minCoinsM(int[] coins, int n) {
        int[] storage = new int[n + 1];
        Arrays.fill(storage, -1);
        return minCoinsM(coins, n, storage);
    }


    /* recursive */
    public static int minCoins(int[] coins, int n) {
        if(n == 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            if(n - coins[i] >= 0) {
                int subAns = minCoins(coins, n - coins[i]);
                ans = Math.min(ans, subAns + 1);
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int n = 15;
        int[] coins = { 1, 7, 10 };

        System.out.println(minCoinsDP(coins, n));
        System.out.println(minCoinsM(coins, n));
        System.out.println(minCoins(coins, n));
    }
}
