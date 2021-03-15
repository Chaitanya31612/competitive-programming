package linkedlist;

import java.util.Scanner;

public class LinkedListUse {

    public static Node<Integer> takeInput() {
        Node<Integer> head = null;
        Node<Integer> currentNode = head;
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        // -1 terminating condition
        while(data != -1) {
            Node<Integer> newNode = new Node<>(data);

            if(head == null) {
                head = newNode;
            } else {
                currentNode.next = newNode;
            }
            currentNode = newNode;
            data = sc.nextInt();
        }

        return head;
    }

    // head for this function is different from that of main head
    public static void print(Node<Integer> head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node<Integer> insert(Node<Integer> head, int data, int pos) {
        Node<Integer> newNode = new Node<>(data);
        if(pos == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        int i = 0;
        Node<Integer> temp = head;

        while(i < pos-1 && temp != null) {
            temp = temp.next;
            i++;
        }

//        if(i == pos-1) {
            newNode.next = temp.next;
            temp.next = newNode;
//        }

        return head;
    }


    public static void delete(Node<Integer> head, int pos) {
        Node<Integer> temp = head;
        int i = 0;
        while(i < pos-1 && temp != null) {
            temp = temp.next;
            i++;
        }

        if(temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public static void deleteAlternate(Node<Integer> head) {
        Node<Integer> temp = head;

        while(temp != null && temp.next != null) {
            temp.next = temp.next.next;
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
//        Node<Integer> node1 = new Node<>(10);
//        Node<Integer> node2 = new Node<>(20);
//        Node<Integer> node3 = new Node<>(30);
//        node1.next = node2;
//        node2.next = node3;

        Node<Integer> head =  takeInput();
//        head = insert(head, 80, 0);
//        print(head);
//        delete(head, 3);

        deleteAlternate(head);
        print(head);
    }
}
