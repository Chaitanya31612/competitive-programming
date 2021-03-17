package easy;

import java.util.Scanner;

public class Football {

    public static void findSituation(String str) {
        int count0 = 0, count1 = 0;
        for(int i = 0; i < str.length(); i++) {
            if(count0 >= 7 || count1 >= 7) {
                System.out.println("YES");
                return;
            } else if(str.charAt(i) == '1') {
                count1++;
                count0 = 0;
            } else if(str.charAt(i) == '0') {
                count0++;
                count1 = 0;
            }
        }

        if(count0 >= 7 || count1 >= 7) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        findSituation(str);
    }
}
