package Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class RatMazeFour {

    private static void findPathUtil(int[][] m, ArrayList<String> list, String str, int n, int i, int j) {
        if(i < 0 || i >= n || j < 0 || j >= n || m[i][j] == 0) {
            return;
        }

        // reached destination
        if(i == n - 1 && j == n - 1) {
            list.add(str);
            return;
        }

        m[i][j] = 0;
        findPathUtil(m, list, str + "D", n, i + 1, j);
        findPathUtil(m, list, str + "L", n, i, j - 1);
        findPathUtil(m, list, str + "R", n, i, j + 1);
        findPathUtil(m, list, str + "U", n, i - 1, j);
        m[i][j] = 1;
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> list = new ArrayList<>();
        String str = "";
        findPathUtil(m, list, str, n, 0, 0);
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            ArrayList<String> res = findPath(a, n);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}