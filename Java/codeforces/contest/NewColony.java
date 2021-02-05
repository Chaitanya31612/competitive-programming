import java.util.*;

public class NewColony {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] h = new int[n];

            for (int i = 0; i < n; i++) {
                h[i] = sc.nextInt();
            }

            int ans = 0;
            if (n == 1) {
                ans = -1;
            } else {
                int i = 0;
                while (k > 0) {
                    i = 0;
                    while (i < n-1) {
                        if (h[i] >= h[i + 1]) {
                            i++;
                        } else {
                            h[i] = h[i] + 1;
                            k--;
                            break;
                        }
                    }
                    if (i == n-1) {
                        ans = -1;
                        break;
                    }
                }

                if (ans != -1) {
                    ans = i+1;
                }
                
                System.out.println(ans);
            }
        
        }
    }
}
