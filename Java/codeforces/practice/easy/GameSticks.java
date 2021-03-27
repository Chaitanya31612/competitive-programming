//package easy;

import java.util.Scanner;

public class GameSticks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int ans = 0; // 1 - akshit 2 - malvika

        while(n > 0 && m > 0) {
            ans = (ans == 0) ? 1 : 0;
            n--;
            m--;
        }

        if(ans == 1) {
            System.out.println("Akshat");
        } else {
            System.out.println("Malvika");
        }
    }
}
