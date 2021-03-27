package generictrees;

import java.util.Scanner;

public class TreeUse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        generictrees.TreeNode<Integer> root = new generictrees.TreeNode<>(4);
//        generictrees.TreeNode<Integer> node1 = new generictrees.TreeNode<>(5);
//        generictrees.TreeNode<Integer> node2 = new generictrees.TreeNode<>(6);
//        generictrees.TreeNode<Integer> node3 = new generictrees.TreeNode<>(3);
//        generictrees.TreeNode<Integer> node4 = new generictrees.TreeNode<>(2);
//
//        root.children.add(node1);
//        root.children.add(node2);
//        root.children.add(node3);
//
//
//        node2.children.add(node4);
//
//        System.out.println(root);

         /*takeInput and print*/
//        generictrees.TreeNode<Integer> root = generictrees.TreeNode.takeInput(sc);

        /* takeInput levelwise*/
        TreeNode<Integer> root = TreeNode.takeInputLevelWise();


        System.out.println("Recursive");
        TreeNode.print(root);


        System.out.println("Level wise printing");
        TreeNode.printLevelWise(root);


        int num = TreeNode.numNodes(root);
        System.out.println("Number of node " + num);


        int largest = TreeNode.largestNode1(root, root.data);
        System.out.println("Largest node " + largest);


        int height = TreeNode.height(root);
        System.out.println("Height of tree " + height);


        /*print nodes at depth k*/
        TreeNode.printDepthAtK(root, 2);

        /* count leaf node */
        System.out.println();
        int countLeaf = TreeNode.countLeaf(root);
        System.out.println("number of leaf nodes " + countLeaf);

        /* preorder */
        TreeNode.preorder(root);

        System.out.println();
        /* postorder */
        TreeNode.postorder(root);
        System.out.println();
    }
}
