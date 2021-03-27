//package easy;

import java.util.Scanner;

public class Dubstep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        str = str.replace("WUB", " ");
        str = str.replace("  ", " ");
        str = str.trim();
        System.out.println(str);
    }
}