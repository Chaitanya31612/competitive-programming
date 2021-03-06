import java.util.Scanner;

public class GcdArray {
    static int m = 1000000007;

    static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // Function to find gcd of array of
    // numbers
    static long findGCD(long arr[], int n)
    {
        long result = arr[0];
        for (int i = 1; i < n; i++)
            result = gcd(arr[i], result);

        return result % m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        long[] arr = new long[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        while(q-- > 0) {
            int indx = sc.nextInt();
            int x = sc.nextInt();

            arr[indx-1] = (arr[indx - 1] * x) % m;

            long gcd = findGCD(arr, n) % m;

            System.out.println(gcd);
        }
    }
}
