package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NastiaNGoodNum {
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
            long a = sc.nextLong();
            long b = sc.nextLong();

            long ab = a * b;

            int i = 2;
            while(true) {
                if(b == 1) {
                    System.out.println("NO");
                    break;
                }
                long diff = ab - a;
                if(diff <= a) {
                    ab *= i;
                    i++;
                    continue;
                }

                System.out.println("YES");
                System.out.println(a + " " + diff + " " + ab);
                break;
            }
        }
    }
}
