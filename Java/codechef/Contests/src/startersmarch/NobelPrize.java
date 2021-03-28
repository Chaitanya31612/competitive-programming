package startersmarch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NobelPrize {

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

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();

        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            int[] aux = new int[m + 1];
            aux[0] = -1;

            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                aux[arr[i]]++;
            }

            boolean found = false;
            for(int i = 1; i <= m; i++) {
                if(aux[i] == 0) {
                    found = true;
                    break;
                }
            }

            if(found) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}
