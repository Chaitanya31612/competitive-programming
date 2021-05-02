package MatrixExponentiation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SEQ {

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

    static int MOD = (int)Math.pow(10, 9);
    static long k;
    static long[] b, c;

    public static long[][] multiply(long[][] A, long[][] B) {

        long[][] C = new long[(int)(k + 1)][(int)(k + 1)];

        for(int i = 1; i <= k; i++) {
            for(int j = 1; j <= k; j++) {
                for(int x = 1; x <= k; x++) {
                    C[i][j] = (C[i][j] + (A[i][x]*B[x][j]) % MOD) % MOD;
                }
            }
        }

        return C;
    }

    public static long[][] pow(long[][] A, long p) {
        // base case
        if(p == 1){
            return A;
        }

        // Recursive case
        // p is odd
        if((p & 1) == 1) {
            return multiply(A, pow(A, p - 1));
        } else {
            long[][] X = pow(A, p / 2);
            return multiply(X, X);
        }

    }


    public static long compute(long n) {
        // base case
        if(n == 0) {
            return 0;
        }

        // if asked from given array only
        if(n <= k) {
            return b[(int)(n - 1)];
        }

        // 1. use matrix exponentiation, create F1 vector with 1 indexing
        long[] F1 = new long[(int)k + 1];
        for(int i = 1; i <= k; i++) {
            F1[i] = b[i - 1];
        }

        // 2. transformation matrix
        long[][] T = new long[(int)(k + 1)][(int)(k + 1)];

        for(int i = 1; i <= k; i++) {
            for(int j = 1; j <= k; j++) {
                // not in last row
                if(i < k) {
                    // index next to diagonal
                    if(j == i + 1) {
                        T[i][j] = 1;
                    } else {
                        T[i][j] = 0;
                    }
                    continue;
                }

                // last row - to be filled with coefficients in reverse order
                T[i][j] = c[(int)(k - j)];
            }
        }

        // 3. find T^n-1
        T = pow(T, n - 1);

        // 4. multiply T^n-1 with F1 and retrieve the first value
        long ans = 0;
        for(int i = 1; i <= k; i++) {
            ans = (ans + (T[1][i] * F1[i]) % MOD) % MOD;
        }

        return ans;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();

        long t = sc.nextInt();
        while(t-- > 0) {
            k = sc.nextLong();

            // Initialize F1 vector
            b = new long[(int)k + 1];
            for(int i = 0; i < k; i++) {
                b[i] = sc.nextLong();
            }

            // Coefficients vector
            c = new long[(int)k + 1];
            for(int i = 0; i < k; i++) {
                c[i] = sc.nextLong();
            }

            long n = sc.nextLong();

            System.out.println(compute(n));

        }
    }
}
