package cookoffmarch;

import java.io.*;
import java.util.StringTokenizer;

public class MatrixXor2 {
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

            if(n == 1 || m == 1) {
                for(int i = 1; i <= n; i++) {
                    for(int j = 1; j <= m; j++) {
                        ans = ans^(k + i + j);
                    }
                }
            } else if(n == 2 || m == 2) {
                ans = (k+2) ^ (k + n + m);
            } else {
                for(int i = m; i > 2; i--) {
                    int count = Math.min(i, n);




                    if((count&1) == 1) {
                        ans = ans ^ (k + i + 2);
                    }
                }

                for(int i = n-2; i > 2; i--) {
                    int d = (i+m) - n;
                    int count = Math.min(m, d);
                    if((count&1) == 1) {
                        ans = ans ^ (k + i + m);
                    }
                }
            }


            output.write(ans + "\n");

        }
        output.flush();
    }
}
