package bst;

public class BinarySearchTreeUse {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertData(10);
        bst.insertData(20);
        bst.insertData(5);
        bst.insertData(15);
        bst.insertData(3);
        bst.insertData(7);
        bst.print();
        System.out.println("after deletion");
        bst.deleteData(10);
        bst.print();
    }
}
