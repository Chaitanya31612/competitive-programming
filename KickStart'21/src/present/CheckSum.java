package present;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckSum {

    public static int checkminusone(int[][] arr) {
        int n = arr.length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == -1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int[] findMin(int[][] b) {
        int n = b.length;
        int min = Integer.MAX_VALUE;
        int indi = -1, indj = -1;
        int[] ans = new int[3];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(b[i][j] < min) {
                    min = b[i][j];
                    indi = i;
                    indj = j;
                }
            }
        }
        ans[0] = indi;
        ans[1] = indj;
        ans[2] = min;
        return ans;
    }

    public static ArrayList<Integer> findRow(int[][] arr, int indi) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[indi][i] == -1) {
                list.add(i);
            }
        }
        return list;
    }

    public static ArrayList<Integer> findCol(int[][] arr, int indj) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i][indj] == -1) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int tt = 1; tt <= t; ++tt) {
            int n = sc.nextInt();
            int[][] arr= new int[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int[][] b = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    b[i][j] = sc.nextInt();
                }
            }

            int[] N = new int[n];
            for(int i = 0; i < n; i++) {
                N[i] = sc.nextInt();
            }
            int[] C = new int[n];
            for(int i = 0; i < n; i++) {
                C[i] = sc.nextInt();
            }

            int num = checkminusone(arr);
            int count = 0;
            while(num > 0) {
                int[] ans = findMin(b);
                int indi = ans[0];
                int indj = ans[1];
                int min = ans[2];

                arr[indi][indj] = 0;
                count += min;

                ArrayList<Integer> rcount = findRow(arr, indi);
                ArrayList<Integer> ccount = findCol(arr, indj);
                if(rcount.size() == 1) {
//                    arr[rcount.get(0)][indj]
                }
                if(ccount.size() == 1) {

                }
            }

            System.out.println("Case #" + tt + ": ");
        }
    }
}
