import java.util.*;

public class CuttingRecipes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int k = findGCD(a, n);
            System.out.println(k);
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] / k + " ");
            }
            System.out.println();
        }
    }
    
    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // Function to find gcd of array of
    // numbers
    static int findGCD(int arr[], int n) {
        int result = 0;
        for (int element : arr) {
            result = gcd(result, element);

            if (result == 1) {
                return 1;
            }
        }

        return result;
    }
}
