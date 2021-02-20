import java.util.*;

public class QuickSort {

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= (high - 1); j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // bring pivot element to it's correct position
        // swap i+1 and pivot
        arr[high] = arr[i + 1];
        arr[i + 1] = pivot;

        return i + 1;
    }

    public void sort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }


    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;

        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr, 0, n - 1);
        

        printArray(arr);
    }
}