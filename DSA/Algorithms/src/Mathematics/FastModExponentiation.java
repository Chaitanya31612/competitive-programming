package Mathematics;

public class FastModExponentiation {

    public static long fastModExponentiation(long a, long b, long m) {
        long res = 1;
        while(b > 0) {
            if((b&1) == 1) {
                res = (res * a) % m;
            }
            a = (a * a) % m;
            b = b>>1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(fastModExponentiation(5, 3, 100));
    }
}
