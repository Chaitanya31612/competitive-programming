import java.util.HashSet;

public class DetectLoop {

    // time = O(n), space = O(n)
    public static boolean detectLoopHash(Node head) {
        HashSet<Node> set = new HashSet<>();

        while(head != null) {
            if(set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }

        return false;
    }

    // floyd cycle detection, time = O(n) space = O(1)
    // two pointer method
    public static boolean detectLoop(Node head) {
        Node slow_p = head, fast_p = head;

        while(slow_p != null) {
            try {
                slow_p = slow_p.next;
                fast_p = fast_p.next.next;

                if(slow_p == fast_p) {
                    return true;
                }


            } catch (Exception e) {

            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = Node.takeInput();
        Node tail = Node.getTail(head);

        tail.next = head.next;
//        System.out.println(detectLoopHash(head));
        System.out.println(detectLoop(head));
    }
}
