import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class LevelOrder {

    static Node buildTree(String str){

        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while(queue.size()>0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if(i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if(!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data+" ");

        printInorder(root.right);
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Solution1 g = new Solution1();
            ArrayList <Integer> res = g.levelOrder(root);
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();
            t--;

        }
    }

}

// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution1
{
    //Function to return the level order traversal of a tree.
    public ArrayList<Integer> levelOrder(Node root)
    {
        // Your code here
        if(root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node frontNode = queue.poll();
            list.add(frontNode.data);
            if(frontNode.left != null) {
                queue.add(frontNode.left);
            }
            if(frontNode.right != null) {
                queue.add(frontNode.right);
            }
        }

        return list;
    }

    public ArrayList<Integer> reverseLevelOrder(Node root)
    {
        // code here
        if(root == null) {
            return null;
        }

        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        stack.push(root);

        Node frontNode = stack.peek();
        while (frontNode.right != null && frontNode.left != null) {
            frontNode = stack.peek();
            if(frontNode.right != null) {
                stack.push(frontNode.right);
            }
            if(frontNode.left != null) {
                stack.push(frontNode.left);
            }
        }

        while(!stack.isEmpty()) {
            list.add(stack.pop().data);
        }

        return list;
    }
}





