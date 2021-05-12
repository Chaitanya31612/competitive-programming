package SegmentTree;

import java.util.Arrays;
import java.util.Scanner;

public class SparseMatrix {

    static int n, m;
    static int[] arr;
    static int[][] matrix;

    public static int log2(int N) {

        return (int)(Math.log(N) / Math.log(2));
    }

    public static void fillMatrix() {
        for(int j = 0; j < m; j++) {
            for(int i = 0; i < n; i++) {
                // first column
                if(j == 0) {
                    matrix[i][j] = arr[i];
                }
                // out of bounds
                else if((i + (1 << j) - 1) > m) {
                    break;
                }
                else {
                    int first_start, first_end, second_start, second_end;
                    first_start = i;
                    first_end = j - 1;
                    // end of big query
                    int big_end = (i + (1<<j) - 1); // i + 2^j-1 - 1
                    // length of small first query
                    int length_small_query = (1<<(j-1)); // 2^j-1
                    second_start = (big_end - length_small_query) + 1;
                    second_end = j - 1;

                    matrix[i][j] = Math.min(matrix[first_start][first_end], matrix[second_start][second_end]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        m = (int)Math.ceil(log2(n)) + 1;
        System.out.println(m);
        matrix = new int[n][m];

        fillMatrix();

        for(int[] a : matrix)
            System.out.println(Arrays.toString(a));
    }

}
