package easy;

import java.io.*;
import java.util.StringTokenizer;

public class klargest {

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

    public static int sum(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        while(q-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int count = sum(arr);
            if(a == 1) {
                if(arr[b-1] == 1) count--;
                else count++;
                arr[b-1] = 1 - arr[b-1];
//                System.out.println(arr[b]);
            } else {
                if(b > count) {
//                    System.out.println(0);
                    output.write(0 + "\n");
                } else {
                    output.write(1 + "\n");
                }
//                int[] temp = arr;
//                Arrays.sort(temp);
//                System.out.println(temp[n-b]);
//                if(sum(arr) >= b) {
//                    System.out.println(1);
//                } else {
//                    System.out.println(0);
//                }
            }
        }
        output.flush();
    }
}
