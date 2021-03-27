//package easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Candies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            // x[2^k - 1]
            int len = Integer.toBinaryString(n).length();
            int x = -1;
            for(int k = len; k > 1; k--) {
                int val = (int)Math.pow(2, k) - 1;
                if(n % val == 0) {
                    x = n / val;
                }
            }

            System.out.println(x);
        }
    }
}
