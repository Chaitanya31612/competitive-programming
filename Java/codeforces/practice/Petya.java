import java.util.*;

public class Petya {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = (sc.nextLine()).toLowerCase();
        String s2 = (sc.nextLine()).toLowerCase();

        int sum1 = 0, sum2 = 0, i = 0;
        for (; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 == c2) {
                continue;
            } else {
                sum1 += c1;
                sum2 += c2;
                if (sum1 < sum2) {
                    System.out.println(-1);
                    break;
                } else if (sum1 > sum2) {
                    System.out.println(1);
                    break;
                }
            }
        }

        if (i == s1.length()) {
            System.out.println(0);
        }
        // if (sum1 == sum2) {
        //     System.out.println(0);
        // } else if (sum1 < sum2) {
        //     System.out.println(-1);
        // } else if (sum2 < sum1) {
        //     System.out.println(1);
        // }
    }
}