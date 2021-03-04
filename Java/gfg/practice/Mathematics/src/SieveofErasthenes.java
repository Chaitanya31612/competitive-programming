import java.util.Arrays;

public class SieveofErasthenes {

    static void print(boolean arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void sieveoferasthenes(int n){
        boolean[] isPrime = new boolean[n+1];

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i*i <= n; i++) {
            for(int j = 2*i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
        print(isPrime);
    }

    public static void main(String[] args) {

        sieveoferasthenes(12);
    }
}
