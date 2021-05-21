package SegmentTree;

import java.util.Scanner;

public class RangeMax {

    static int[] arr, BIT;

    public static void update(int i, int val, int n) {
        while(i <= n) {
            BIT[i] = Math.max(BIT[i], val);
            i += (i & (-i));
        }
    }

    // max till i
    public static int query(int i) {
        int ans = 0;
        while(i > 0) {
            ans = Math.max(BIT[i], ans);
            i -= (i & (-i));
        }

        return ans;
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

        int q = sc.nextInt();
        while(q-- > 0) {
            int ind = sc.nextInt();
            System.out.println(query(ind));
        }
    }
}
