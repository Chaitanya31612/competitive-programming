package Recursion;

import java.util.Scanner;

public class BinarySearch {

    // it searches in logn time - condition being, array should be sorted
    public int binarySearch(int[] arr, int s, int e, int key) {
        if(s > e) {
            return -1;
        }

        int mid = (s + e) / 2;
        if(arr[mid] == key) {
            return mid;
        }
        else if(arr[mid] < key) {
            return binarySearch(arr, mid + 1, e, key);
        } else {
            return binarySearch(arr, s, mid, key);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int key = sc.nextInt();
        BinarySearch b = new BinarySearch();
        System.out.println(b.binarySearch(arr, 0, n - 1, key));
    }
}
