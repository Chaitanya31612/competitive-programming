public class FastPower {

    static long fastPower(int a, int b, int n) {
        long res = 1;

        while(b > 0) {
            // check if b is odd, so make even by multiplying once by a
            // even is useful as we can say (a2)^b/2
            if((b&1) != 0) {
//                res = res * a;
                res = (res * a % n) % n;
            }

//            a = a * a;
            a = (a%n * a%n) % n;
//            b = b / 2;
            b = b >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fastPower(32838,25, 1000000007));
    }
}
