import java.util.ArrayList;
import java.util.Collections;

public class FactorialLarge {

    public static ArrayList<Integer> factorialLarge(int n) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);

        for(int x = 2; x <= n; x++) {
            multiply(list, x);
        }

        Collections.reverse(list);
        return list;
    }

    public static void multiply(ArrayList<Integer> list, int x) {
        int carry = 0;
        for(int i = 0; i < list.size(); i++) {
            int prod = list.get(i) * x + carry;
            list.set(i, prod % 10);

            carry = prod / 10;
        }
        if(carry != 0) {
            list.add(carry);
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while(t-- > 0) {
//            int n = sc.nextInt();
//
//        }


    }
}
