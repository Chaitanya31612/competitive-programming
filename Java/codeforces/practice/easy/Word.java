package easy;

import java.util.Scanner;

public class Word {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int clower = 0, cupper = 0;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if((ch >= 'a') && (ch <= 'z')) {
                clower++;
            } else if((ch >= 'A') && (ch <= 'Z')) {
                cupper++;
            }
        }

        if(clower >= cupper) {
            str = str.toLowerCase();
        } else {
            str = str.toUpperCase();
        }

        System.out.println(str);
    }
}
