public class Multiply {

    public static long multiply(Node l1, Node l2) {
        long m = 1000000007;
        long first = 0, second = 0;
        while(l1 != null) {
            first = ((first * 10) % m + l1.data) % m;
            l1 = l1.next;
        }

        while(l2 != null) {
            second = ((second * 10) % m + l2.data) % m;
            l2 = l2.next;
        }

        return ((first % m) * (second % m)) % m;
    }

    public static void main(String[] args) {
        Node l1 = Node.takeInput();
        Node l2 = Node.takeInput();

        System.out.println(multiply(l1, l2));
    }
}
