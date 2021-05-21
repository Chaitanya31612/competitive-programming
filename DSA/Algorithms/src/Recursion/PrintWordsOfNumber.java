package Recursion;

import java.util.Scanner;

public class PrintWordsOfNumber {

    public void print(String str) {
        if(str.length() <= 0) {
            return;
        }
        switch (str.charAt(0)) {
            case '0':
                System.out.print("Zero ");
                break;
            case '1':
                System.out.print("One ");
                break;
            case '2':
                System.out.print("Two ");
                break;
            case '3':
                System.out.print("Three ");
                break;
            case '4':
                System.out.print("Four ");
                break;
            case '5':
                System.out.print("Five ");
                break;
            case '6':
                System.out.print("Six ");
                break;
            case '7':
                System.out.print("Seven ");
                break;
            case '8':
                System.out.print("Eight ");
                break;
            case '9':
                System.out.print("Nine ");
                break;
            default:
                System.out.print("");
        }

        print(str.substring(1));
    }

    public void printInt(int n) {
        if(n <= 0) {
            return;
        }
        printInt(n / 10);
        switch (n % 10) {
            case 0:
                System.out.print("Zero ");
                break;
            case 1:
                System.out.print("One ");
                break;
            case 2:
                System.out.print("Two ");
                break;
            case 3:
                System.out.print("Three ");
                break;
            case 4:
                System.out.print("Four ");
                break;
            case 5:
                System.out.print("Five ");
                break;
            case 6:
                System.out.print("Six ");
                break;
            case 7:
                System.out.print("Seven ");
                break;
            case 8:
                System.out.print("Eight ");
                break;
            case 9:
                System.out.print("Nine ");
                break;
            default:
                System.out.print("");
        }
    }

    /* 2048 problem - two zero four eight */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // this will be a number
        String strNumber = sc.nextLine();
        int n = Integer.parseInt(strNumber);
        PrintWordsOfNumber p = new PrintWordsOfNumber();
        p.print(strNumber);
        System.out.println();
        p.printInt(n);

    }
}
