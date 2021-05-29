package practice;

import java.util.Scanner;

public class MinStepsToOne {

    public static int minSteps(int n) {
        if(n <= 1) {
            return 0;
        }

        int op1, op2, op3;
        op1 = op2 = op3 = Integer.MAX_VALUE;

        // n is even
        if((n&1) == 0) {
            op1 = 1 + minSteps(n / 2);
        }
        if(n % 3 == 0) {
            op2 = 1 + minSteps(n / 3);
        }

        op3 = 1 + minSteps(n - 1);

        return Math.min(op1, Math.min(op2, op3));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // operations - n/2 , n/3, n-1
        System.out.println(minSteps(n));
    }
}
