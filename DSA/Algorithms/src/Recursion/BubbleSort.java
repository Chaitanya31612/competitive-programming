package Recursion;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

    public void bubbleSortIter(int[] arr, int n) {

        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < (n - i - 1); j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void bubbleSortRec(int[] arr, int n) {
        if(n <= 1) {
            return;
        }

        for(int j = 0; j < (n - 1); j++) {
            if(arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        bubbleSortRec(arr, n - 1);
    }

    // this will eliminate all loops - complete recursion
    public void bubbleSortRec2(int[] arr, int j, int n) {
        if(n == 1) {
            return;
        }
        if(j == n - 1) {
            j = 0;
            bubbleSortRec2(arr, j, n - 1);
            return;
        }

        if(arr[j] > arr[j + 1]) {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        }

        bubbleSortRec2(arr, j + 1, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(Arrays.toString(arr));
        BubbleSort b = new BubbleSort();
//        b.bubbleSortIter(arr, n);
//        b.bubbleSortRec(arr, n);
        b.bubbleSortRec2(arr, 0, n);
        System.out.println(Arrays.toString(arr));
    }
}
