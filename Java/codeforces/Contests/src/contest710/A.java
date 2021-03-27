package contest710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

//        System.out.println("abc".indexOf(""));
        int t = sc.nextInt();
        while(t-- > 0) {
           long n = sc.nextLong();
           long m = sc.nextLong();
           long x = sc.nextLong();

           if(x == 1 || x == n*m) {
               System.out.println(x);
           } else {
               long col = (long) Math.ceil((double)x/ (double) n);
               long row = x % n;
               if(row == 0) {
                   row = n;
               }

               long ans = (row - 1) * m + col;

               System.out.println(ans);
           }
        }
    }
}
