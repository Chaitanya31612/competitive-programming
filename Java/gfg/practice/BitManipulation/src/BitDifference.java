public class BitDifference {
    public static void main(String[] args) {
        int a = 10, b = 20;

        int val = a^b;
        System.out.println(val);
        int count = 1;

        while((val&(val-1)) != 0) {
            val = (val&(val-1));
            count++;
        }

        System.out.println(count);
    }
}
