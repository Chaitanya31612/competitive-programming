import java.util.*;

public class ChefTwoTen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            long x = sc.nextLong();

            int ans = 0;
            if (x % 10 == 0) {
                ans = 0;
            } else if (x % 5 == 0) {
                ans = 1;
            } else {
                ans = -1;
            }

            System.out.println(ans);
        }
    }
}
