import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InterestingXOR2 {
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
//            int d = (int)Math.ceil(Math.log(c) / Math.log(2));
//            System.out.println(Integer.toBinaryString(c));
            String str = Long.toBinaryString(c);
            String a = "";
            for(int i = str.length()-1; i > 0; i--) {
                if(str.charAt(i) == '1' || str.charAt(i) == '0') {
                    a = "1" + a;
                }
            }
            if(str.charAt(0) == '1') {
                a = "0" + a;
            }

            long aInt = Integer.parseInt(a, 2);
            long b = aInt ^ c;
//            System.out.println("a = " + a);
//            System.out.println("b = " + b);

            System.out.println(aInt*b);
        }
    }
}
