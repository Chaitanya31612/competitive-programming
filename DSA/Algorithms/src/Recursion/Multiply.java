package Recursion;

import java.util.Scanner;

public class Multiply {

    // Calculate (a * b) without *
    public int multiply(int a, int b) {
        if(b == 1) {
            return a;
        }

        return a + multiply(a, b - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        Multiply m = new Multiply();
        System.out.println(m.multiply(a, b));
    }

}
