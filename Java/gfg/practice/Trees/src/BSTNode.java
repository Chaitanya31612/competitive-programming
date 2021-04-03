//import java.util.*;
//
//public class BSTNode<T> {
//    public T data;
//    public BSTNode<T> left;
//    public BSTNode<T> right;
//
//    public BSTNode(T data) {
//        this.data = data;
//        this.left = null;
//        this.right = null;
//    }
//
//    /* Time complexity of insertion, searching, deletion is O(height) */
//
//    public static void printLevelWise(BSTNode<Integer> root) {
//        Queue<BSTNode<Integer>> pendingNodes = new LinkedList<>();
//
//        pendingNodes.add(root);
//
//        while (!pendingNodes.isEmpty()) {
//            BSTNode<Integer> front = pendingNodes.poll();
//
//            System.out.print(front.data + ": ");
//
//            // left
//            if(front.left != null) {
//                System.out.print("L" + front.left.data + ", ");
//                pendingNodes.add(front.left);
//            }
//
//            // right
//            if(front.right != null) {
//                System.out.print("R" + front.right.data);
//                pendingNodes.add(front.right);
//            }
//            System.out.println();
//        }
//    }
//
//
//    public static BSTNode<Integer> takeInputLevelWise() {
//        Scanner sc = new Scanner(System.in);
//        Queue<BSTNode<Integer>> pendingNodes = new LinkedList<>();
//        System.out.println("Enter root data");
//        int rootData = sc.nextInt();
//        if(rootData == -1) {
//            return null;
//        }
//        BSTNode<Integer> root = new BSTNode<>(rootData);
//        pendingNodes.add(root);
//
//        while(!pendingNodes.isEmpty()) {
//            BSTNode<Integer> front = pendingNodes.poll();
//
//            System.out.println("enter left node for " + front.data);
//            int leftChild = sc.nextInt();
//            if(leftChild != -1) {
//                BSTNode<Integer> leftNode = new BSTNode<>(leftChild);
//                front.left = leftNode;
//                pendingNodes.add(leftNode);
//            }
//            System.out.println("enter right node for " + front.data);
//            int rightChild = sc.nextInt();
//            if(rightChild != -1) {
//                BSTNode<Integer> rightNode = new BSTNode<>(rightChild);
//                front.right = rightNode;
//                pendingNodes.add(rightNode);
//            }
//        }
//
//        return root;
//    }
//
//    /* takeInput bst */
//    public static BSTNode<Integer> takeInputBST() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter number of elements");
//        int n = sc.nextInt();
//
//        BSTNode<Integer> root = null;
//        for(int i = 0; i < n; i++) {
//            int x = sc.nextInt();
//            root = insertDataHelper(root, x);
//        }
//
//        return root;
//    }
//
//    /* Binary search */
//    public static BSTNode<Integer> search(BSTNode<Integer> root, int key) {
////        System.out.println("here");
//        if(root == null) {
//            return null;
//        }
//
//        if(root.data == key) {
//            return root;
//        } else {
//            if(key > root.data) {
//                return search(root.right, key);
//            } else {
//                return search(root.left, key);
//            }
//        }
//    }
//
//
//    /* print in a given range */
//    public static void printRange(BSTNode<Integer> root, int l, int r) {
//        if(root == null) {
//            return;
//        }
//
//        if(root.data > r) {
//            // only left
//
//            printRange(root.left, l, r);
//
//        } else if(root.data < l) {
//            // right only
//            printRange(root.right, l, r);
//        } else {
//            // both
//            if(root.data >= l && root.data <= r) {
//                System.out.println(root.data);
//            }
//            printRange(root.left, l, r);
//            printRange(root.right, l, r);
//        }
//
//    }
//
//
//    /* minimum element in bst */
//    public static int minimum(BSTNode<Integer> root) {
//        if(root == null) {
//            return Integer.MAX_VALUE;
//        }
//
//        return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
//    }
//
//
//    /* maximum element in bst */
//    public static int maximum(BSTNode<Integer> root) {
//        if(root == null) {
//            return Integer.MIN_VALUE;
//        }
//
//        return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
//    }
//
//    /* isBST - Time - O(no of nodes * height of tree) */
//    public static boolean isBST(BSTNode<Integer> root) {
//        if(root == null) {
//            // for our case let's assume empty tree is a bst
//            return true;
//        }
//
//        int leftMax = maximum(root.left);
//        int rightMin = minimum(root.right);
//
//        if(root.data <= leftMax) {
//            return false;
//        }
//
//        if(root.data > rightMin) {
//            return false;
//        }
//
//        boolean leftBST = isBST(root.left);
//        boolean rightBST = isBST(root.right);
//
//        if(leftBST && rightBST) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//
//    /* isBST improved - Time - O(n)
//        previous bst function was bad because of min , max call along with isBST again on left and right
//        which leads to repetitive work.
//        So now we will have a function which will return min, max, isBST through single function
//        Now for returning three things either we can create a triplet class or use existing pair class
//    * */
//
//    /* Pair.first = isBST
//     *  Pair.second.first = min
//     *  Pair.second.second = max
//     * */
//    public static Pair<Boolean, Pair<Integer, Integer>> isBST2(BSTNode<Integer> root) {
//        if(root == null) {
//            Pair<Boolean, Pair<Integer, Integer>> output = new Pair<Boolean, Pair<Integer, Integer>>();
//            output.first = true;
//            output.second.first = Integer.MAX_VALUE; // we set the minimum from right subtree to infinity, i.e greater than root.data
//            output.second.second = Integer.MIN_VALUE;// we set the minimum from right subtree to -infinity, i.e smaller than root.data
//            return output;
//        }
//
//        Pair<Boolean, Pair<Integer, Integer>> leftOutput = isBST2(root.left);
//        Pair<Boolean, Pair<Integer, Integer>> rightOutput = isBST2(root.right);
//
//        // overall min
//        int min = Math.min(root.data, Math.min(leftOutput.second.first, rightOutput.second.first));
//        // overall max
//        int max = Math.max(root.data, Math.max(leftOutput.second.second, rightOutput.second.second));
//
//        // max from left subtree
//        int leftMax = leftOutput.second.second;
//        // min from right subtree
//        int rightMin = rightOutput.second.first;
//
//        boolean isBST = (root.data > leftMax && root.data <= rightMin) &&
//                leftOutput.first && rightOutput.first;
//
//        Pair<Boolean, Pair<Integer, Integer>> output = new Pair<Boolean, Pair<Integer, Integer>>();
//        output.first = isBST;
//        output.second.first = max;
//        output.second.second = min;
//        return output;
//    }
//
//
//    /* isBST different approach
//     *  check each root element to be within a given range, change the range while moving down
//     *  min - minimum range
//     *  max - maximum range
//     */
//
//    public static boolean isBST3(BSTNode<Integer> root, int min, int max) {
//        if(root == null) {
//            return true;
//        }
//
////        if(root.data >= min && root.data <= max) {
////            boolean leftOutput = isBST3(root.left, min, root.data-1);
////            boolean rightOutput = isBST3(root.right, root.data, max);
////
////            if(leftOutput && rightOutput) {
////                return true;
////            } else {
////                return false;
////            }
////        } else {
////            return false;
////        }
//
//        /* OR */
//
//        if(root.data < min || root.data > max) {
//            return false;
//
//        }
//
//        boolean leftOutput = isBST3(root.left, min, root.data-1);
//        boolean rightOutput = isBST3(root.right, root.data, max);
//
//        return leftOutput && rightOutput;
//    }
//
//
//    /* construct from sorted array */
//    public static BSTNode<Integer> bstFromArray(int[] arr, int si, int ei) {
//        if(arr.length == 0 || si > ei) {
//            return null;
//        }
//
//        int mid = (si + ei) / 2;
//        BSTNode<Integer> root = new BSTNode<>(arr[mid]);
//        root.left = bstFromArray(arr, si, mid-1);
//        root.right = bstFromArray(arr, mid+1, ei);
//
//        return root;
//    }
//
//
//    /* Convert bst to sorted linked list */
//    public static class Node {
//        int data;
//        Node next;
//
//        public Node(int data) {
//            this.data = data;
//            this.next = null;
//        }
//    }
//
//    public static class PairNode {
//        Node head;
//        Node tail;
//    }
//
//    public static PairNode ConvertToLL(BSTNode<Integer> root) {
//        if(root == null) {
//            return null;
//        }
//
//        Node head = new Node(root.data);
//        PairNode leftOutput = ConvertToLL(root.left);
//        if(leftOutput != null && leftOutput.tail != null) {
//            leftOutput.tail.next = head;
//        }
//
//        PairNode rightOutput = ConvertToLL(root.right);
//        if(rightOutput != null) {
//            head.next = rightOutput.head;
//        }
//
//        PairNode output = new PairNode();
//        if(rightOutput == null) {
//            output.tail = head;
//        } else {
//            output.tail = rightOutput.tail;
//        }
//        if(leftOutput == null) {
//            output.head = head;
//        } else {
//            output.head = leftOutput.head;
//        }
//
//        return output;
//    }
//
//
//    /* insert function */
//    public static BSTNode<Integer> insertDataHelper(BSTNode<Integer> root, int data) {
//        if(root == null) {
//            BSTNode<Integer> node = new BSTNode<>(data);
//            return node;
//        }
//
//        if(data > root.data) {
//            // right
//            root.right = insertDataHelper(root.right, data);
//        } else {
//            // left
//            root.left = insertDataHelper(root.left, data);
//        }
//        return root;
//    }
//
//
//    /* minimum of bst */
////    public static int minimumBST(BSTNode<Integer> root) {
////        // not using recursion
////        if(root == null) {
////            return -1;
////        }
////
////        int min = root.data;
////        while(root.left != null) {
////            min = root.left.data;
////        }
////
////        return min;
////    }
//
//
//    /* deletion */
//    public static BSTNode<Integer> deleteDataHelper(BSTNode<Integer> root, int data) {
//        if(root == null) {
//            return null;
//        }
//
//        if(data > root.data){
//            root.right = deleteDataHelper(root.right, data);
//        } else if(data < root.data) {
//            root.left = deleteDataHelper(root.left, data);
//        } else {
//            if(root.left == null && root.right == null) {
//                return null;
//            } else if(root.left == null) {
//                return root.right;
//            } else if(root.right == null) {
//                return root.left;
//            } else {
//                BSTNode<Integer> minNode = root.right;
//                while(minNode.left != null) {
//                    minNode = minNode.left;
//                }
//                root.data = minNode.data;
//                root.right = deleteDataHelper(root.right, minNode.data);
//            }
//        }
//
//        return root;
//    }
//
//}
