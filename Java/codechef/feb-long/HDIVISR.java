import java.util.*;

public class HDIVISR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ans = 1;
        for (int i = 10; i > 0; i--) {
            if (n % i == 0) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }
}