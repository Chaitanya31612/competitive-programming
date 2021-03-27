package generictrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeNode<T> {
    public T data;
    public ArrayList<TreeNode<T>> children;

    public TreeNode(T data) {
        this.data = data;
        children = new ArrayList<>();
    }

    // takeInput recursive
    public static TreeNode<Integer> takeInput(Scanner sc) {
        System.out.println("Enter next node");
        int n = sc.nextInt();
        TreeNode<Integer> root = new TreeNode<>(n);
        System.out.println("Enter number of children for " + n);

        int childCount = sc.nextInt();
        for(int i = 0; i < childCount; i++) {
            TreeNode<Integer> child = takeInput(sc);
            root.children.add(child);
        }
        return root;
    }

    // takeInput level wise
    public static TreeNode<Integer> takeInputLevelWise() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root data");
        int rootData = sc.nextInt();
        TreeNode<Integer> root = new TreeNode<>(rootData);

        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);

        while(!pendingNodes.isEmpty()) {
            TreeNode<Integer> firstNode = pendingNodes.poll();
            System.out.println("Enter number of children of " + firstNode.data);

            int numChild = sc.nextInt();
            for(int i = 0; i < numChild; i++) {
                System.out.println("Enter " + (i+1) + "th child of " + firstNode.data);
                int child = sc.nextInt();
                TreeNode<Integer> childNode = new TreeNode<>(child);
                firstNode.children.add(childNode);
                pendingNodes.add(childNode);
            }
        }
        return root;
    }

    public static void print(TreeNode<Integer> root) {
        // print like 4: 2 3 1

        // first print for root
        System.out.print(root.data + ": ");
        for(int i = 0; i < root.children.size(); i++) {
            System.out.print(root.children.get(i).data + " ");
        }
        System.out.println();

        for(int i = 0; i < root.children.size(); i++) {
            print(root.children.get(i));
        }
        return;
    }

    /*print levelwise */
    public static void printLevelWise(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();

        pendingNodes.add(root);
        while(!pendingNodes.isEmpty()) {
            TreeNode<Integer> firstNode = pendingNodes.poll();

            System.out.print(firstNode.data + ": ");
            for(int i = 0; i < firstNode.children.size(); i++) {
                System.out.print(firstNode.children.get(i).data + " ");
                pendingNodes.add(firstNode.children.get(i));
            }
            System.out.println();

        }
    }

    /* print preorder */
    public static void preorder(TreeNode<Integer> root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        for(int i = 0; i < root.children.size(); i++) {
            preorder(root.children.get(i));
        }
    }

    /* print postorder */
    public static void postorder(TreeNode<Integer> root) {
        if(root == null) {
            return;
        }

        for(int i = 0; i < root.children.size(); i++) {
            postorder(root.children.get(i));
        }
        System.out.print(root.data + " ");
    }


    /*Number of node*/
    public static int numNodes(TreeNode<Integer> root) {

        /*edge case when root = null*/
        if(root == null) {
            return 0;
        }

        /*Base case not needed because of for loop*/
//        if(root.children.size() == 0) {
//            return 1;
//        }

        int count = 1;
        for(int i = 0; i < root.children.size(); i++) {
            count += numNodes(root.children.get(i));
        }
        return count;
    }


    /*node with largest value*/
    public static int largestNode1(TreeNode<Integer> root, int max) {
        if(root.children.size() == 0) {
            return root.data >= max ? root.data : max;
        }

        for(int i = 0; i < root.children.size(); i++) {
            max = largestNode1(root.children.get(i), max);
        }

        return max;
    }

    /* largest node */
    public static int largestNode(TreeNode<Integer> root) {
        // edge case, not base case
        if(root == null) {
            return Integer.MIN_VALUE;
        }

        int ans = root.data;
        for(int i = 0; i < root.children.size(); i++) {
            int childLargest = largestNode(root.children.get(i));
            if(childLargest > ans) {
                ans = childLargest;
            }
        }

        return ans;
    }


    /*Height of the tree*/
    public static int height(TreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = 1;
        for(int i = 0; i < root.children.size(); i++) {
            int newHeight = 1;
            newHeight += height(root.children.get(i));
            leftHeight = Math.max(leftHeight, newHeight);
        }

        return leftHeight;
    }


    /* Print depth at level k */
    public static void printDepthAtK(TreeNode<Integer> root, int k) {
        if(k < 0) {
            return;
        }
        if(k == 0) {
            System.out.print(root.data + " ");
            return;
        }

        for(int i = 0; i < root.children.size(); i++) {
            printDepthAtK(root.children.get(i), k-1);
        }
    }


    /* Count number of leaf nodes */
    public static int countLeaf(TreeNode<Integer> root) {
        // edge case
        if(root == null) {
            return 0;
        }

        // base case
        if(root.children.size() == 0) {
            return 1;
        }

        int count = 0;
        for(int i = 0; i < root.children.size(); i++) {
            count += countLeaf(root.children.get(i));
        }

        return count;
    }
}
