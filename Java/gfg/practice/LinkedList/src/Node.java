import java.util.Scanner;

public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public static Node takeInput() {
        Node head = null;
        Node currentNode = head;
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        // -1 terminating condition
        while(data != -1) {
            Node newNode = new Node(data);

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

    public static void print(Node head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node getTail(Node head) {
        while(head.next != null) {
            head = head.next;
        }
        return head;
    }

    public static Node middle(Node head) {
        /*
         * two approaches
         * 1. find length of list and again iterate to find middle - can be done efficiently though
         * 2. use slow and fast approach -> fast -> last , slow -> middle. fast = 2 times speed of slow
         * */

        Node slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node insert(Node head, int data, int pos) {
        Node newNode = new Node(data);
        if(pos == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        int i = 0;
        Node temp = head;

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
    public static Node insertR(Node head, int pos, int elem) {
        // insert at front of the list
        if(pos == 0 || head == null) {
            Node newNode = new Node(elem);
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


    public static void delete(Node head, int pos) {
        Node temp = head;
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
    public static Node deleteR(Node head, int pos) {
        if(pos == 0) {
            return head.next;
        }
        if(head == null) {
            return head;
        }

        head.next = deleteR(head.next, pos - 1);

        return head;
    }


    public static Node reverseLLMuchBetter(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        // head.next contains pointer to last node of sorted linked list
        Node reversedTail = head.next;
        Node finalSorted = reverseLLMuchBetter(head.next);
        reversedTail.next = head;
        head.next = null;

        return finalSorted;
    }


    public static Node reverseIterative(Node head) {
        Node prev = null, curr = head, nex;
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

    public static Node mergeSortedLists(Node A, Node B) {
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

    public static Node mergeSort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        // find middle node and make it separate from right list but store reference of right list
        Node mid = middle(head);
        Node nextMiddle = mid.next;
        mid.next = null;

        Node left = mergeSort(head);
        Node right =  mergeSort(nextMiddle);
        Node sorted = mergeSortedLists(left, right);
        return sorted;
    }

    public static int getCount(Node head) {
        int count = 0;
        while(head != null) {
            head = head.next;
            count++;
        }

        return count;
    }
}
