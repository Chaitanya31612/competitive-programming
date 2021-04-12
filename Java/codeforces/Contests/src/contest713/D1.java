package contest713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class D1 {
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
        while(t-- > 0) {
            int n = sc.nextInt();
            long[] b = new long[n + 2];
            // sum of all elements
            long sum = 0;
            for (int i = 0; i < b.length; i++) {
                b[i] = sc.nextLong();
                sum += b[i];
            }

            Arrays.sort(b);
            int ind = -1;
            // iterate on each index and suppose it to be x
            for(int i = 0; i < n + 2; i++) {
                // element whose sum is equal to all elements can be second last or last
                long max = (i != n + 1)? b[n + 1] : b[n];
                // sum1 = total sum - x - one element from last two
                long sum1 = sum - b[i] - max;

                if(sum1 == max) {
                    ind = i;
                    break;
                }
            }

            if(ind == -1) {
                System.out.println(-1);
            } else {
                // now x is at index ind, so dont add it
                ArrayList<Long> list = new ArrayList<>();
                for(int i = 0; i < n + 2; i++) {
                    if(i != ind) {
                        list.add(b[i]);
                    }
                }

                // now sort the array and print n elements
                Collections.sort(list);
                for(int i = 0; i < n; i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();
            }

        }
    }
}
