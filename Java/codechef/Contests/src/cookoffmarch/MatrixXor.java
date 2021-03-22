package cookoffmarch;

import java.io.*;
import java.util.StringTokenizer;

public class MatrixXor {
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

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            long k = sc.nextLong();

            long ans = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    ans = ans^(k + i + j + 2);
                }
            }
            output.write(ans + "\n");

        }
        output.flush();
    }
}
