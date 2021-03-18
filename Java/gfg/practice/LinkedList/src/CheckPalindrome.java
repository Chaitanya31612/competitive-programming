public class CheckPalindrome {


    public static boolean isPalindrome(Node head)
    {
        int count = Node.getCount(head);
        if(count == 1) {
            return true;
        } else if(count == 2) {
            return head.data == head.next.data;
        }
        Node mid = Node.middle(head);
        Node temp1 = head, temp2 = mid.next;
        temp2 = Node.reverseLLMuchBetter(temp2);
        if((count&1) == 0) {
            if(mid.data != mid.next.data) {
                return false;
            }
        }
        while(temp1 != mid && temp2 != null) {
            if(temp1.data == temp2.data) {
                temp1 = temp1.next;
                temp2 = temp2.next;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = Node.takeInput();

        System.out.println(isPalindrome(head));
    }
}
