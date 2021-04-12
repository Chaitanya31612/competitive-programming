//package contest713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C1 {
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


    public static String solve(String str, int a, int b) {
        char[] s = str.toCharArray();
        int n = s.length;
        for(int i = 0; i < n; i++) {
            if(s[i] != '?' && s[n - i - 1] == '?') {
                s[n - i - 1] = s[i];
            }

        }

        int no_zeros = 0, no_ones = 0;
        for(int i = 0; i < n; i++) {
            no_zeros += (s[i] == '0') ? 1 : 0;
            no_ones += s[i] == '1' ? 1 : 0;
        }

        int zeros = a - no_zeros;
        int ones = b - no_ones;
        int rem_ind = -1;
        for(int i = 0; i < n; i++) {
            if(s[i] == '?' && s[n - i - 1] == '?') {
                if(ones >= 2) {
                    s[i] = s[n - i - 1] = '1';
                    ones -= 2;
                } else if(zeros >= 2) {
                    s[i] = s[n - i - 1] = '0';
                    zeros -= 2;
                } else {
                   rem_ind = i;
                   break;
                }
            }
        }

        if(ones > 0 && zeros > 0) {
            return "-1";
        }
        if(rem_ind != -1) {
            if(ones > 0)
                s[rem_ind] = '1';
            else if(zeros > 0)
                s[rem_ind] = '0';
            else
                return "-1";
        }

        no_ones = 0;
        no_zeros = 0;
        for(int i = 0; i < n; i++) {
            no_zeros += (s[i] == '0') ? 1 : 0;
            no_ones += s[i] == '1' ? 1 : 0;

            if(s[i] != s[n - i - 1]) {
                return "-1";
            }
        }

        if(no_ones != b || no_zeros != a) {
            return "-1";
        }

        return String.valueOf(s);

    }


    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();

        while(t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            String str = sc.nextLine();

            System.out.println(solve(str, a, b));


        }
    }
}
