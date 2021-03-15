package contest1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2 {
    public static class FastReader {
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

    public static int[] max(int[] arr, int ind) {
        int[] a = new int[2];
        int max = Integer.MIN_VALUE, indx = -1;
        int i = 0;
        while(i < arr.length) {
            if(arr[i] > max && i != ind && arr[i] != 0) {
                max = arr[i];
                indx = i;
            }
            i++;
        }

        a[0] = max;
        a[1] = indx;
        return a;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int[] ans = new int[n];

            int maxval = 0, ind = -1, c = 0;
            while(c < n) {
                int[] maxfun = max(arr, ind);
                maxval = maxfun[0];
                ind = maxfun[1];
                if(ind > 0) {
                    c = ind+1;
                } else {
                    c++;
                }

                int indx = ind;
                while(indx >= 0 && maxval-- > 0) {
                    ans[indx--] = 1;
                }
            }

            for(int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
