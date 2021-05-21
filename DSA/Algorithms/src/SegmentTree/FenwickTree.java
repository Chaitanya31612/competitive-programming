package SegmentTree;

import java.util.Scanner;

public class FenwickTree {

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
        Scanner sc = new Scanner(System.in);

        // number of elements of array
        int n = sc.nextInt();

        // in fenwick tree array is indexed from 1
        arr = new int[n + 1];
        BIT = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            update(i, arr[i], n);
        }

        // queries
        int q = sc.nextInt();
        while(q-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            System.out.println(query(r) - query(l - 1));
        }
    }
}
