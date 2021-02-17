import java.util.*;

class Solution {
    public int[] polyMultiply(int[] A, int[] B, int m, int n) {

        int[] prod = new int[m + n - 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prod[i + j] += A[i] * B[j];
            }
        }

        return prod;
    }
}

public class MulPoly {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] A = new int[m];
        int[] B = new int[n];

        for (int i = 0; i < m; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }

        Solution s = new Solution();
        int[] prod = s.polyMultiply(A, B, m, n);
        for (int i = 0; i < prod.length; i++) {
            System.out.print(prod[i] + " ");
        }
    }
}
