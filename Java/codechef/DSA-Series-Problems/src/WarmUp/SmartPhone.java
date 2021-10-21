package WarmUp;

import java.util.Arrays;
import java.util.Scanner;

public class SmartPhone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        long ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            long currAns = (long) arr[i] * (n - i);
            ans = Math.max(ans, currAns);
        }

        System.out.println(ans);
    }
}
