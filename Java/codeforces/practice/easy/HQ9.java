//package easy;

import java.util.Scanner;

public class HQ9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        if(s.indexOf("H") != -1 || s.indexOf("Q") != -1 || s.indexOf("9") != -1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
