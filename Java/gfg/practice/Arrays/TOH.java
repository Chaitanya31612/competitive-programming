import java.io.*;
import java.util.*;

class TOH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();// total testcases
        while (T-- > 0) {
            Hanoi obj = new Hanoi();
            int N;

            // taking input N
            N = sc.nextInt();

            // calling toh() method
            System.out.println(obj.toh(N, 1, 3, 2));
        }
    }
}


class Hanoi {
    
    // static int count = 0;

    public long toh(int N, int from, int to, int aux) {
        // Your code here

        // count++;
        if (N == 1) {
            System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
            return 1;
        } else {
            toh(N - 1, 1, 2, 3);
            System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
            toh(N - 1, 2, 3, 1);
            return (long) (Math.pow(2, N) - 1);
        }
    }
}
