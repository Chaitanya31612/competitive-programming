import java.util.*;
import java.lang.*;

public class AmbPermutations {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        while(n != 0) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int k = 1, j = 0;
            int[] ans = new int[n];
            while (k <= n && j < n) {
                if (a[j] == k) {
                    ans[k - 1] = j + 1;
                    k++;
                    j = 0;
                } else {
                    j++;
                }
            }
            
            if (Arrays.equals(a, ans)) {
                System.out.println("ambiguous");
            } else {
                System.out.println("not ambiguous");
            }
            n = sc.nextInt();
        };
    }
}
