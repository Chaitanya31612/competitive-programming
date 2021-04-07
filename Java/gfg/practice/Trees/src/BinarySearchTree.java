import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearchTree {

    private BinaryTreeNode<Integer> root;

    /* Time complexity of insertion, searching, deletion is O(height) */

    /* takeInput */
    public BinaryTreeNode<Integer> takeInputBST() {
        Scanner sc = new Scanner(System.in);

        root = null;
        int x = sc.nextInt();
        while (x != -1) {
            root = insertDataHelper(root, x);
            x = sc.nextInt();
        }

        return root;
    }

    /* print */
    public static void printTree(BinaryTreeNode<Integer> root) {
        // base case
        if (root == null) {
            return;
        }

        String toBePrinted = root.data + ": ";
        if (root.left != null) {
            toBePrinted += "L:" + root.left.data + ",";
        }
        if (root.right != null) {
            toBePrinted += "R:" + root.right.data;
        }
        System.out.println(toBePrinted);

        printTree(root.left);
        printTree(root.right);
    }

    public void print() {
        printTree(root);
    }


    public static void printRange(BinaryTreeNode<Integer> root, int l, int r) {
        if (root == null) {
            return;
        }

        if (root.data > r) {
            // only left

            printRange(root.left, l, r);

        } else if (root.data < l) {
            // right only
            printRange(root.right, l, r);
        } else {
            // both
            if (root.data >= l && root.data <= r) {
                System.out.println(root.data);
            }
            printRange(root.left, l, r);
            printRange(root.right, l, r);
        }

    }

    /* insertion */
    private BinaryTreeNode<Integer> insertDataHelper(BinaryTreeNode<Integer> root, int data) {
        if (root == null) {
            BinaryTreeNode<Integer> node = new BinaryTreeNode<>(data);
            root = node;
            return root;
        }

        if (data > root.data) {
            // right
            root.right = insertDataHelper(root.right, data);
        } else {
            // left
            root.left = insertDataHelper(root.left, data);
        }
        return root;
    }

    public void insertData(int data) {
        root = insertDataHelper(root, data);
    }


    /* deletion */
    public int minimum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
    }

    private BinaryTreeNode<Integer> deleteDataHelper(BinaryTreeNode<Integer> root, int data) {
        if (root == null) {
            return null;
        }

        if (data > root.data) {
            root.right = deleteDataHelper(root.right, data);
        } else if (data < root.data) {
            root.left = deleteDataHelper(root.left, data);
        }

        if (data == root.data) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                BinaryTreeNode<Integer> minNode = root.right;
                while (minNode.left != null) {
                    minNode = minNode.left;
                }
                root.data = minNode.data;
                root.right = deleteDataHelper(root.right, minNode.data);
            }
        }

        return root;
    }

    public void deleteData(int data) {
        root = deleteDataHelper(root, data);
    }

    private boolean hasDataHelper(BinaryTreeNode<Integer> root, int data) {
        if (root == null) {
            return false;
        }

        if (root.data == data) {
            return true;
        } else {
            if (data > root.data) {
                return hasDataHelper(root.right, data);
            } else {
                return hasDataHelper(root.left, data);
            }
        }
    }

    public boolean hasData(int data) {
        return hasDataHelper(root, data);
    }


    public static Pair<Boolean, Pair<Integer, Integer>> isBST2(BinaryTreeNode<Integer> root) {
        if (root == null) {
            Pair<Boolean, Pair<Integer, Integer>> output = new Pair<Boolean, Pair<Integer, Integer>>();
            output.first = true;
            output.second.first = Integer.MAX_VALUE; // we set the minimum from right subtree to infinity, i.e greater than root.data
            output.second.second = Integer.MIN_VALUE;// we set the minimum from right subtree to -infinity, i.e smaller than root.data
            return output;
        }

        Pair<Boolean, Pair<Integer, Integer>> leftOutput = isBST2(root.left);
        Pair<Boolean, Pair<Integer, Integer>> rightOutput = isBST2(root.right);

        // overall min
        int min = Math.min(root.data, Math.min(leftOutput.second.first, rightOutput.second.first));
        // overall max
        int max = Math.max(root.data, Math.max(leftOutput.second.second, rightOutput.second.second));

        // max from left subtree
        int leftMax = leftOutput.second.second;
        // min from right subtree
        int rightMin = rightOutput.second.first;

        boolean isBST = (root.data > leftMax && root.data <= rightMin) &&
                leftOutput.first && rightOutput.first;

        Pair<Boolean, Pair<Integer, Integer>> output = new Pair<Boolean, Pair<Integer, Integer>>();
        output.first = isBST;
        output.second.first = max;
        output.second.second = min;
        return output;
    }


    /* populate */
    class NodeNext {
        int data;
        NodeNext left, right, next;

        NodeNext(int d) {
            data = d;
            left = right = next = null;
        }
    }
    static NodeNext prev;
    public void populateNext(NodeNext root) {
        if(root == null) {
            return;
        }

        populateNext(root.left);

        // we are not on the leftmost node
        if(prev != null) {
            prev.next = root;
        }
        prev = root;

        populateNext(root.right);
    }


    /* lca */
    public BinaryTreeNode<Integer> lca(BinaryTreeNode<Integer> root, int n1, int n2) {
        if(root == null) {
            return null;
        }

        if(root.data > n1 && root.data > n2) {
            // left
            return lca(root.left, n1, n2);
        }
        if(root.data < n1 && root.data < n2) {
            //right
            return lca(root.right, n1, n2);
        }

        return root;
    }


    /* convert bst to a balanced bst
    * - approach is to store all elements in an array and then insert it as a balanced tree*/

    private void getNodes(BinaryTreeNode<Integer> root, ArrayList<Integer> nodes) {
        if(root == null) {
            return;
        }

        getNodes(root.left, nodes);
        nodes.add(root.data);
        getNodes(root.right, nodes);

    }

    private BinaryTreeNode<Integer> buildBalancedBST(ArrayList<Integer> nodes, int si, int ei) {
        if(si > ei) {
            return null;
        }

        int mid = (si + ei) / 2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(nodes.get(mid));

        root.left = buildBalancedBST(nodes, si, mid - 1);
        root.right = buildBalancedBST(nodes, mid + 1, ei);

        return root;
    }

    public BinaryTreeNode<Integer> balancedBST(BinaryTreeNode<Integer> root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        getNodes(root, nodes);

        return this.root = buildBalancedBST(nodes, 0, nodes.size() - 1);
    }


    /* k largest in bst */
    /* approach 1 - O(n) store nodes in array and return k */
    public int kthLargest(BinaryTreeNode<Integer> root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        getNodes(root, list);

        list.sort(Collections.reverseOrder());
        if(list.isEmpty() || list.size() < k) {
            return Integer.MIN_VALUE;
        }
        return list.get(k-1);
    }
    
    /* approach 2 */

    private void kthLargestUtil(BinaryTreeNode<Integer> root, int k, Ref<Integer> result, Ref<Integer> count) {
        if(root == null || count.val >= k) {
            return;
        }

        kthLargestUtil(root.right, k, result, count);
        count.val++;

        if(count.val == k) {
            result.val = root.data;
            return;
        }
        kthLargestUtil(root.left, k, result, count);
    }

    public int kthLargestBetter(BinaryTreeNode<Integer> root, int k) {
        Ref<Integer> result = new Ref<>();
        Ref<Integer> count = new Ref<>();
        result.val = -1;
        count.val = 0;
        kthLargestUtil(root, k, result, count);
        return result.val;
    }
}