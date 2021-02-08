import java.util.*;

public class GreatHero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int n = sc.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            boolean ans = false;
            int f, c = 0;
            for (; c < n; c++) {
                if (B > 0) {
                    if (b[c] % A == 0) {
                        f = b[c] / A;
                    } else {
                        f = b[c] / A + 1;
                    }

                    int count = 0;
                    while (B > 0 && count < f) {
                        B = B - a[c];
                        count++;
                    }

                    // System.out.println(count + " " + f + " " + B);

                    if(count == f && (c+1 == n)) {
                        ans = true;
                    }
                } else {
                    ans = false;
                    break;
                }
            }

            
            if (ans) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }    
}
