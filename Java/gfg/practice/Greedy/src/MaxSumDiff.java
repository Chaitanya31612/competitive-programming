import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaxSumDiff {

    static int maxSum(int[] arr, int n) {

        List<Integer> list = new ArrayList<>();

        Arrays.sort(arr);

        for(int i = 0; i < n/2; i++) {
            list.add(arr[i]);
            list.add(arr[n-i-1]);
        }

        if((n&1) == 1) {
            list.add(arr[n/2]);
        }

        int sum = 0;
        for(int i = 0; i < n-1; i++) {
            sum += Math.abs(list.get(i) - list.get(i+1));
        }

        sum += Math.abs(list.get(n-1) - list.get(0));

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(maxSum(arr, n));
        }
    }
}
