public class Intersection {

    public static Node findIntersection(Node head1, Node head2) {
        Node head3 = null;
        int pos = 1;
        while(head1 != null && head2 != null) {
            if(head1.data == head2.data) {
                Node newNode = new Node(head1.data);
                newNode.next = head3;
                head3 = newNode;

                head1 = head1.next;
                head2 = head2.next;
            } else if(head1.data < head2.data) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }

        }

        head3 = Node.reverseLLMuchBetter(head3);

        return head3;
    }

    public static void main(String[] args) {
        Node head1 = Node.takeInput();
        Node head2 = Node.takeInput();

        Node ans = findIntersection(head1, head2);
        Node.print(ans);
    }
}
