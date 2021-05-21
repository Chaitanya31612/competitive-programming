package Recursion;

import java.util.Scanner;

public class CheckSorted {
    public boolean checkSorted(int[] arr, int s, int e) {
        if(s == e) {
            return true;
        }

        boolean check = arr[s] <= arr[s + 1];
        return check && checkSorted(arr, s + 1, e);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        CheckSorted c = new CheckSorted();
        System.out.println(c.checkSorted(arr, 0, n-1));
    }
}
