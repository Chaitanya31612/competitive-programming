import java.util.*;
import java.lang.*;
import java.io.*;

public class Mvalue {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            long[] neg = new long[n];
            int k = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                if (a[i] < 0) {
                    neg[k++] = a[i];
                }
            }
            Arrays.sort(a);
            Arrays.sort(neg);
            System.out.println(Arrays.toString(neg));

            long max = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
            max = a[n - 1] * a[n - 2] + (a[n - 1] - a[n - 2]);
            if (neg.length >= 2) {
                max2 = a[0] * a[1] + (a[1] - a[0]);
            }
            if (max > max2) {
                System.out.println(max);
            } else {
                System.out.println(max2);
            }

            // long first = a[n - 1], max = Integer.MIN_VALUE;
            // for (int i = n - 2; i >= 0; i--) {
            //     long exp = first * a[i] + first - a[i];
            //     if (exp > max) {
            //         max = exp;
            //     }
            // }
            // long second = neg[0];
            // for (int i = 1; i < n; i++) {
            //     long exp = second * a[i] + second - a[i];
            //     if (exp > max) {
            //         max = exp;
            //     }
            // }

            // // max = first * a[n-2] + (first - a[n-2]);
            // System.out.println(max);
        }
    }    
}
