
public class DeleteWithoutHead {

    public static void deleteNode(Node node)
    {
        Node temp = node;
        while(node.next != null) {
            node.data = node.next.data;
            temp = node;
            node = node.next;
        }
        temp.next = null;
    }

    public static void deleteNodeBetter(Node del) {
        Node temp = del.next;
        del.data = temp.data;
        del.next = temp.next;
        temp = null;
    }

    public static void main(String[] args) {
        Node head = Node.takeInput();

        deleteNode(head.next.next);
        Node.print(head);

//        deleteNodeBetter(head.next.next);
//        Node.print(head);
    }
}
