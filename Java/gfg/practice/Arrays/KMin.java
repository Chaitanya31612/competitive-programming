import java.util.*;

public class KMin {
    static int min(int[] arr) {
        int min = arr[0];
        int indx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                indx = i;
            }
        }
        return indx;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int ans = 0;
        while (k-- > 0) {
            int m = min(arr);
            ans = arr[m];
            arr[m] = Integer.MAX_VALUE;
        }

        System.out.println(ans);
    }    
}
