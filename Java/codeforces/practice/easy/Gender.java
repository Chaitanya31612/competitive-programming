package easy;

import java.util.Scanner;

public class Gender {

    public static int countFreq(String str) {
        String s = "";

        for(int i = 0; i < str.length();i ++) {
            if(s.indexOf(str.substring(i, i+1)) == -1) {
                s = s + str.substring(i, i+1);
            }

        }
        return s.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int count = countFreq(str);
        if((count&1) == 1) {
            System.out.println("IGNORE HIM!");
        } else {
            System.out.println("CHAT WITH HER!");
        }
    }
}
