import java.util.*;

public class Smallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int ans = 0;
            if (k == 0) {
                ans = n;
            } else {
                ans = n % k;
            }
            System.out.println(ans);
        } 
    }
}