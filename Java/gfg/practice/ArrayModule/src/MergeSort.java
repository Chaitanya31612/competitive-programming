import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    public static void mergeSort(int[] arr, int s, int e) {
        if(s >= e) {
            return;
        }

        int mid = (s + e) / 2;
        mergeSort(arr, s, mid);
        mergeSort(arr, mid + 1, e);
        merge(arr, s, mid, e);
    }

    public static void merge(int[] arr, int s, int mid, int e) {
        int[] ans = new int[e - s + 1];

        int i = s, j = mid + 1, k = 0;

        while(i <= mid && j <= e) {
            if(arr[i] < arr[j]) {
                ans[k++] = arr[i++];
            } else {
                ans[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            ans[k++] = arr[i++];
        }

        while (j <= e) {
            ans[k++] = arr[j++];
        }

        for(int idx = 0; idx < ans.length; idx++) {
            arr[s + idx] = ans[idx];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        mergeSort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }
}
