import java.util.*;

public class TotalScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] A = new int[k];
            for (int i = 0; i < k; i++) {
                A[i] = sc.nextInt();
            }
            // int[] ans = new int[n];
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                String S = sc.nextLine();
                long total = 0;
                for (int j = 0; j < S.length(); j++) {
                    char s = S.charAt(j);
                    // int c = Character.getNumericValue(s);
                    if (s == '1') {
                        // ans[i] += A[j];
                        total += A[j];
                    }
                }
                System.out.println(total);
                // System.out.println(ans[i]);
            }
            // System.out.println(Arrays.toString(ans));
            // for (int i = 0; i < n; i++) {
            //     System.out.println(ans[i]);
            // }
        }    
    }
}
