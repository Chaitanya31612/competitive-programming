package startersmarch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CLGLF5 {
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
            int n = sc.nextInt();
            int m = sc.nextInt();

            long[] F = new long[n];
            long[] C = new long[m];

            for(int i = 0; i < n; i++) {
                F[i] = sc.nextLong();
            }

            for(int i = 0; i < m; i++) {
                C[i] = sc.nextLong();
            }

            String onChannel = "F";
            int f = 0, c = 0;
            int ans = 0;

            while(f < n && c < m) {
                if(F[f] < C[c]) {
                    if(onChannel != "F") {
                        ans++;
                        onChannel = "F";
                    }
                    f++;
                } else if (C[c] < F[f]) {
                    if(onChannel != "C") {
                        onChannel = "C";
                        ans++;
                    }
                    c++;
                }
            }

            if(f < n && onChannel != "F") {
                onChannel = "F";
                ans++;
            }

            if(c < m && onChannel != "C") {
                onChannel = "C";
                ans++;
            }

            System.out.println(ans);
        }
    }
}
