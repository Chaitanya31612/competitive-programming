public class NfromLast {

    public static int getCount(Node head) {
        int count = 0;
        while(head != null) {
            head = head.next;
            count++;
        }

        return count;
    }

    public static int getNthFromLast(Node head, int n)
    {
        int count = getCount(head);
        if(count < n) {
            return -1;
        } else if(count == n) {
            return head.data;
        } else {
            int countbeg = count - n;
            Node temp = head;
            while(countbeg-- > 0 && temp != null) {
                temp = temp.next;
            }
            return temp.data;
        }
    }

    public static void main(String[] args) {
        Node head = Node.takeInput();

        System.out.println(getNthFromLast(head, 2));
    }
}
