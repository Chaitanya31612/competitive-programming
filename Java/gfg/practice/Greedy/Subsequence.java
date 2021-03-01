import java.util.*;

public class Subsequence {
    // static long countAlteringParity(int[] arr) {
    //     int n = arr.length;
    //     int ans = 0;
    //     for (int i = 0; i < n; i++) {
    //         int flag = arr[i] % 2;
    //         int count = 1;
    //         for (int j = i + 1; j < n; j++) {
    //             if (arr[j] % 2 == 1 && flag == 0) {
    //                 flag = 1;
    //                 count++;
    //             } else if (arr[j] % 2 == 0 && flag == 1) {
    //                 flag = 0;
    //                 count++;
    //             } else {
    //                 ans += (count * (count + 1)) / 2;
    //                 i = j;
    //                 break;
    //             }
    //         }

    //     }
    //     return ans;
    // }
    static long countAlteringParity(int[] arr) {
        int n = arr.length;
        int ans = 1;
        int count = 1;
        for (int i = 0; i < n - 1; i++) {
            if ((arr[i] + arr[i + 1]) % 2 == 1) {
                count++;
                ans = ans + count;
            } else {
                // ans = ans + (count * (count + 1)) / 2;
                count = 1;
            }
            
        }
        if ((arr[n - 1] + arr[n - 2]) % 2 == 0) {
            ans++;
        }

        if (ans == 0) {
            ans = n;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 1, 2, 1 };
        System.out.println(countAlteringParity(arr));
    }
}
