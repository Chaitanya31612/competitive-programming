//package contest712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    // ababa
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
    public static boolean checkPalindrome(String str) {

        for(int i = 0; i <= str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int t = sc.nextInt();
        while(t-- > 0) {
            String str = sc.nextLine();

            boolean allA = true;
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) != 'a') {
                    allA = false;
                }
            }

            if(allA) {
                System.out.println("NO");
            } else {
                String s1 = "a" + str;
                String s2 = str + "a";

                System.out.println("YES");
                if(!checkPalindrome(s1)) {
                    System.out.println(s1);
                } else {
                    System.out.println(s2);
                }
            }
        }
    }
}
