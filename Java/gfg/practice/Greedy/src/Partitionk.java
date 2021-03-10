import java.util.Arrays;
import java.util.Comparator;

public class Partitionk {

    static int maxSum(Integer[] arr, int k) {
        Arrays.sort(arr, Comparator.reverseOrder());

        int S = 0, S1 = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            S += arr[i];
        }

        // pick k or n-k largest number
        int M = Math.max(k, n-k);
        for(int i = 0; i < M; i++) {
            S1 += arr[i];
        }

        return S1 - (S - S1);
    }

    static int maxSum1(int[] arr, int k) {
        Arrays.sort(arr);

        int n = arr.length;
        int sum1 = 0, sum2 = 0;
        for(int i = 0; i < k; i++) {
            sum1 += arr[i];
        }


        for(int i = n-k-1; i < n; i++) {
            sum2 += arr[i];
        }

        return sum2 - sum1;
    }

    public static void main(String[] args) {
        Integer[] arr = {8, 4, 5, 2, 10};
        int k = 2;

        System.out.println(maxSum(arr, k));
    }
}
