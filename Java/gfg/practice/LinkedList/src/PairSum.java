public class PairSum {

    static void pairSum( DoubleNode head, int x)
    {
        // Set two pointers, first
        // to the beginning of DLL
        // and second to the end of DLL.
        DoubleNode first = head;
        DoubleNode second = head;
        while (second.next != null)
            second = second.next;

        // To track if we find a pair or not
        boolean found = false;

        // The loop terminates when either
        // of two pointers become null, or
        // they cross each other (second.next
        // == first), or they become same
        // (first == second)
        while (first != null && second != null &&
                first != second && second.next != first)
        {
            // pair found
            if ((first.data + second.data) == x)
            {
                found = true;
                System.out.println( "(" + first.data +
                        ", "+ second.data + ")" );

                // move first in forward direction
                first = first.next;

                // move second in backward direction
                second = second.prev;
            }
            else
            {
                if ((first.data + second.data) < x)
                    first = first.next;
                else
                    second = second.prev;
            }
        }

        // if pair is not present
        if (found == false)
            System.out.println("No pair found");
    }

    public static void main(String[] args) {
        
    }
}
