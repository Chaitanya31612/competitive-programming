import java.util.HashSet;

public class RemoveDuplicatesUnsorted {

    public static Node removeDuplicates(Node head) {
        HashSet<Integer> set = new HashSet<>();

        Node current = head, prev = null;

        while(current != null){
            int curval = current.data;

            if(set.contains(curval)) {
                prev.next = current.next;
            } else {
                set.add(curval);
                prev = current;
            }
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Node head = Node.takeInput();

        removeDuplicates(head);
        Node.print(head);
    }
}
