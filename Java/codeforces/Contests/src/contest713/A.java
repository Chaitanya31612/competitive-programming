package contest713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class A {

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

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                if(!map.containsKey(arr[i])) {
                    map.put(arr[i], 1);
                } else {
                    map.put(arr[i], map.get(arr[i]) + 1);
                }
            }

            int key = 0;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getValue() == 1) {
                    key = entry.getKey();
                    break;
                }
            }

            for(int i = 0; i < n; i++) {
                if(arr[i] == key) {
                    System.out.println(i + 1);
                    break;
                }
            }
        }
    }
}
