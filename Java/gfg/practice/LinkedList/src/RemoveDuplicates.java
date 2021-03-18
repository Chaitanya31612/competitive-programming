public class RemoveDuplicates {

    public static Node removeDuplicates(Node head) {
        Node temp = head;
        while(temp != null && temp.next != null) {
            while(temp != null && temp.next != null && (temp.data == temp.next.data)) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Node head = Node.takeInput();

        head = removeDuplicates(head);
        Node.print(head);
    }
}
