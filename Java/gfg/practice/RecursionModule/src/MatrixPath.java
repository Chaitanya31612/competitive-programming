import java.util.Scanner;

public class MatrixPath {

    static int numberOfWays(int n, int m) {
        if(n == 1 || m == 1)
            return 1;

        // n-1 gives way to traverse n-1 rows and similarly m-1
        return numberOfWays(n-1, m) + numberOfWays(n, m-1);
    }

    public static void main(String[] args) {
        // number of ways to go from top left to bottom right with moves of right and down

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
//        int[][] arr = new int[n][m];
//
//        for(int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                arr[i][j] = sc.nextInt();
//            }
//        }

        System.out.println(numberOfWays(n, m));
    }
}
