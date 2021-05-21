package Recursion;

import java.util.Scanner;

public class StringToInt {

    // Convert string number like "1234" to 1234 using recursion
    public int stringToInt(String str) {
        if(str.length() == 1) {
            return Integer.parseInt(str);
        }

        return (Character.getNumericValue(str.charAt(0)) * (int)Math.pow(10, (str.length() - 1))) + stringToInt(str.substring(1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        StringToInt s = new StringToInt();
        System.out.println(s.stringToInt(str));
    }
}
