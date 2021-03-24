//package easy;

import java.util.Scanner;

public class NextRound {
    public static int sum(int[] arr) {
        int s = 0;
        for(int i = 0; i < arr.length; i++) {
            s += arr[i];
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;
        if(sum(arr) > 0) {

            if(arr[k-1] > 0) {
                count = k;

                int j = k;
                while(j < n && arr[j] == arr[k-1]) {
                    count++;
                    j++;
                }
            } else {
                int j = 0;
                while(j < k && arr[j] > 0) {
                    count++;
                    j++;
                }
            }
        }

        System.out.println(count);
    }
}
