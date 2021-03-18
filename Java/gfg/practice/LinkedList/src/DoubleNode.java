import java.util.Scanner;

public class DoubleNode {
    int data;
    DoubleNode next;
    DoubleNode prev;

    public DoubleNode(int data) {
        this.data = data;
        next = prev = null;
    }

    public static DoubleNode takeInput() {
        DoubleNode head = null, tail = null;
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        // -1 terminating condition
        while(data != -1) {
            DoubleNode newNode = new DoubleNode(data);

            if(head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail.next.prev = tail;
                tail = tail.next;
            }
            data = sc.nextInt();
        }

        return head;
    }

    public static void print(DoublyDelete.Node head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
