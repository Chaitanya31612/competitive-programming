import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = sc.nextInt();
        bubbleSort(A);
        System.out.println(Arrays.toString(A));
    }

    static void bubbleSort(int[] A) {
        for (int i = 1; i <=A.length-1; i++) {
            for (int j = 0; j <=(A.length-i-1); j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
    }
}