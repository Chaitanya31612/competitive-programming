//package easy;

import java.util.Scanner;

public class Elephant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        int r = x % 5;
        int ans = 0;
        if(r == 0) {
            ans = x / 5;
        } else {
            ans = (x - r) / 5 + 1;
        }

        System.out.println(ans);
    }
}
