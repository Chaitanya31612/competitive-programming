package longchallengejune;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHEFHEIST {

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

    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int t = sc.nextInt();

        while(t-- > 0) {
            int D = sc.nextInt();
            int d = sc.nextInt();
            int P = sc.nextInt();
            int Q = sc.nextInt();

            int sum = 0, q = 0;

            while(D > 0) {
                if(D <= d) {
                    sum += D * (P + q);
                    break;
                }
                else {
                    D -= d;
                    sum += (P + q) * d;
                    q += Q;
                }
            }

            System.out.println(sum);
        }
    }
}
