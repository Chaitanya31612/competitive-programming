package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class InversionCount {

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

    static int[] arr;
    static int[] BIT;

    public static void update(int i, int inc, int n) {
        while(i <= n) {
            BIT[i] += inc;
            // updating i to next index which includes i
            i += (i & (-i));
        }
    }

    // return ans for query i, i.e sum till ith index
    public static int query(int i) {
        int sum = 0;
        while(i > 0) {
            sum += BIT[i];
            i -= (i & (-i));
        }
        return sum;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int t = sc.nextInt();

        while(t-- > 0) {

            // number of elements of array
            int n = sc.nextInt();

            // in fenwick tree array is indexed from 1
            arr = new int[n + 1];
            BIT = new int[n + 1];

            // coordinate compression - map elements relatively in the array such that all elements <= N
            TreeSet<Integer> set = new TreeSet<>();
            HashMap<Integer, Integer> map = new HashMap<>();

            for(int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
                set.add(arr[i]);
            }

            int idx = 1;
            for(int ele : set) {
                if(!map.containsKey(ele)) {
                    map.put(ele, idx);
                    idx++;
                }
            }

            // map old array to compressed array
            for(int i = 1; i <= n; i++) {
                arr[i] = map.get(arr[i]);
            }
//        System.out.println(Arrays.toString(arr));

            // Inversion Count
            int ans = 0;
            for(int i = n; i >= 1; i--) {
                ans += query(arr[i] - 1);
                update(arr[i], 1, n);
            }

            System.out.println(ans);

        }

    }
}

/* Sample Input
5
5 2 1 4 3
output = 6

5
100 70 50 90 80
mapped to ==> 5 2 1 4 3
output = 6
* */