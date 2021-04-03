

public class BinarySearchTree {

    private BinaryTreeNode<Integer> root;

    /* Time complexity of insertion, searching, deletion is O(height) */

    /* print */
    public static void printTree(BinaryTreeNode<Integer> root) {
        // base case
        if(root == null) {
            return;
        }

        String toBePrinted = root.data + ": ";
        if(root.left != null) {
            toBePrinted += "L:" + root.left.data + ",";
        }
        if(root.right != null) {
            toBePrinted += "R:" + root.right.data;
        }
        System.out.println(toBePrinted);

        printTree(root.left);
        printTree(root.right);
    }

    public void print() {
        printTree(root);
    }

    /* insertion */
    private BinaryTreeNode<Integer> insertDataHelper(BinaryTreeNode<Integer> root, int data) {
        if(root == null) {
            BinaryTreeNode<Integer> node = new BinaryTreeNode<>(data);
            root = node;
            return root;
        }

        if(data > root.data) {
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
        if(root == null) {
            return Integer.MAX_VALUE;
        }

        return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
    }

    private BinaryTreeNode<Integer> deleteDataHelper(BinaryTreeNode<Integer> root, int data) {
        if(root == null) {
            return null;
        }

        if(data > root.data){
            root.right = deleteDataHelper(root.right, data);
        } else if(data < root.data) {
            root.left = deleteDataHelper(root.left, data);
        }

        if(data == root.data) {
            if(root.left == null && root.right == null) {
                return null;
            } else if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            } else {
                BinaryTreeNode<Integer> minNode = root.right;
                while(minNode.left != null) {
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
        if(root == null) {
            return false;
        }

        if(root.data == data) {
            return true;
        } else {
            if(data > root.data) {
                return hasDataHelper(root.right, data);
            } else {
                return hasDataHelper(root.left, data);
            }
        }
    }

    public boolean hasData(int data) {
        return hasDataHelper(root, data);
    }
}
