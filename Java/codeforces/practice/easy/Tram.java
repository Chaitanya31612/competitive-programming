package easy;

import java.util.Scanner;

public class Tram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] aArr = new int[n];
        int[] bArr = new int[n];
        int count = 0;
        for(int i = 0; i < n; i++) {
            aArr[count] = sc.nextInt();
            bArr[count] = sc.nextInt();
            count++;
        }

        int max = bArr[0], current = bArr[0];
        for(int i = 1; i < n-1; i++) {
            current = current - aArr[i] + bArr[i];
            max = Math.max(max, current);
        }
        System.out.println(max);
    }
}
