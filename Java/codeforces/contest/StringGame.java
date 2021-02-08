import java.util.*;

public class StringGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String str = sc.nextLine();
            String ans = "";

            int len = str.length();
            if (len == 1) {
                if (str.charAt(0) == 'a') {
                    ans = "b";
                } else {
                    ans = "a";
                }
            } else {
                char[] A = new char[26];
                A[0] = 'a';
                for (int i = 1; i < 26; i++) {
                    A[i] = (char) (A[i - 1] + (char) 1);
                }
                int c = 0;
                for (int i = 0; i < len; i++) {
                    char s = str.charAt(i);

                    if (c % 2 == 0) {
                        // alice
                        int alice = 0;
                        if (s == 'a' && (alice == 0)) {
                            ans += "b";
                            alice = 2;
                        } else {
                            ans += A[alice++];
                        }
                    } else {
                        // bob
                        int bob = 25;
                        if (s == 'z' && (bob == 25)) {
                            ans += "y";
                            bob = 2;
                        } else {
                            ans += A[bob--];
                        }
                    }
                    c++;
                }
            }

            System.out.println(ans);
        }
    }
}
