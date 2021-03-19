public class EvenOdd {

    public static Node divide(Node head) {
        Node temp = head, odd = null, even = null;
        int posevn = 0, posodd = 0;
        while(temp != null) {
            if(temp.data % 2 == 0) {
                even = Node.insert(even, temp.data, posevn++);
            } else {
                odd = Node.insert(odd, temp.data, posodd++);
            }
            temp = temp.next;
        }

        while(odd != null) {
            even = Node.insert(even, odd.data, posevn++);
            odd = odd.next;
        }

        return even;
    }

    public static void main(String[] args) {
        Node head = Node.takeInput();

        Node.print(divide(head));
    }
}
