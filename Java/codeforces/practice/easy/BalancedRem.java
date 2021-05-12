package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BalancedRem {
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

    static int[] c;
    static int steps = 0;

    public static int getMaxIndex() {
        int ind = -1, max = Integer.MIN_VALUE, check = c[0];
        for(int i = 0; i < c.length; i++) {
            if(check != c[i]) {
                check = -1;
            }
            if(c[i] > max) {
                max = c[i];
                ind = i;
            }
        }

        // check -1 means different
        if(check != -1) {
            return -1;
        }
        return ind;
    }

    public static void solve(int[] arr, int n) {
        while (true) {
            int maxIndex = getMaxIndex();

            if(maxIndex == -1){
                System.out.println(steps);
                steps = 0;
                return;
            }

            if(maxIndex == 2) {
                c[2]--;
                c[0]++;
            }
            else if(maxIndex == 1) {
                c[1]--;
                c[2]++;
            }
            else if(maxIndex == 0) {
                c[0]--;
                c[1]++;
            }
            steps++;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            c = new int[3];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                c[arr[i] % 3]++;
            }

            solve(arr, n);
        }
    }
}
