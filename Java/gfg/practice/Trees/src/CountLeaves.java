public class CountLeaves {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        BinaryTreeNode<Integer> root = bt.takeInput();

        Tree t = new Tree();
        System.out.println(t.countLeaves(root));
    }
}

class Tree {
    int countLeaves(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }

        int leftTree = countLeaves(root.left);
        int rightTree = countLeaves(root.right);

        return leftTree + rightTree;
    }
}
