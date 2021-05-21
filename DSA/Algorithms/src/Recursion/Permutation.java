package Recursion;

import java.util.Scanner;

public class Permutation {


    public String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

    public void printPermutation(String str) {
        printPermutation(str, 0);
    }

    private void printPermutation(String str, int i) {
        // i denotes the index we are working on..
        if(i == str.length() - 1) {
            System.out.println(str);
            return;
        }

        // j is used to denote the index which will be swapped
        for(int j = i; j < str.length(); j++) {
            str = swap(str, i, j);
            printPermutation(str, i + 1);

            // below is backtracking step which resets the string to original string
            str = swap(str, i, j);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Permutation p = new Permutation();
        p.printPermutation(str);
    }
}
