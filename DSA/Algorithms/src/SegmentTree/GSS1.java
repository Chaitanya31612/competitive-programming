package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GSS1 {

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

    static class treeNode {
        int prefixSum;
        int suffixSum;
        int sum;
        int maxSum;
    }

    static int[] arr;
    static treeNode[] tree;

    public static void makeSegmentTree(int ss, int se, int index) {
        if(ss == se) {
            treeNode temp = new treeNode();
            temp.prefixSum = temp.suffixSum = temp.sum = temp.maxSum = arr[ss];
            tree[index] = temp;
            return;
        }
        int mid = (ss + se) / 2;
        makeSegmentTree(ss, mid, 2 * index + 1);
        makeSegmentTree(mid + 1, se, 2 * index + 2);

        treeNode left = tree[2 * index + 1];
        treeNode right = tree[2 * index + 2];

        tree[index] = new treeNode();
        tree[index].prefixSum = Math.max(left.prefixSum, left.sum + right.prefixSum);
        tree[index].suffixSum = Math.max(right.suffixSum, right.sum + left.suffixSum);
        tree[index].sum = left.sum + right.sum;
        tree[index].maxSum = Math.max(left.suffixSum + right.prefixSum, Math.max(left.maxSum, right.maxSum));
    }

    public static treeNode maxSumQuery(int ss, int se, int qs, int qe, int index) {
        // complete overlap
        if(ss >= qs && se <= qe) {
            return tree[index];
        }

        // no overlap
        if(qs > se || qe < ss) {
            treeNode temp = new treeNode();
            temp.prefixSum = temp.suffixSum = temp.sum = temp.maxSum = Integer.MIN_VALUE;
            return temp;
        }

        int mid = (ss + se) / 2;
        treeNode left = maxSumQuery(ss, mid, qs, qe, 2 * index + 1);
        treeNode right = maxSumQuery(mid + 1, se, qs, qe, 2 * index + 2);

        treeNode temp = new treeNode();
        temp.prefixSum = Math.max(left.prefixSum, left.sum + right.prefixSum);
        temp.suffixSum = Math.max(right.suffixSum, right.sum + left.suffixSum);
        temp.sum = left.sum + right.sum;
        temp.maxSum = Math.max(left.suffixSum + right.prefixSum, Math.max(left.maxSum, right.maxSum));

        return temp;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();

        arr = new int[n];
        tree = new treeNode[4 * n + 1];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        makeSegmentTree(0, n - 1, 0);

        int q = sc.nextInt();
        while(q-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            System.out.println(maxSumQuery(0, n - 1, x - 1, y - 1, 0).maxSum);
        }
    }
}
