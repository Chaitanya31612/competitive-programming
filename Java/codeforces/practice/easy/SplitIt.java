package easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SplitIt {

    public static boolean palindrome(String s1, String s2) {

        if(s1.length() != s2.length()) {
            return false;
        }

        int n = s1.length();
        for(int i = 0; i < n; i++) {
            if(s1.charAt(i) != s2.charAt(n-i-1)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();

            if(2*k == n) {
                System.out.println("NO");
            } else {
                String ak = s.substring(0, k);
                String nk = s.substring(n-k);
                if(palindrome(ak, nk)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }

            }

        }
    }
}
