public class Add1 {

    public static Node addOne(Node head) {
        head = Node.reverseLLMuchBetter(head);
        Node temp = head;
        temp.data = temp.data + 1;
        int carry = 0, sum = 0;
        while(temp != null) {
            sum = temp.data + carry;
            carry = 0;
            if(sum > 9) {
                temp.data = sum % 10;
                carry = sum / 10;
            } else {
                temp.data = sum;
            }
            temp = temp.next;
        }
        head = Node.reverseLLMuchBetter(head);
        if(carry > 0) {
            Node newNode = new Node(carry);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = Node.takeInput();

        head = addOne(head);
        Node.print(head);
    }
}
