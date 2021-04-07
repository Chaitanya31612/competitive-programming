public class BinarySearchTreeUse {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        BinaryTreeNode<Integer> root = bst.takeInputBST();

//        bst.print();
//        bst.balancedBST(root);
//        bst.print();

        System.out.println(bst.kthLargest(root, 5));
        System.out.println(bst.kthLargestBetter(root, 5));
    }
}
