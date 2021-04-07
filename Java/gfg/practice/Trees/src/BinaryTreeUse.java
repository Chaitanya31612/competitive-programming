

public class BinaryTreeUse {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        BinaryTreeNode<Integer> root = bt.takeInput();

//        ArrayList<Integer> list =  bt.leftView();
//        System.out.println(list);

//        ArrayList<Integer> listRightView = bt.rightViewRecursive();
//        System.out.println(listRightView);

//        ArrayList<Integer> listSibling = bt.noSibling();
//        System.out.println(listSibling);

//        ArrayList<Integer> listSpiral = bt.printSpiral();
//        System.out.println(listSpiral);

//        bt.mirrorTree();
//        bt.print();

//        System.out.println(bt.isIdentical(root, root));
//        System.out.println(bt.isBalanced(root));
//        System.out.println(bt.isBalancedCheck(root));

//        ArrayList<Integer> listTop = bt.topView(root);
//        System.out.println(listTop);

//        /* TreeMap use */
//        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
//        treeMap.put(0, 1);
//        treeMap.put(-1, 2);
//        treeMap.put(1, 3);
//        treeMap.put(-2, 4);
//        treeMap.put(-3, 5);
//        treeMap.put(-4, 6);
//        System.out.println(treeMap);

        /* top view */
//        ArrayList<Integer> listTop = bt.topView(root);
//        System.out.println(listTop);

        /* bottom view */
//        ArrayList<Integer> listBottom = bt.bottomView(root);
//        System.out.println(listBottom);


        /* diagonal traversal */
//        ArrayList<Integer> listDiagonal = bt.diagonalTraverse(root);
//        System.out.println(listDiagonal);

        /* bt to sumTree */
//        bt.toSumTree(root);
//        bt.print();

        /* longest path sum */
        System.out.println(bt.sumOfLongPath(root));

    }

}
