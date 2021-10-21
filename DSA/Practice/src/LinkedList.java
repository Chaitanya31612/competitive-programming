import java.util.Scanner;

public class LinkedList {
    static class Node {
        int data;
        Node next;
    }

    public static void main(String[] args) {
        Node head = null;
        Node currhead = head;
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        while(data != -1) {
            Node newNode = new Node();
            newNode.data = data;

            if(head == null) {
                head = newNode;
            } else {
                currhead.next = newNode;
            }
            currhead = newNode;
            data = sc.nextInt();
        }

        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
