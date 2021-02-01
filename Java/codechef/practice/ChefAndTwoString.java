import java.util.*;

public class ChefAndTwoString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String S1 = sc.next();
            String S2 = sc.next();

            int min = 0, max = 0;
            for (int i = 0; i < S1.length(); i++) {
                char s1 = S1.charAt(i);
                char s2 = S2.charAt(i);

                if (s1 == '?' || s2 == '?') {
                    max++;
                } else {
                    if (s1 != s2) {
                        min++;
                        max++;
                    }
                }
            }

            System.out.println(min + " " + max);
        }
    }
}
