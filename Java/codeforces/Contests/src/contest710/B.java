package contest710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();

            int count = 0;

            int first = str.indexOf("*");
            int last = str.lastIndexOf("*");

            if(first == last) {
                count = 1;
            } else {
                count = 2;
            }

            int newFirst = first;


            while(newFirst + k < last) {
                for (int i = newFirst + k; i > newFirst; i--) {
                    if(str.charAt(i) == '*') {
                        count++;
                        newFirst = i;
                        break;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
