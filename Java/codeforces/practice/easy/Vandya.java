package easy;

import java.util.Scanner;

public class Vandya {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int h = sc.nextInt();
        int[] arr = new int[n];

        int width = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

            if(arr[i] > h) {
                width = width + 2;
            } else {
                width++;
            }
        }

        System.out.println(width);

    }
}
