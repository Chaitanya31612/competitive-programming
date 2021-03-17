package easy;

import java.util.Scanner;

public class Subtraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        while(k-- > 0) {
            int r = n % 10;
            if(r == 0) {
                n = n / 10;
            } else {
                n = n - 1;
            }
        }

        System.out.println(n);
    }
}
