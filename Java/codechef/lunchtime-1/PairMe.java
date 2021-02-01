import java.util.*;

public class PairMe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for (int i = 0; i < a; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            if(x == (y + z) ||
                y == (x + z) ||
                z == (x + y)) 
            {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}