public class ReverseDLLGivenSize {

    public static Node revListInGroupOfGivenSize(Node head, int k) {

        Node current = head, next = null, newHead = null;

        int count = 0;

        while(current != null && count < k) {
            next = current.next;

            Node newNode = new Node(current.data);
            newNode.next = newHead;
            newHead = newNode;

            current = next;
            count++;
        }

        Node tail = Node.getTail(newHead);

        if(next != null) {
//            Node reversedTail = head.next;
            tail.next = revListInGroupOfGivenSize(next, k);
        }

        return newHead;
    }

    public static void main(String[] args) {
        Node head = Node.takeInput();

        head = revListInGroupOfGivenSize(head, 3);
        Node.print(head);
    }
}
