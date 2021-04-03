package aprilday;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        n = n % 9;
        // digital sum
        if(n == 0)
            n = 9;

        System.out.println(n);
    }
}
