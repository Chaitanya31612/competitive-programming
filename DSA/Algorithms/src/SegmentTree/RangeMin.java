package SegmentTree;

import java.util.Scanner;

public class RangeMin {

    /* Segment tree with lazy propagation - for updating range */
    public static void updateRangeLazy(int[] tree, int[] lazy, int ss, int se, int l, int r, int inc, int index) {
        // Never go down if there is lazy value on a node - first resolve it
        if(lazy[index] != 0) {
            tree[index] += inc;

            // if not leaf node - then add lazy value to children
            if(ss != se) {
                lazy[2 * index] += lazy[index];
                lazy[2 * index + 1] += lazy[index];
            }
            // set lazy value to zero as it has been resolved
            lazy[index] = 0;
        }

        // out of bound - no overlap
        if(ss > r || se < l) {
            return;
        }

        // complete overlap
        if(ss >= l && se <= r) {
            tree[index] += inc;

            // pass lazy value to the children
            // if reached here then the current index will not have any lazy value
            if(ss != se) {
                lazy[2 * index] += inc;
                lazy[2 * index + 1] += inc;
            }
            return;
        }

        // partial overlap - call on left and right
        int mid = (ss + se) / 2;
        updateRangeLazy(tree, lazy, ss, mid, l, r, inc, 2 * index);
        updateRangeLazy(tree, lazy, mid + 1, se, l, r, inc, 2 * index + 1);

        tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);
    }



    /* Update range - O(n) - in worst case update all nodes */
    public static void updateRange(int[] tree, int ss, int se, int l, int r, int inc, int index) {
        // No overlap
        if(l > se || r < ss) {
            return;
        }

        // found leaf node
        if(ss == se) {
            tree[index] += inc;
            return;
        }

        // there will be no complete overlap case because we want to update the leaf

        // call to left and right
        int mid = (ss + se) / 2;
        updateRange(tree, ss, mid, l, r, inc, 2 * index);
        updateRange(tree, mid + 1, se, l, r, inc, 2 * index + 1);

        tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);
    }



    /* Update */
    /*
    * ss - start
    * se - end
    * i - node to update */
    public static void updateNode(int[] tree, int ss, int se, int i, int increment, int index) {
        // We need to update leaf node

        // out of bounds - No overlap
        if(i > se || i < ss) {
            return;
        }

        // Found leaf node
        if(ss == se) {
            tree[index] += increment;
            return;
        }

        // Call left and right
        int mid = (ss + se) / 2;
        updateNode(tree, ss, mid, i, increment, 2 * index);
        updateNode(tree, mid + 1, se, i, increment, 2 * index + 1);

        // update while coming back
        tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);
    }



    /* Lazy propagation query */
    public static int queryLazy(int[] tree, int[] lazy, int ss, int se, int qs, int qe, int index) {
        // Never go down if there is lazy value on a node - first resolve it
        if(lazy[index] != 0) {
            tree[index] += lazy[index];

            // if not leaf node - then add lazy value to children
            if(ss != se) {
                lazy[2 * index] += lazy[index];
                lazy[2 * index + 1] += lazy[index];
            }
            // set lazy value to zero as it has been resolved
            lazy[index] = 0;
        }

        // out of bound - no overlap
        if(ss > qe || se < qs) {
            return Integer.MAX_VALUE;
        }

        // complete overlap
        if(ss >= qs && se <= qe) {
            return tree[index];
        }

        // partial overlap - call on left and right
        int mid = (ss + se) / 2;
        int left = queryLazy(tree, lazy, ss, mid, qs, qe, 2 * index);
        int right = queryLazy(tree, lazy, mid + 1, se, qs, qe, 2 * index + 1);

        return Math.min(left, right);
    }

    /* Query - time O(logn)
    as it is a height balanced tree because we created it after getting input */
    public static int query(int[] tree, int ss, int se, int qs, int qe, int index) {
        // Complete Overlap
        // qs ------- qe           qs ------- qe
        //   ss --- se             ss ------- se
        if (ss >= qs && se <= qe) {
            return tree[index];
        }

        // No overlap
        // qs ------- qe           qs ------- qe
        //               ss --- se
        if(qe < ss || qs > se) {
            return Integer.MAX_VALUE;
        }

        // Partial overlap - call on both sides
        // qs ------- qe           qs ------- qe
        //               qs --- qe
        //           ss ----------- se
        int mid = (ss + se) / 2;
        int leftAns = query(tree, ss, mid, qs, qe, 2 * index);
        int rightAns = query(tree, mid + 1, se, qs, qe, 2 * index + 1);

        return Math.min(leftAns, rightAns);
    }


    /* build tree */
    public static void buildTree(int[] arr, int s, int e, int[] tree, int index) {
        // base case
        if(s == e) {
            tree[index] = arr[s];
            return;
        }

        int mid = (s + e) / 2;

        // build left segment tree
        buildTree(arr, s, mid, tree, 2 * index);

        // build right segment tree
        buildTree(arr, mid + 1, e, tree, 2 * index + 1);

        // find min from left and right and update tree[index]
        tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // in worst case the size of the tree array can be 4n + 1
        int[] tree = new int[4 * n + 1];

        buildTree(arr, 0, n - 1, tree, 1);

//        System.out.println(Arrays.toString(tree));

//        updateNode(tree, 0, n - 1, 2, 10, 1);
//        updateNode(tree, 0, n - 1, 3, 15, 1);
        // arr = [1 3 12 10 6 4]


//        updateRange(tree, 0, n - 1, 2, 3, 10, 1);
        int[] lazy = new int[tree.length];
        updateRangeLazy(tree, lazy, 0, n - 1, 2, 3, 10, 1);

        int numQuery = sc.nextInt();
        while(numQuery-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(query(tree, 0, n - 1, l, r, 1));
        }



    }


}


/* Sample input
6
1 3 2 -5 6 4
6
0 0
1 1
2 2
3 3
4 4
5 5

output
-5, 1, -5, 1, 2, -5, 4, 1, 3, 0, 0, -5, 6
// this output is for updateRange
1
3
12
5
6
4
* */