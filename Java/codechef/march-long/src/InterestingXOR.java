import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InterestingXOR {
    static class FastReader {
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
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-- > 0) {
            long c = sc.nextLong();
            int d = (int)Math.ceil(Math.log(c) / Math.log(2));
            long max = Long.MIN_VALUE;
            for(long i = (long)Math.pow(2,d) - 1; i >= c/2; i--) {
                long b = i ^ c;
                long prod = i * b;
                if(prod > max) {
                    max = prod;
                }
            }
            System.out.println(max);

//            int[] anum = new int[(int)Math.pow(2, d) + 1];
//            int n = anum.length;
//            for(int i = 0; i < n; i++) {
//                anum[i] = i;
//            }
//
//            int max = Integer.MIN_VALUE;
//            for(int i=0;i<n;i++)
//            {
//                for(int j=i;j<n;j++)
//                {
//                    int k=anum[i]^anum[j];
//                    if(k==c)
//                    {
//                        max = Math.max(max, (anum[i]*anum[j]));
//                    }
//                }
//            }
//
//            System.out.println(max);

        }
    }
}
