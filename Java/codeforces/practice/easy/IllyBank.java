//package easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IllyBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        long n = sc.nextLong();

        if(n >= 0) {
            System.out.println(n);
        } else {

            n = -1 * n;
            String temp = String.valueOf(n);
            long last = Integer.parseInt(temp.substring(temp.length() - 1));
            long seclast = Integer.parseInt(temp.substring(temp.length() - 2, temp.length() - 1));

            if(last >= seclast) {
                n = n / 10;
            } else {
                n = n / 100;
                n = n*10 + last;
            }
            System.out.println(-1 * n);
        }
    }
}
