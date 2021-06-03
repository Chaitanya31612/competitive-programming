package Graphs;

import java.util.Arrays;
import java.util.Scanner;

public class FloodFill {

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    private static void floodFill(int[][] image, int i, int j, int originalColor, int newColor) {
        int r = image.length;
        int c = image[0].length;
        if(i < 0 || i >= r || j < 0 || j >= c) {
            return;
        }

        if(image[i][j] != originalColor) {
            return;
        }

        image[i][j] = newColor;
        for(int k = 0; k < 4; k++) {
            floodFill(image, i + dx[k], j + dy[k], originalColor, newColor);
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];

        if(newColor == originalColor) {
            return image;
        }

        floodFill(image, sr, sc, originalColor, newColor);
        return image;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] image = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                image[i][j] = sc.nextInt();
            }
        }

        int r = sc.nextInt();
        int c = sc.nextInt();
        int newColor = sc.nextInt();

        int[][] ans = floodFill(image, r, c, newColor);
        for(int[] a: ans) {
            System.out.println(Arrays.toString(a));
        }
    }
}
