package easy;

import java.util.Scanner;

public class Bear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int count = 0;
        while(a <= b) {
            a = 3*a;
            b = 2*b;
            count++;
        }

        System.out.println(count);
    }
}
