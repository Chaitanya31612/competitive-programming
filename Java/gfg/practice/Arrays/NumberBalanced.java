import java.util.*;

public class NumberBalanced {
    public static void main(String[] args) {
        String N = "1234006";
        int s1 = 0, s2 = 0;
        int i = 0;
        for (; i < N.length() / 2; i++) {
            s1 += Integer.parseInt(N.substring(i, i + 1));
        }
        i++;
        for (; i < N.length(); i++) {
            s2 += Integer.parseInt(N.substring(i, i + 1));
        }

        if (s1 == s2) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
