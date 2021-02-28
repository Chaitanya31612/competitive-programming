import java.util.*;


public class Coprime {

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            // int temp = l;

            int c = 2;
            // while (l <= r) {
            //     int k = l;
            //     if (gcd(c, k) == 1) {

            //         for (; k <= r; k++) {
            //             if (gcd(c, k) == 1) {
            //                 continue;
            //             } else {
            //                 c++;
            //                 break;
            //             }
            //         }
            //         if (k == r + 1) {
            //             System.out.println(c);
            //             break;
            //         } else {
            //             c++;
            //         }
            //     } else {
            //         c++;
            //     }
            // }
            
            while (l <= r) {
                int k = l;
                
                for (; k <= r; k++) {
                    if (gcd(c, k) == 1) {
                        continue;
                    } else {
                        break;
                    }
                }
                if (k == r + 1) {
                    System.out.println(c);
                    break;
                } else {
                    c++;
                }
            }
        }
    }
}
