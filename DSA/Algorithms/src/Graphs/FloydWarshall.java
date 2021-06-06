package Graphs;

import java.util.Arrays;
import java.util.Scanner;

public class FloydWarshall {

    public void shortest_distance(int[][] matrix) {
        int n = matrix.length;

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if((matrix[i][k] != -1) && (matrix[k][j] != -1) &&
                            (matrix[i][k] + matrix[k][j] < matrix[i][j])) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        FloydWarshall f = new FloydWarshall();
        f.shortest_distance(matrix);

        for(int[] a: matrix)
            System.out.println(Arrays.toString(a));
    }
}

/* Sample
2
0 25
-1 0

[0, 25]
[-1, 0]

3
0 1 43
1 0 6
-1 -1 0
[0, 1, 7]
[1, 0, 6]
[-1, -1, 0]
* */