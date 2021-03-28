package startersmarch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SVRT {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
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

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
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

    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int t = sc.nextInt();
        while(t-- > 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();

            // d
            long d;
            if(n%k == 0) {
                d = n / k;
            } else {
                d = (n + k - 1) / k;
            }

            // x
            long x;
            if(n%k == 0) {
                x = k;
            } else {
                x = n % k;
            }

            System.out.println(d + " " + x);
        }
    }
}
