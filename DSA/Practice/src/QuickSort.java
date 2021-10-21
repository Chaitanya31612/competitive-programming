import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void quickSort(int[] arr, int s, int e) {
        if(s < e) {
            int pivotIndex = partition(arr, s, e);
            quickSort(arr, s, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, e);
        }
    }

    public static int partition(int[] arr, int s, int e) {
        int pivot = arr[e];
        int i = s - 1; // for sorting element smaller than pivot
        int temp;

        for(int j = s; j <= e - 1; j++) {
            if(arr[j] < pivot) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[i + 1];
        arr[i + 1] = arr[e];
        arr[e] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        quickSort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }
}
