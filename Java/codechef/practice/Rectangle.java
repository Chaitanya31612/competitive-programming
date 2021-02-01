import java.util.*;

public class Rectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            if (check(a, b, c, d)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    
    static boolean check(int a, int b, int c, int d) {
        if (a == b && a == c && a == d && c == d && b == c && b == d) {
            return true;
        } else if (a == b && c == d) {
            return true;
        } else if (a == c && b == d) {
            return true;
        } else if (a == d && c == b) {
            return true;
        } else {
            return false;
        }
    }
}
