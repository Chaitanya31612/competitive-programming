package easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Kefa {

    public static int solution1(int[] arr, int n) {
        int maxCount = 0;

        for(int i = 0; i < n; i++) {
            int count = 1;
            for(int j = i+1; j < n; j++)  {
                if(arr[j] >= arr[i] && arr[j] >= arr[j-1]) {
                    count++;
                } else {
                    break;
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    public static int solution2(int[] arr, int n) {
        int[] aux = new int[n];
        aux[0] = 0;
        for(int i = 0; i < n - 1; i++) {
            aux[i+1] = arr[i+1] - arr[i];
        }

        int count = 1, maxCount = 1;
        for(int i = 0; i < n - 1; i++) {
            if(aux[i+1] >= 0) {
                count++;
            } else {
                count = 1;
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

//        int ans = solution1(arr, n);
        int ans = solution2(arr, n);

        System.out.println(ans);
    }
}
