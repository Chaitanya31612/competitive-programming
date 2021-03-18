public class ReverseLL {

    public static Node reverseList(Node head)
    {
        if(head == null || head.next == null) {
            return head;
        }

        Node reversedTail = head.next;
        Node finalHead = reverseList(head.next);
        reversedTail.next = head;
        head.next = null;

        return finalHead;
    }

    public static void main(String[] args) {
        Node head = Node.takeInput();
        head = reverseList(head);

        Node.print(head);
    }
}
