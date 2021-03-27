//package easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Puzzles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] fArr = new int[m];
        for(int i = 0; i < m; i++) {
            fArr[i] = sc.nextInt();
        }

        Arrays.sort(fArr);

        int[] aux = new int[m];
        aux[0] = 0;
        for(int i = 0; i < m-1; i++) {
            aux[i+1] = aux[i+1] - aux[i];
        }

        int c = 0;
        int minDiff = Integer.MAX_VALUE;
        while(c + n - 1 < m) {
            int diff = fArr[c+n-1] - fArr[c];
//            System.out.println(c + " - " + diff);
            minDiff = Math.min(minDiff, diff);
            c += 1;
        }

        System.out.println(minDiff);
    }
}
