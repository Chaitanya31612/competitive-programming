import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SpaceArray2 {
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

    public static boolean checkArr(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            if(arr[i] > i+1) {
                return true;
            }
        }
        return false;
    }

    public static int diff(int[] arr) {
        int diff = 0;
        for(int i = 0; i < arr.length; i++) {
            diff += (i+1) - arr[i];
        }
        return diff;
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

            Arrays.sort(arr);
            if(checkArr(arr)) {
                // condn 3
                System.out.println("Second");
            } else {
                int d = diff(arr);
                if((d&1) == 1) {
                    System.out.println("First");
                } else {
                    System.out.println("Second");
                }
            }
        }
    }
}
