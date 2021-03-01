// import java.util.*;

// public class MinimiseSumProduct {
//     public static void main(String[] args) {
//         Integer[] a = new Integer[] { 3, 1, 1 };
//         Integer[] b = new Integer[] { 6, 5, 4 };

//         Arrays.sort(a);
//         Arrays.sort(b, Collections.reverseOrder());

//         int sum = 0;
//         for (int i = 0; i < a.length; i++) {
//             sum += a[i] * b[i];
//         }

//         System.out.println(sum);
//     }
// }


// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class MinimiseSumProduct {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int) (n)];
            long b[] = new long[(int) (n)];

            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                b[i] = Long.parseLong(inputLine1[i]);
            }

            Compute obj = new Compute();
            System.out.println(obj.minValue(a, b, n));
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Compute {

    public long minValue(long a[], long b[], long n) {
        // Your code goes here
        Long[] a1 = new Long[(int) n];
        Long[] b1 = new Long[(int) n];

        for (int i = 0; i < n; i++) {
            a1[i] = a[i];
            b1[i] = b[i];
        }

        Arrays.sort(a1);
        Arrays.sort(b1, Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a1[i] * b1[i];
        }

        return sum;
    }
}