//package virtual702;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
    public static int makeDense(List<Integer> list) {
        int count = 0, i = 0;
        while(i < list.size() - 1) {
            int max = Math.max(list.get(i), list.get(i+1));
            int min = Math.min(list.get(i), list.get(i+1));

            if(max > 2 * min) {
                list.add(i+1, 2 * min);
                count++;
                i = 0;
            } else {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }

            System.out.println(makeDense(list));
        }
    }
}
