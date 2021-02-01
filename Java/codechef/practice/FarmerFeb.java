import java.util.*;

public class FarmerFeb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            System.out.println(solve(x, y));
        }
    }

    static int solve(int x, int y) {
        for (int sum = x + y + 1;; sum++) {
            if (isPrime(sum)) {
                return sum - x - y;
            }
        }
    }
    
    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
