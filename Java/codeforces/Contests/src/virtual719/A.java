package virtual719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class A {

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

    static final String YES = "YES";
    static final String NO = "NO";

    public static String solve(int n, String str) {
        if(n <= 2)
            return YES;

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i + 1);
            if(!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                String prev = str.substring(i - 1, i);
                if(!s.equals(prev)) {
                    return NO;
                }
            }
        }

        return YES;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            String str = sc.nextLine();

            System.out.println(solve(n, str));
        }
    }
}
