package WarmUp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Lapindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0) {
            String str = sc.nextLine();
            String s1, s2;
            int len = str.length();
            if((len & 1) == 0) {
                s1 = str.substring(0, len / 2);
                s2 = str.substring(len / 2);
            } else {
                s1 = str.substring(0, (len-1)/2);
                s2 = str.substring(len/2 + 1);
            }

//            System.out.println(s1);
//            System.out.println(s2);

            // 1st option - sort the strings
            char[] temp1 = s1.toCharArray(), temp2 = s2.toCharArray();
            Arrays.sort(temp1);
            Arrays.sort(temp2);
//            System.out.println(String.valueOf(temp1));
//            System.out.println(String.valueOf(temp2));

            if(String.valueOf(temp1).equals(String.valueOf(temp2))) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            // 2nd option
            HashSet<Character> set1 = new HashSet<>();
            for(int i = 0; i < s1.length(); i++) {
                set1.add(s1.charAt(i));
            }
            HashSet<Character> set2 = new HashSet<>();
            for(int i = 0; i < s1.length(); i++) {
                set2.add(s1.charAt(i));
            }
            System.out.println(set1);
            System.out.println(set2);
            System.out.println(set1.equals(set2));
        }
    }
}
