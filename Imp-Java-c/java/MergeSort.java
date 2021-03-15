import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        mergeSort(A, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.println(A[i]);
        }
    }

    static void mergeSort(int[] A, int s, int e) {
        if (s >= e) {
            return;
        }

        int mid = (s + e) / 2;
        mergeSort(A, s, mid);
        mergeSort(A, mid + 1, e);

        merge(A, s, e);
    }

    static void merge(int[] A, int s, int e) {
        int mid = (s + e) / 2;

        int i = s;
        int j = mid + 1;
        int k = s;

        int[] temp = new int[100];
        while (i <= mid && j <= e) {
            if (A[i] < A[j]) {
                temp[k++] = A[i++];
            } else {
                temp[k++] = A[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = A[i++];
        }
        while (j <= e) {
            temp[k++] = A[j++];
        }

        for (int a = s; a <= e; a++) {
            A[a] = temp[a];
        }
    }
}