package binarytrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {

    /* print recursive */
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

    /* print level wise */
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();

        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingNodes.poll();

            System.out.print(front.data + ": ");

            // left
            if(front.left != null) {
                System.out.print("L" + front.left.data + ", ");
                pendingNodes.add(front.left);
            }

            // right
            if(front.right != null) {
                System.out.print("R" + front.right.data);
                pendingNodes.add(front.right);
            }
            System.out.println();
        }
    }

    /* takeInput recursive */
    public static BinaryTreeNode<Integer> takeInput(Scanner sc) {
        System.out.println("Enter root data");
        int rootData = sc.nextInt();
        if(rootData == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        root.left = takeInput(sc);
        root.right = takeInput(sc);

        return root;
    }

    /* takeInput level wise*/
    public static BinaryTreeNode<Integer> takeInputLevelWise() {
        Scanner sc = new Scanner(System.in);
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        System.out.println("Enter root data");
        int rootData = sc.nextInt();
        if(rootData == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        pendingNodes.add(root);

        while(!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingNodes.poll();

            System.out.println("enter left node for " + front.data);
            int leftChild = sc.nextInt();
            if(leftChild != -1) {
                BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<>(leftChild);
                front.left = leftNode;
                pendingNodes.add(leftNode);
            }
            System.out.println("enter right node for " + front.data);
            int rightChild = sc.nextInt();
            if(rightChild != -1) {
                BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<>(rightChild);
                front.right = rightNode;
                pendingNodes.add(rightNode);
            }
        }

        return root;
    }

    /* count number of node */
    public static int countNodes(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return leftCount + rightCount + 1;
    }


    public static void main(String[] args) {
//        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(1);
//        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2);
//        node.left = node1;
//        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
//        node.right = node2;

        /* takeInput recursive */
//        Scanner sc = new Scanner(System.in);
//        BinaryTreeNode<Integer> root = takeInput(sc);

        /*takeInput levelwise*/
        BinaryTreeNode<Integer> root = takeInputLevelWise();

        /* print */
        printTree(root);

        /* print level wise */
        System.out.println();
        printLevelWise(root);
        System.out.println("Number of Nodes");
        System.out.println(countNodes(root));

    }
}
