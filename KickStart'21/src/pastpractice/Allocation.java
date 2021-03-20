package pastpractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Allocation {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int tt = 1; tt <= t; ++tt) {
            int n = in.nextInt();
            int b = in.nextInt();

            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            Arrays.sort(arr);

            int sum = 0;
            int count = 0;
            for(int i = 0; i < n; i++) {
                sum = sum + arr[i];
                if(sum <= b) {
                    count++;
                } else {
                    break;
                }
            }


            System.out.println("Case #" + tt + ": " + count);
        }
    }
}
