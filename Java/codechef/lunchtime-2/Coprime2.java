import java.util.*;

public class Coprime2 {
    static boolean checkPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            
            r = r + 1;
            while (!checkPrime(r)) {
                r = r + 1;
            }
            System.out.println(r);
        }
    }
}
