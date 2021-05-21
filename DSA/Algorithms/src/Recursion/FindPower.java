package Recursion;

import java.util.Scanner;

public class FindPower {

    // find a^b
    // O(b)
    public int findPower(int a, int b) {
        if(b == 1) {
            return a;
        }

        return a * findPower(a, b - 1);
    }

    // O(logb)
    public int fastPower(int a, int b) {
        if(b == 1) {
            return a;
        }

        // even
        if((b&1) == 0) {
            int x = fastPower(a, b / 2);
            return x * x;
        } else {
            // this will work atmost 1 time - when b is odd
            return a * fastPower(a, b -1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        FindPower f = new FindPower();
        System.out.println(f.findPower(a, b));
        System.out.println(f.fastPower(a, b));
    }
}
