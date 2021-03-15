import java.util.*;
import java.lang.*;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = sc.nextInt();

        insertionSort(A);
        System.out.println(Arrays.toString(A));
    }
    
    static void insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int e = A[i];
            
            int j = i - 1;
            while (j >= 0 && A[j] > e) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = e;
        }
    }
}