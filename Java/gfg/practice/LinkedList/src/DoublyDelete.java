import java.util.Scanner;

public class DoublyDelete {
    public static class Node {
        int data;
        Node next;
        Node prev;
        Node(int d)
        {
            data = d;
            next = prev = null;
        }
    }

    public static Node takeInput() {
        Node head = null, tail = null;
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        // -1 terminating condition
        while(data != -1) {
            Node newNode = new Node(data);

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

    public static void print(Node head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node deleteNode(Node head, int x) {
        Node temp = head;
        int c = 0;
        while(c < x - 1 && temp.next != null) {
            temp = temp.next;
            c++;
        }

        if(temp != null && temp.next == null) {
            temp.prev.next = null;
            return head;
        }

        if(temp != null && temp.prev == null) {
            return head.next;
        }

        if(temp != null && temp.next != null) {
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Node head = takeInput();
        print(head);

        head = deleteNode(head, 3);
        print(head);
    }
}
