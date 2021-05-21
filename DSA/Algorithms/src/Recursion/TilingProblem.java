package Recursion;

import java.util.Scanner;

public class TilingProblem {

    // returns number of ways of arrangement of tiles
    public int tilingProblem(int n) {
        if(n <= 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 4) {
            return 2;
        }

        return tilingProblem(n - 1) + tilingProblem(n - 4);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /* Given a 4 * N grid and tiles of size 4*1 and 1*4, find number of ways of arranging those tiles
        * */

        int n = sc.nextInt();
        TilingProblem t = new TilingProblem();
        System.out.println(t.tilingProblem(n));
    }
}
