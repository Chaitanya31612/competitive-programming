//package contest711;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2 {
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
        while (t-- > 0) {
            long n = sc.nextInt();
            long w = sc.nextLong();
//            int[] arr = new int[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
//                arr[i] = sc.nextInt();
                sum += sc.nextLong();
            }

            if((sum % w) == 0) {
                System.out.println(sum/w);
            } else {
                System.out.println(sum/w + 1);
            }
        }
    }
}
