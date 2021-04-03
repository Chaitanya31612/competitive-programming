package bst;


public class BSTUse {

    public static void main(String[] args) {
//        BSTNode<Integer> root = BSTNode.takeInputLevelWise();

        /* searching*/
//        BSTNode<Integer> found = search(root, 12);
//        System.out.println(found.data);

        /* print range */
//        printRange(root, 6, 10);

        /* check bst */
//        System.out.println(isBST(root));
//        System.out.println(isBST2(root));
//        System.out.println(isBST3(root, 10, 70));


        /* bst from array */
//        int[] arr = {1,2,3,4,5,6,7};
//        BSTNode<Integer> root = BSTNode.bstFromArray(arr, 0, arr.length-1);
//        BSTNode.printLevelWise(root);


        /* convert to ll */
//        BSTNode.PairNode pairNode = BSTNode.ConvertToLL(root);
//
//        BSTNode.Node temp = pairNode.head;
//        while(temp != null) {
//            System.out.println(temp.data);
//            temp = temp.next;
//        }

        /* insert */
        BSTNode<Integer> root = BSTNode.takeInputBST();

        BSTNode.printLevelWise(root);

//        System.out.println("leaf");
//        root = BSTNode.deleteDataHelper(root, 1);
//        BSTNode.printLevelWise(root);
//
//        System.out.println("root");
//        root = BSTNode.deleteDataHelper(root, 4);
//        BSTNode.printLevelWise(root);

//        System.out.println("middle");
//        root = BSTNode.deleteDataHelper(root, 6);
//        BSTNode.printLevelWise(root);
    }
}
