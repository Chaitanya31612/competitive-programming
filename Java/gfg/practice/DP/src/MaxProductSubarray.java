import java.util.Scanner;

public class MaxProductSubarray {

    public static long maxProduct(int[] arr, int n) {
        int count_neg = 0, count_zero = 0, min_neg = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                count_zero++;
            }
            if(arr[i] < 0) {
                count_neg++;
                min_neg = Math.max(min_neg, arr[i]);
            }
        }

        if(count_zero == n) {
            return 0;
        }

        int ans = 1;
        for(int i = 0; i < n; i++) {
            if(arr[i] != 0) {
                ans = ans * arr[i];
            }
        }
        if((count_neg&1) == 0) {
            return ans;
        } else {
            return ans / min_neg;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(maxProduct(arr, n));
    }
}
