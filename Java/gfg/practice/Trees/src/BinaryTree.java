import java.util.*;

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

    public BinaryTreeNode<Integer> takeInput() {
        return root = takeInputLevelWise();
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

    public int countLeaves(BinaryTreeNode<Integer> root) {
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

    private ArrayList<Integer> leftView(BinaryTreeNode<Integer> root) {
        ArrayList<Integer> list = new ArrayList<>();

        if(root == null) {
            return list;
        }

        BinaryTreeNode<Integer> temp = root;
        int maxLevelTillNow = 0;
        list.add(root.data);
        while(temp != null) {
            maxLevelTillNow++;
            if(temp.left != null) {
                list.add(temp.left.data);
                temp = temp.left;
            } else if(temp.right != null) {
                list.add(temp.right.data);
                temp = temp.right;
            } else {
                temp = root.right;
                break;
            }
        }
        int rightLevel = 1;
        while(temp != null) {
            rightLevel++;
            if(rightLevel > maxLevelTillNow) {
                list.add(temp.data);
            }
            if(temp.left != null) {
                temp = temp.left;
            } else if(temp.right != null) {
                temp = temp.right;
            } else {
                break;
            }
        }

        return list;
    }

    public ArrayList<Integer> leftView() {
        return leftView(root);
    }


    /* left recursive */

    int max_level_left = 0;

    //Function to get the left view of the binary tree.
    private void leftViewUtil(ArrayList<Integer> result, BinaryTreeNode<Integer> node, int level)
    {
        //if root is null, we simply return.
        if (node==null) return;

        //if this is the first node of its level then it is in the left view.
        if (max_level_left < level)
        {
            //storing data of current node in list.
            result.add(node.data);
            max_level_left = level;
        }

        //calling function recursively for left and right
        //subtrees of current node.
        leftViewUtil(result, node.left, level+1);
        leftViewUtil(result, node.right, level+1);
    }

    //Function to return list containing elements of left view of binary tree.
    public ArrayList<Integer> leftViewRecursive(BinaryTreeNode<Integer> root)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        leftViewUtil(result, root, 1);
        //returning the list.
        return result;
    }


    /* right view recursive */
    int max_level_right = 0;

    //Function to get the left view of the binary tree.
    private void rightViewUtil(ArrayList<Integer> result, BinaryTreeNode<Integer> node, int level)
    {
        if (node==null) return;

        if (max_level_right < level){
            result.add(node.data);
            max_level_right = level;
        }

        rightViewUtil(result, node.right, level+1);
        rightViewUtil(result, node.left, level+1);
    }

    //Function to return list containing elements of left view of binary tree.
    private ArrayList<Integer> rightViewRecursive(BinaryTreeNode<Integer> root)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        rightViewUtil(result, root, 1);
        //returning the list.
        return result;
    }

    public ArrayList<Integer> rightViewRecursive() {
        return rightViewRecursive(root);
    }



    /* without siblings */
    private void noSiblingUtil(BinaryTreeNode<Integer> root, ArrayList<Integer> res) {
        if(root == null) {
            return;
        }

        if(root.left != null && root.right == null) {
            res.add(root.left.data);
        } else if(root.left == null && root.right != null) {
            res.add(root.right.data);
        }

        noSiblingUtil(root.left, res);
        noSiblingUtil(root.right, res);
    }

    public ArrayList<Integer> noSibling() {
        ArrayList<Integer> res = new ArrayList<>();
        noSiblingUtil(root, res);
        if(res.isEmpty()) res.add(-1);
        else {
            Collections.sort(res);
        }
        return res;
    }


    public ArrayList<Integer> printSpiral() {
        BinaryTreeNode<Integer> node = root;

        ArrayList<Integer> list = new ArrayList<>();
        if(node == null) {
            return list;
        }

        Stack<BinaryTreeNode<Integer>> s1 = new Stack<>();
        Stack<BinaryTreeNode<Integer>> s2 = new Stack<>();

        s1.push(node);

        while(!s1.isEmpty() || !s2.isEmpty()) {

            // print from right to left
            while(!s1.isEmpty()) {
                BinaryTreeNode<Integer> temp = s1.pop();
                list.add(temp.data);

                if(temp.right != null) {
                    s2.push(temp.right);
                }
                if(temp.left != null) {
                    s2.push(temp.left);
                }

            }

            // print from left to right
            while(!s2.isEmpty()) {
                BinaryTreeNode<Integer> temp = s2.pop();
                list.add(temp.data);

                if(temp.left != null) {
                    s1.push(temp.left);
                }
                if(temp.right != null) {
                    s1.push(temp.right);
                }
            }
        }

        return list;
    }



    private void mirrorTree(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return;
        }

        mirrorTree(root.left);
        mirrorTree(root.right);

        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public void mirrorTree() {
        mirrorTree(root);
    }


    public boolean isIdentical(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null ||
            root2 == null) {
            return false;
        }

        boolean leftOutput = isIdentical(root1.left, root2.left);
        boolean rightOutput = isIdentical(root1.right, root2.right);

        return ((root1.data == root2.data) &&
                leftOutput && rightOutput);
    }

    // O(N^2) approach
    public boolean isBalanced(BinaryTreeNode<Integer> root) {
        if(root == null) {
            return true;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        boolean leftOutput = isBalanced(root.left);
        boolean rightOutput = isBalanced(root.right);

        return (Math.abs(leftHeight - rightHeight) <= 1) &&
                leftOutput && rightOutput;
    }

    // O(N) approach
    public class HeightBalancedPair {
        int height;
        boolean isBalanced;
    }

    public HeightBalancedPair heightBalanced(BinaryTreeNode<Integer> root) {
        if(root == null) {
            HeightBalancedPair output = new HeightBalancedPair();
            output.height = 0;
            output.isBalanced = true;
            return output;
        }

        HeightBalancedPair leftOutput = heightBalanced(root.left);
        HeightBalancedPair rightOutput = heightBalanced(root.right);

        int height = Math.max(leftOutput.height, rightOutput.height) + 1;

        boolean isBalanced = (Math.abs(leftOutput.height - rightOutput.height) <= 1) &&
                leftOutput.isBalanced && rightOutput.isBalanced;

        HeightBalancedPair output = new HeightBalancedPair();
        output.height = height;
        output.isBalanced = isBalanced;
        return output;

    }

    public boolean isBalancedCheck(BinaryTreeNode<Integer> root) {
        HeightBalancedPair output = heightBalanced(root);

        return output.isBalanced;
    }



    /* Root to leaf path sum */

    public boolean hasPathSum(BinaryTreeNode<Integer> root, int sum) {
        if (root == null)
            return sum == 0;
        return hasPathSum(root.left, sum - root.data)
                || hasPathSum(root.right, sum - root.data);
    }


    /* find lca of two numbers in the tree */
    public BinaryTreeNode<Integer> lca(BinaryTreeNode<Integer> root, int n1, int n2) {
        if(root == null) {
            return null;
        }

        // if root.data is greater than both n1 and n2 then lca would be in the left subtree
        if(root.data > n1 && root.data > n2) {
            return lca(root.left, n1, n2);
        }

        if(root.data < n1 && root.data < n2) {
            return lca(root.right, n1, n2);
        }

        return root;
    }



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
}
