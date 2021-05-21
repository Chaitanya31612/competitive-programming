package Recursion;

import java.util.Scanner;

public class PrintNumbers {

    public void decreasingOrder(int n) {
        if(n == 0) {
            return;
        }

        System.out.print(n + " ");
        decreasingOrder(n -1);
    }

    public void increasingOrder(int n) {
        if(n == 0) {
            return;
        }

        increasingOrder(n - 1);
        System.out.print(n + " ");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PrintNumbers p = new PrintNumbers();
        p.decreasingOrder(n);
        System.out.println();
        p.increasingOrder(n);
    }
}
