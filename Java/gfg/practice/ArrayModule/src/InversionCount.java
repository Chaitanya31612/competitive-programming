import java.util.Arrays;
import java.util.Scanner;

public class InversionCount {

    /*
    https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1#
    Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum.
    Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
    * */

    static int count = 0;

    public static long inversionCountBetter(long[] arr, long n) {
        // Use merge sort
        mergeSort(arr, 0, n - 1);
        return count;
    }

    public static void mergeSort(long[] arr, long s, long e) {
        if(s >= e) {
            return;
        }

        long mid = (s + e) / 2;
        mergeSort(arr, s, mid);
        mergeSort(arr, mid + 1, e);
        merge(arr, (int)s, (int)mid, (int)e);
    }

    public static void merge(long[] arr, int s, int mid, int e) {
        int i = s, j = mid + 1;
        int n1 = mid - s + 1;

        while(i <= mid && j <= e) {
            if(arr[i] >= arr[j]) {
                count += (n1 - i);
                j++;
            } else {
                i++;
            }
        }
    }

    private static int mergeAndCount(long[] arr, int l,
                                     int m, int r)
    {

        // Left subarray
        long[] left = Arrays.copyOfRange(arr, l, m + 1);

        // Right subarray
        long[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
        return swaps;
    }

    // Merge sort function
    private static int mergeSortAndCount(long[] arr, int l,
                                         int r)
    {

        // Keeps track of the inversion count at a
        // particular node of the recursion tree
        int count = 0;

        if (l < r) {
            int m = (l + r) / 2;

            // Total inversion count = left subarray count
            // + right subarray count + merge count

            // Left subarray count
            count += mergeSortAndCount(arr, l, m);

            // Right subarray count
            count += mergeSortAndCount(arr, m + 1, r);

            // Merge count
            count += mergeAndCount(arr, l, m, r);
        }

        return count;
    }


    // Time - O(n^2)
    static long inversionCount(long[] arr, long n)
    {
        long count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[i]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long[] arr = new long[(int)n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        long ans = inversionCountBetter(arr, n);
        System.out.println(ans);
    }
}
