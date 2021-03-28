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

    /* diameter of tree*/
    /* time complexity O(n*h) where n is number of nodes and h is height of tree*/
    public static int diameter(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }

        /* diameter of left height + right height */
        int option1 = height(root.left) + height(root.right);
        int option2 = diameter(root.left);
        int option3 = diameter(root.right);

        return Math.max(option1, Math.max(option2, option3));
    }

    public static int height(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }


    /* diameter of tree imporved O(n) */
    public static class Pair<T, V> {
        public T height;
        public V diameter;
    }

    /* return height and diameter to reduce time complexity */
    public static Pair<Integer, Integer> heightDiameter(BinaryTreeNode<Integer> root) {
        if(root == null) {
            // height and diameter are null for empty tree
            Pair<Integer, Integer> output = new Pair<>();
            output.height = 0;
            output.diameter = 0;
            return output;
        }

        Pair<Integer, Integer> leftOutput = heightDiameter(root.left);
        Pair<Integer, Integer> rightOutput = heightDiameter(root.right);

        int height = 1 + Math.max(leftOutput.height, rightOutput.height);
        int option1 = leftOutput.height + rightOutput.height;
        int option2 = leftOutput.diameter;
        int option3 = rightOutput.diameter;

        int diameter = Math.max(option1, Math.max(option2, option3));
        Pair<Integer, Integer> output = new Pair<>();
        output.height = height;
        output.diameter = diameter;

        return output;
    }


    public static void inorder(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void preorder(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }


    /* build tree helper function which will build the tree for us*/
    public static BinaryTreeNode<Integer> buildTreeHelper(int[] in, int[] pre, int inS, int inE, int preS, int preE) {
        if(inS > inE) {
            return null;
        }

        int rootData = pre[preS];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        int rootDataIndex = -1;

        // find rootData in inorder array and set left to left subtree and right to right
        for(int i = inS; i <= inE; i++) {
            if(rootData == in[i]) {
                rootDataIndex = i;
                break;
            }
        }

        if(rootDataIndex == -1) {
            return null;
        }

        int leftInS = inS;
        int leftInE = rootDataIndex - 1;
        int leftPreS = preS + 1;
        int leftPreE = leftInE - leftInS + leftPreS;
        int rightInS = rootDataIndex + 1;
        int rightInE = inE;
        int rightPreS = leftPreE + 1;
        int rightPreE = preE;

        root.left = buildTreeHelper(in, pre, leftInS, leftInE, leftPreS, leftPreE);
        root.right = buildTreeHelper(in, pre, rightInS, rightInE, rightPreS, rightPreE);

        return root;
    }

    /*build tree from preorder inorder array*/
    public static BinaryTreeNode<Integer> buildTree(int[] in, int[] pre) {
        return buildTreeHelper(in, pre, 0, in.length - 1, 0, pre.length - 1);
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
//        BinaryTreeNode<Integer> root = takeInputLevelWise();
//
//        /* print */
//        printTree(root);
//
//        /* print level wise */
//        System.out.println();
//        printLevelWise(root);
//        System.out.println("Number of Nodes");
//        System.out.println(countNodes(root));
//
//
//        inorder(root);
//        System.out.println();
//        preorder(root);
//        System.out.println();
//        postorder(root);
//        System.out.println();


        /* build tree */
        int[] in = { 4, 2, 5,1,6,3,7};
        int[] pre = {1,2,4,5,3,6,7};

        BinaryTreeNode<Integer> root = buildTree(in, pre);
        printTree(root);
    }
}
