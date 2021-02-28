import java.util.*;

public class Soldier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int w = sc.nextInt();

        int pay = k * w * (w + 1) / 2;
        if (pay > n) {
            System.out.println(pay-n);
        } else {
            System.out.println(0);
        }
    }
}