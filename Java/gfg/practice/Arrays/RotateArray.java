import java.util.*;

public class RotateArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int d = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            for (int j = d; j < n; j++) {
                System.out.print(arr[j] + " ");
            }
            for (int k = 0; k < d; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }
    }
}
