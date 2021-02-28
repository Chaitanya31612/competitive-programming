import java.util.*;

public class Daanish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = 10;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            for (int i = n - 1; i >= 0; i--) {
                if (k >= arr[i]) {
                    k = k - arr[i];
                } else {
                    System.out.println(i + 1);
                    break;
                }
            }
        }
    }
}
