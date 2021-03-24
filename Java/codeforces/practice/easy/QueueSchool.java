package easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class QueueSchool {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt();
        int t = sc.nextInt();

        sc.nextLine();
        String str = sc.nextLine();

        while(t-- > 0) {
            int ind = str.indexOf("BG");
            if (ind != -1) {
               str = str.replace("BG", "GB");
            } else {
                break;
            }
        }
        System.out.println(str);
        
    }
}
