import java.util.*;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        selection(A, n);
        System.out.println(Arrays.toString(A));
    }

    static void selection(int[] A, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i+1; j <= n - 1; j++) {
                if (A[j] < A[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = A[i];
            A[i] = A[min_idx];
            A[min_idx] = temp;
        }   
    }
}