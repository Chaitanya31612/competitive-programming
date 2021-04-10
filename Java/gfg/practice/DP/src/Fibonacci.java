import java.util.Scanner;

public class Fibonacci {

    public static long nthFibonacci(long n){
        // code here
        if(n == 0 || n == 1) {
            return n;
        }

        int a = 0;
        int b = 1;
        int c = 1;
        for(int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();


    }
}
