// { Driver Code Starts
//Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;


public class InorderList {

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

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            SolutionInorder g = new SolutionInorder();
            ArrayList<Integer> res = g.inOrder(root);
            for (int i = 0; i < res.size (); i++)
                System.out.print (res.get (i) + " ");
            System.out.print("\n");
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java



/* A Binary Tree node 

class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */
class SolutionInorder
{
    //Function to return a list containing the inorder traversal of the tree.

    void inorder(Node root, ArrayList<Integer> list) {
        if(root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }



    ArrayList<Integer> inOrder(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    void postorder(Node root, ArrayList<Integer> list) {
        if(root == null) {
            return;
        }

        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.data);


    }

    ArrayList<Integer> postOrder(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }


    void preorder(Node root, ArrayList<Integer> list) {
        if(root == null) {
            return;
        }

        list.add(root.data);
        preorder(root.left, list);
        preorder(root.right, list);


    }

    ArrayList<Integer> preOrder(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

}