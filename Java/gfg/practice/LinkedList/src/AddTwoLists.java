public class AddTwoLists {

    static Node addTwoLists(Node first, Node second){
        first = Node.reverseLLMuchBetter(first);
        second = Node.reverseLLMuchBetter(second);

        Node ans = null;
        int carry = 0, pos = 0;
        while (first != null && second != null) {
            int sum = first.data + second.data;
            sum += carry;
            carry = 0;
            if(sum > 9) {
                carry += sum / 10;
                sum = sum % 10;
            }
            ans = Node.insert(ans, sum, pos++);
            first = first.next;
            second = second.next;
        }

        while(first != null) {
            int sum = first.data + carry;

            carry = 0;
            if(sum > 9) {
                carry += sum / 10;
                sum = sum % 10;
            }
            ans = Node.insert(ans, sum, pos++);
            first = first.next;
        }

        while(second != null) {
            int sum = second.data + carry;

            carry = 0;
            if(sum > 9) {
                carry += sum / 10;
                sum = sum % 10;
            }
            ans = Node.insert(ans, sum , pos++);
            second = second.next;
        }

        if(carry > 0)
        ans = Node.insert(ans, carry , pos++);

        ans = Node.reverseLLMuchBetter(ans);
        return ans;
    }

    public static void main(String[] args) {
        Node head1 = Node.takeInput();
        Node head2 = Node.takeInput();

        Node head3 = addTwoLists(head1, head2);
        Node.print(head3);
    }
}
