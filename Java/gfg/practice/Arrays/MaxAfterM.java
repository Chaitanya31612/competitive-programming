import java.util.*;

public class MaxAfterM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            
            while (m-- > 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int k = sc.nextInt();

                if (a <= b) {
                    for (int i = a; i <= b; i++) {
                        arr[i] += k;
                    }
                }
            }

            int max = arr[0];
            for (int j = 0; j < n; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }

            System.out.println(max);
        }
    }
}
