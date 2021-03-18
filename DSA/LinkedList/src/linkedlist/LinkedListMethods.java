package linkedlist;

import java.util.Scanner;

public class LinkedListMethods {
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


    public static Node<Integer> middle(Node<Integer> head) {
        /*
         * two approaches
         * 1. find length of list and again iterate to find middle - can be done efficiently though
         * 2. use slow and fast approach -> fast -> last , slow -> middle. fast = 2 times speed of slow
         * */

        Node<Integer> slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public static Node<Integer> mergeSortedLists(Node<Integer> A, Node<Integer> B) {
        if(A == null) return B;
        if(B == null) return A;

        if(A.data < B.data) {
            A.next = mergeSortedLists(A.next, B);
            return A;
        } else {
            B.next = mergeSortedLists(A, B.next);
            return B;
        }


    }


    public static Node<Integer> mergeSort(Node<Integer> head) {
        if(head == null || head.next == null) {
            return head;
        }

        // find middle node and make it separate from right list but store reference of right list
        Node<Integer> mid = middle(head);
        Node<Integer> nextMiddle = mid.next;
        mid.next = null;

        Node<Integer> left = mergeSort(head);
        Node<Integer> right =  mergeSort(nextMiddle);
        Node<Integer> sorted = mergeSortedLists(left, right);
        return sorted;
    }

// doubly list delete
//    public static Node deleteNode(Node head, int x) {
//        Node temp = head;
//        int c = 0;
//        while(c < x - 1 && temp.next != null) {
//            temp = temp.next;
//            c++;
//        }
//
//        if(temp != null && temp.next == null) {
//            temp.prev.next = null;
//            return head;
//        }
//
//        if(temp != null && temp.prev == null) {
//            return head.next;
//        }
//
//        if(temp != null && temp.next != null) {
//            temp.next.prev = temp.prev;
//            temp.prev.next = temp.next;
//        }
//
//        return head;
//    }
}
