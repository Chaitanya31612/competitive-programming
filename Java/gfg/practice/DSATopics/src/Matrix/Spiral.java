package Matrix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Spiral {

    static ArrayList<Integer> list;

    /*
    * i - start row
    * j - start col
    * m - end row
    * n - end col
    * */
    public static void spirallyTraverseUtil(int[][] matrix, int i, int j, int m, int n) {
        // base case - out of bounds check
        if(i > m || j > n) {
            return;
        }

        // first row
        for(int ind = i; ind <= n; ind++) {
            list.add(matrix[i][ind]);
        }

        // last column
        for(int ind = i + 1; ind <= m; ind++) {
            list.add(matrix[ind][n]);
        }

        // last row if it is not equal to first row
        if(m != i) {
            for(int ind = n - 1; ind >= j; ind--) {
                list.add(matrix[m][ind]);
            }
        }

        // first col if it is not equal to last col
        if(n != j) {
            for(int ind = m - 1; ind >= i + 1; ind--) {
                list.add(matrix[ind][j]);
            }
        }

        spirallyTraverseUtil(matrix, i + 1, j + 1, m - 1, n - 1);
    }

    static ArrayList<Integer> spirallyTraverse(int[][] matrix, int r, int c) {
        list = new ArrayList<>(r * c);

        spirallyTraverseUtil(matrix, 0, 0,  r - 1, c - 1);

        return list;
    }

    public static void main(String[] args)throws IOException
    {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] matrix = new int[r][c];

        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
                matrix[i][j] = sc.nextInt();
        }

        ArrayList<Integer> ans = spirallyTraverse(matrix, r, c);
        for (Integer val: ans)
            System.out.print(val+" ");
        System.out.println();

    }
}

/* Sample Input
4 4
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

output
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10


input 2
3 4
1 2 3 4
5 6 7 8
9 10 11 12

1 2 3 4 8 12 11 10 9 5 6 7
* */