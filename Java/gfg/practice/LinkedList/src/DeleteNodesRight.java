public class DeleteNodesRight {

    public static Node compute(Node head) {
        head = Node.reverseLLMuchBetter(head);
        Node temp = head;
        Node prev = temp;
        int max = temp.data;
        temp = temp.next;
        while(temp != null) {
            if(temp.data < max) {
                prev.next = temp.next;
                temp = prev.next;
            } else {
                max = temp.data;
                prev = temp;
                temp = temp.next;
            }
        }
        head = Node.reverseLLMuchBetter(head);
        return head;
    }

//    public static Node compute(Node head) {
//        Node temp = head;
//
//        while(temp != null && temp.next != null) {
//            if(temp.data < temp.next.data) {
//                temp.data = temp.next.data;
//                temp.next = temp.next.next;
//            } else {
//                temp = temp.next;
//            }
//        }
//
//        return head;
//    }

    public static void main(String[] args) {
        Node head = Node.takeInput();

        head = compute(head);
        Node.print(head);
    }
}
