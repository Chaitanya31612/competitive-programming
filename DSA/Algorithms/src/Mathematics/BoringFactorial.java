package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BoringFactorial {
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

    public long fastModExponentiation(long a, long b, long m) {
        long res = 1;
        while(b > 0) {
            if((b & 1) == 1) {
                res = (res * a) % m;
            }
            a = (a * a) % m;
            b = b >> 1;
        }
        return res;
    }

    public long solve(long n, long p) {
        long ans = -1;
        for(long i = (n + 1); i <= (p - 1); i++) {
            long temp = fastModExponentiation(i, p - 2, p);
            ans = (ans * temp) % p;
        }

        // to make ans positive
        return ans + p;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        long t = sc.nextLong();
        while(t-- > 0) {
            long n = sc.nextLong();
            long p = sc.nextLong();

            if(n >= p) {
                System.out.println(0);
            } else {
                BoringFactorial b = new BoringFactorial();
                System.out.println(b.solve(n, p));
            }

        }
    }
}
