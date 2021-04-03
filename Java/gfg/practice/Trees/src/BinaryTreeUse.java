import java.util.ArrayList;

public class BinaryTreeUse {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        BinaryTreeNode<Integer> root = bt.takeInput();


//        ArrayList<Integer> list =  bt.leftView();
//        System.out.println(list);

//        ArrayList<Integer> listRightView = bt.rightViewRecursive();
//        System.out.println(listRightView);

        ArrayList<Integer> listSibling = bt.noSibling();
        System.out.println(listSibling);
    }

}
