
// { Driver Code Starts
import java.util.Scanner;
import java.util.*;

class MaxDisOccur {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            GfG g = new GfG();
            System.out.println(g.maxDistance(arr, n));

            t--;
        }
    }
}// } Driver Code Ends

// your task is to complete this function
class GfG {
    int maxDistance(int arr[], int n) {
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<>();

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
            } else {
                max = Math.max(max, i - map.get(arr[i]));
            }
        }
        return max;
    }
}
