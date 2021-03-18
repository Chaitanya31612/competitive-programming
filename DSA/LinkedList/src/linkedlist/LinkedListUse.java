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


    // recursive approach for inserting element at position pos
    public static Node<Integer> insertR(Node<Integer> head, int pos, int elem) {
        // insert at front of the list
        if(pos == 0 || head == null) {
            Node<Integer> newNode = new Node<>(elem);
            newNode.next = head;
            return newNode;
        }

        // if we don't want to insert at end for pos > length of list
//        if(head == null) {
//            return head;
//        }

        // recursion will insert in the remaining list and return head of remaining list
        head.next = insertR(head.next, pos-1, elem);
        // return the finalHead
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


    /* Recursive approach for deletion*/
    public static Node<Integer> deleteR(Node<Integer> head, int pos) {
        if(pos == 0) {
            return head.next;
        }
        if(head == null) {
            return head;
        }

        head.next = deleteR(head.next, pos - 1);

        return head;
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

/*Merge sorted list try - not complete*/
//    public static Node<Integer> mergeSorted(Node<Integer> head1, Node<Integer> head2) {
//        Node<Integer> t1 = head1, t2 = head2, h3 = null, t3 = null;  // h3 and t3 are head and tail for final list they point to whosoeer is smaller
//
//        while(t1 != null && t1 != null) {
//            if(t1.data <= t2.data) {
//                if(h3 == null && t3 == null) {
//                    h3 = t1;
//                    t3 = t1;
//                    t1 = t1.next;
//                } else {
//                    // new t3
//                    t1.next = t2;
//                    t1 = t1.next;
//                }
//            } else {
//                if(h3 == null && t3 == null) {
//                    h3 = t2;
//                    t3 = t3;
//                    t2 = t2.next;
//                } else {
//                    // new t3
//                }
//            }
//        }
//    }

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


    // recursive approach for reversing a linked list - O(n^2)
    public static Node<Integer> reverseR(Node<Integer> head) {
        // if list is empty or have only one element
        if(head == null || head.next == null) {
            return head;
        }

        // finalHead will reverse rest of the linked list -> leap of faith of recursion
        Node<Integer> finalHead = reverseR(head.next);

        Node<Integer> temp = finalHead;
        while(temp.next != null) {
            temp = temp.next;
        }
        // update pointer for last node to head
        temp.next = head;
        // make previous head point to null
        head.next = null;

        return finalHead;
    }


    public static DoubleNode reverseBetter(Node<Integer> head) {
        if(head == null || head.next == null) {
            DoubleNode ans = new DoubleNode();
            ans.head = head;
            ans.tail = head;
            return ans;
        }

        DoubleNode smallAns = reverseBetter(head.next);
        smallAns.tail.next = head;
        head.next = null;

        DoubleNode ans = new DoubleNode();
        ans.head = smallAns.head;
        ans.tail = head;
        return ans;
    }


    public static Node<Integer> reverseLLMuchBetter(Node<Integer> head) {
        if(head == null || head.next == null) {
            return head;
        }

        // head.next contains pointer to last node of sorted linked list
        Node<Integer> reversedTail = head.next;
        Node<Integer> finalSorted = reverseLLMuchBetter(head.next);
        reversedTail.next = head;
        head.next = null;

        return finalSorted;
    }


    public static Node<Integer> reverseIterative(Node<Integer> head) {
        Node<Integer> prev = null, curr = head, nex;
//        if(head == null || head.next == null) {
//            return head;
//        } else {
//            prev = null;
//            curr = head;
//            nex = curr.next;
//        }

        while(curr != null) {
            nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }

        return prev;
    }




    public static void main(String[] args) {
        /*Simple First step*/
//        Node<Integer> node1 = new Node<>(10);
//        Node<Integer> node2 = new Node<>(20);
//        Node<Integer> node3 = new Node<>(30);
//        node1.next = node2;
//        node2.next = node3;

        /*take input*/
        Node<Integer> head =  takeInput();


        /*Insert iteratively at position*/
//        head = insert(head, 80, 0);
//        print(head);
//        delete(head, 3);


        /*Delete alternative*/
//        deleteAlternate(head);
//        print(head);


        /*Middle of list*/
//        Node<Integer> mid = middle(head);
//        System.out.println(mid.data);


        /*Merge sorted list*/
//        Node<Integer> node1 = takeInput();
//        Node<Integer> node2 = takeInput();
//        Node<Integer> finalList = mergeSortedLists(node1, node2);
//        print(finalList);


        /*Merge sort*/
//        head = mergeSort(head);
//        print(head);


        /*Reverse linked list - O(n^2)*/
//        head = reverseR(head);
//        print(head);


        /*Reverse linked list - O(N)*/
//        DoubleNode ans = reverseBetter(head);
//        print(ans.head);


        /*Reverse linked list - O(n) - simple*/
//        head = reverseLLMuchBetter(head);
//        print(head);


        /*Reverse linked list iteratively*/
//        head = reverseIterative(head);
//        print(head);


        /*Insert recursively at position*/
//        head = insertR(head, 4, 15);
//        print(head);


        /*Delete recursively at position*/
        head = deleteR(head, 0);
        print(head);
    }
}
