import java.util.*;

public class College {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int s = sc.nextInt();
            int[] q = new int[s];
            for (int i = 0; i < s; i++) {
                q[i] = sc.nextInt();
            }
            long ans = 0;
            for (int i = 0; i < s; i++) {
                int e = sc.nextInt();
                int[] l = new int[e];
                int c = 0;
                while (c < e) {
                    l[c++] = sc.nextInt();
                }

                for (int j = 0; j < e; j++) {
                    if (j == 0) {
                        ans += l[0];                        
                    } else {
                        ans += l[j] - q[i];
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
