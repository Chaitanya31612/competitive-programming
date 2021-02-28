import java.util.*;

public class Palpal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a'] += 1;
            }
            int pair = 0, left = 0;
            for (int i = 0; i < 26; i++) {
                pair += freq[i] / 2;
                left += freq[i] % 2;
            }

            if (pair >= left) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
