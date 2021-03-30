package contest711;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class A {

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        public String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() { return Integer.parseInt(next()); }

        public long nextLong() { return Long.parseLong(next()); }

        public double nextDouble()
        {
            return Double.parseDouble(next());
        }

        public String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    private static int gcd(int reduceNum, int b)
    {
        return b == 0 ?
                reduceNum : gcd(b, reduceNum % b);
    }

    // Here 'a' is integer and 'b'
    // is string. The idea is to make
    // the second number (represented
    // as b) less than and equal to
    // first number by calculating its
    // modulus with first integer
    // number using basic mathematics
    private static int reduceB(int a, String b)
    {
        int result = 0;
        for (int i = 0; i < b.length(); i++)
        {
            result = (result * 10 +
                    b.charAt(i) - '0') % a;
        }
        return result;
    }

    private static int gcdLarge(int a, String b)
    {
        // Reduce 'b' i.e the second
        // number after modulo with a
        int num = reduceB(a, b);

        // Now,use the euclid's algorithm
        // to find the gcd of the 2 numbers
        return gcd(num, a);
    }

    public static int sum(String str) {
        int sum = 0;
        for(int i = 0; i < str.length(); i++) {
            sum += Integer.parseInt(str.substring(i, i+1));
        }
        return sum;
    }

    // Driver code
    public static void main(String[] args)
    {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-- > 0) {
            String b = sc.nextLine();

            int a = sum(b);
//            System.out.println(a);

            int gcd = gcdLarge(a, b);

            if(gcd > 1) {
                System.out.println(b);
            } else {
                BigInteger big = new BigInteger(b);
                while(gcd <= 1) {
                    big = big.add(BigInteger.valueOf(1));
                    int sumdig = sum(big.toString());
                    gcd = gcdLarge(sumdig, big.toString());
                }
                System.out.println(big);
            }
        }
    }
}
