import java.util.*;

public class Stones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();

        int count = 0;
        for (int i = 0; i < str.length()-1; i++) {
            char s1 = str.charAt(i);
            char s2 = str.charAt(i+1);
            if (s1 == s2) {
                count++;
                s1 = s2;
            }
        }

        System.out.println(count);
    }
}
