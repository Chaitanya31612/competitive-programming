package Mathematics;

public class GCD {

    public int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public int lcm(int a, int b) {
        // gcd * lcm = product of numbers
        return (a * b) / gcd(a, b);
    }

    // extended euclidean method used to solve equations of the for ax + by = gcd(a, b)
    static int x, y, gcd;
    public void extendedEuclidMethod(int a, int b) {
        if(b == 0) {
            x = 1;
            y = 0;
            gcd = a;
            return;
        }

        extendedEuclidMethod(b, a % b);
        int cx = y;
        int cy = x - (a / b) * y;

        x = cx;
        y = cy;
    }

    public int MulModInverse(int a, int m) {
        extendedEuclidMethod(a, m);
        if(gcd != 1) {
            return -1;
        }
        return (x + m) % m;
    }


    public static void main(String[] args) {
//        System.out.println(gcd(10, 14));
//        System.out.println(gcd(14, 10));
//        System.out.println(lcm(10, 14));

        GCD g = new GCD();

        // 18x + 30y = 6
        g.extendedEuclidMethod(18, 30);
        System.out.println(x + ", " + y);

        System.out.println(g.MulModInverse(6, 7));
    }

}
