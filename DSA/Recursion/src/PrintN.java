public class PrintN {

    public static void printn(int n) {
        if(n == 1) {
            System.out.print("1 ");
            return;
        }

        printn(n-1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        printn(64);
    }
}
