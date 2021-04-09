import java.util.Arrays;

public class MinCostPath {

    public static int minCostPath(int[][] arr) {
        return minCostPath(arr, 0, 0);
    }

    private static int minCostPath(int[][] arr, int i, int j) {
        // rows
        int m = arr.length;
        // columns
        int n = arr[0].length;

        // index is out of bounds of array
        if(i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        if((i == m - 1) && (j == n - 1)) {
            return arr[i][j];
        }

        // move down
        int op1 = minCostPath(arr, i + 1, j);

        // move diagonally
        int op2 = minCostPath(arr, i + 1, j + 1);

        // move right
        int op3 = minCostPath(arr, i, j + 1);

        int minCost = Math.min(op1, Math.min(op2, op3));

        return arr[i][j] + minCost;
    }


    public static int minCostPathM(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        int[][] storage = new int[m][n];
        for(int[] row : storage)
            Arrays.fill(row, -1);

        return minCostPathM(arr, 0, 0, storage);
    }

    private static int minCostPathM(int[][] arr, int i, int j, int[][] storage) {
        int m = arr.length;
        int n = arr[0].length;

        if(i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        if((i == m - 1) && (j == n - 1)) {
            storage[i][j] = arr[i][j];
            return arr[i][j];
        }

        if(storage[i][j] != -1) {
            return storage[i][j];
        }

        // move down
        int op1 = minCostPathM(arr, i + 1, j, storage);

        // move diagonally
        int op2 = minCostPathM(arr, i + 1, j + 1, storage);

        // move right
        int op3 = minCostPathM(arr, i, j + 1, storage);

        int minCost = Math.min(op1, Math.min(op2, op3));

        storage[i][j] = arr[i][j] + minCost;
        return storage[i][j];
    }


    /* DP */
    public static int minCostPathDP(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] storage = new int[m][n];
        storage[m - 1][n - 1] = arr[m - 1][n - 1];

        // fill the last row
        for(int j = n - 2; j >= 0; j--) {
            storage[m - 1][j] = arr[m - 1][j] + storage[m - 1][j + 1];
        }

        // last column
        for(int i = m - 2; i >= 0; i--) {
            storage[i][n - 1] = arr[i][n - 1] + storage[i + 1][n - 1];
        }

        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                // move down
                int op1 = storage[i + 1][j];

                // move diagonally
                int op2 = storage[i + 1][j + 1];

                // move right
                int op3 = storage[i][j + 1];

                int minCost = Math.min(op1, Math.min(op2, op3));

                storage[i][j] = arr[i][j] + minCost;
            }
        }

        return storage[0][0];
    }


    public static void main(String[] args) {

        int[][] arr = { {1, 1, 1}, {4, 5, 2}, {7, 8, 9},
                        {1, 1, 1}, {4, 5, 2}, {7, 8, 9},
                        {1, 1, 1}, {4, 5, 2}, {7, 8, 9},};
        /*
        * 1  1  1
        * 4  5  2
        * 7  8  9
        *
        * the mincost path is
        * 1 -> 1 -> 2 -> 9 = 13
        * */

        long start, end;

        start = System.currentTimeMillis();
        System.out.println(minCostPathDP(arr));
        end = System.currentTimeMillis();
        System.out.println("It takes " +
                (end - start) + "ms");


        start = System.currentTimeMillis();
        System.out.println(minCostPathM(arr));
        end = System.currentTimeMillis();
        System.out.println("It takes " +
                (end - start) + "ms");


        start = System.currentTimeMillis();
        System.out.println(minCostPath(arr));
        end = System.currentTimeMillis();
        System.out.println("It takes " +
                (end - start) + "ms");
    }
}
