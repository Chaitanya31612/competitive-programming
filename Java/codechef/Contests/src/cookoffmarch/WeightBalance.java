package cookoffmarch;

import java.io.*;
import java.util.StringTokenizer;

public class WeightBalance {public static class FastReader {
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

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = sc.nextInt();
        while(t-- > 0) {
            int w1 = sc.nextInt();
            int w2 = sc.nextInt();
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            int M = sc.nextInt();

            int computed = Math.abs(w2 - w1);

            if((x1 * M) <= computed && (x2 * M) >= computed) {
                output.write(1 + "\n");
            } else {
                output.write(0 + "\n");
            }
        }
        output.flush();
    }
}
