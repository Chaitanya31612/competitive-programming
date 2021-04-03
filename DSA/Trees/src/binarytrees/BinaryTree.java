import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
    private BinaryTreeNode<Integer> root;

    private void printTree(BinaryTreeNode<Integer> root) {
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

    private BinaryTreeNode<Integer> takeInputLevelWise() {
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

    public void takeInput() {
        root = takeInputLevelWise();
    }

    private int countNodes(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return leftCount + rightCount + 1;
    }

    public int countNodes() {
        return countNodes(root);
    }

    /* diameter of tree*/
    /* time complexity O(n*h) where n is number of nodes and h is height of tree*/
    private int diameter(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }

        /* diameter of left height + right height */
        int option1 = height(root.left) + height(root.right);
        int option2 = diameter(root.left);
        int option3 = diameter(root.right);

        return Math.max(option1, Math.max(option2, option3));
    }

    public int diameter() {
        return diameter(root);
    }

    private int height(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }


    /* diameter of tree imporved O(n) */
    public  class Pair<T, V> {
        public T height;
        public V diameter;
    }

    /* return height and diameter to reduce time complexity */
    private Pair<Integer, Integer> heightDiameter(BinaryTreeNode<Integer> root) {
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

    public Pair<Integer, Integer> heightDiameter() {
        return heightDiameter(root);
    }

    private void inorder(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public void inorder() {
        inorder(root);
    }

    private void preorder(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void preorder() {
        preorder(root);
    }

    private void postorder(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public void postorder() {
        postorder(root);
    }
}
