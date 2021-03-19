public class MergeSort {

    public static Node mergeSorted(Node A, Node B) {
        if(A == null) return B;
        if(B == null) return A;

        if(A.data < B.data) {
            A.next = mergeSorted(A.next, B);
            return A;
        } else {
            B.next = mergeSorted(A, B.next);
            return B;
        }
    }

    public static Node mergeSort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node mid = Node.middle(head);
        Node nextMid = mid.next;
        mid.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextMid);
        Node sorted = mergeSorted(left, right);

        return sorted;
    }

    public static void main(String[] args) {
        Node head = Node.takeInput();

        head = mergeSort(head);
        Node.print(head);
    }
}
