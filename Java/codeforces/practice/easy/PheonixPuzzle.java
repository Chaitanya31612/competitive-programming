package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PheonixPuzzle {

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

    public static boolean checkSquare(int n) {
        int rootn = (int) Math.sqrt(n);
        return rootn * rootn == n;
    }

    public static void solve(int n) {
        if(n % 2 == 0 && checkSquare(n / 2)) {
            System.out.println("YES");
        } else if(n % 4 == 0 && checkSquare(n / 4)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();

            solve(n);
        }
    }
}
