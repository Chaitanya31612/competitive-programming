import java.io.*;
import java.util.*;

class SubsetSumList {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }
            Solution ob = new Solution();

            ArrayList<Integer> ans = ob.subsetSums(arr, N);
            for (int sum : ans) {
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends

// User function Template for Java//User function Template for Java
class Solution {

    static void solve(ArrayList<Integer> temp, ArrayList<Integer> arr, int l, int r, int sum) {
        if (l > r) {
            temp.add(sum);
            return;
        }
        solve(temp, arr, l+1, r, (sum + arr.get(l)));
        solve(temp, arr, l + 1, r, (sum));
    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        // code here
        ArrayList<Integer> temp = new ArrayList<>();
        solve(temp, arr, 0, N - 1, 0);
        Collections.sort(temp);
        return temp;
    }
}