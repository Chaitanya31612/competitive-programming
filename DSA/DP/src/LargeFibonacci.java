import java.util.HashMap;
import java.util.Scanner;

public class LargeFibonacci {

    static HashMap<Long, Long> F;
    static int mod = (int)1e9 + 7;

    /* Fibonacci can be done in logn time using matrix exponentiation but it's code is large */

    // This method - time - O(logn + log(logn)))

    // this methods we break the fibonacci sequence in to logarithmic decreasing fashion
    //n even -  f(2*k) =  (f(k)*f(k) + f(k-1)*f(k-1))
    // n odd -  f(2*k + 1) =  (f(k)*f(k+1) + f(k-1)*f(k))
    public long f(long n) {
        if(F.containsKey(n)) {
            return F.get(n);
        }

        long k=n/2;
        long ans;
        if (n%2==0) { // n=2*k
            ans = (f(k) * f(k) + f(k - 1) * f(k - 1)) % mod;
        } else { // n=2*k+1
            ans = (f(k) * f(k + 1) + f(k - 1) * f(k)) % mod;
        }
        F.put(n, ans);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        F = new HashMap<>();
        F.put(0L, 1L);
        F.put(1L, 1L);

        LargeFibonacci l = new LargeFibonacci();

        long ans = n == 0 ? 0 : l.f(n - 1);
        System.out.println(ans);

//        0 1 1 2 3 5 8 13 ... -> fibonacci values
//        0 1 2 3 4 5 6 7 -> indexing
    }
}

