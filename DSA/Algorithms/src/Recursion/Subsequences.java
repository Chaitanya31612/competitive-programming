package Recursion;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public class Subsequences {

    // Return Subsequences
//    public String[] subsequences(String str) {
//        String[] output = new String[(int)Math.pow(2, str.length())];
//        return subsequences(str, output);
//    }

    public String[] subsequences(String str) {
        if(str.length() == 1) {
            return new String[]{"", str};
        }

        String[] smallAns = subsequences(str.substring(1));
        String[] output = new String[2 * smallAns.length];

        for(int i = 0; i < smallAns.length; i++) {
            output[i] = smallAns[i];
            output[smallAns.length + i]  = str.charAt(0) + smallAns[i];
        }

        return output;
    }

    private void printSubsequences(String str, String output) {
        if(str.length() == 0) {
            System.out.println(output);
            return;
        }

        printSubsequences(str.substring(1), output);
        printSubsequences(str.substring(1), output + str.charAt(0));
    }

    public void printSubsequences(@NotNull String str) {
        printSubsequences(str, "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Subsequences s = new Subsequences();
//        str = null;
//        assert str != null;
        s.printSubsequences(str);
        String[] ans = s.subsequences(str);
        System.out.println(Arrays.toString(ans));
    }
}
