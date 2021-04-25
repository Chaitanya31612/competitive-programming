package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ColorFulArray {

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

    public static int getParent(int node, int[] parent) {
        if(node == parent[node]) {
            return node;
        }

        return parent[node] = getParent(parent[node], parent);
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int n = sc.nextInt();
        int q = sc.nextInt();

        ArrayList<ArrayList<Integer>> queries = new ArrayList<>();
        for(int i = 0; i < q; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            int l = sc.nextInt();
            int r = sc.nextInt();
            int c = sc.nextInt();
            temp.add(l);
            temp.add(r);
            temp.add(c);
            queries.add(0, temp);
        }

        int[] parent = new int[n + 2];
        for(int i = 0; i < n + 2; i++) {
            parent[i] = i;
        }

        int[] color = new int[n + 1];

//        System.out.println(queries);
        // move from bottom because bottom color will be final for a given range
        for(ArrayList<Integer> query : queries) {
            int l = query.get(0);
            int r = query.get(1);
            int c = query.get(2);

//            System.out.println(l + " " + r + " " + c);
            for(int j = getParent(l, parent); j <= r; j = getParent(j, parent)) {
                color[j] = c;
                parent[j] = getParent(j + 1, parent);
            }
        }

        for(int i = 1; i <= n; i++) {
            System.out.println(color[i]);
        }

    }
}
