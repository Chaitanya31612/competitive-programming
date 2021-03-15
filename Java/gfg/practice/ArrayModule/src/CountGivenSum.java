import java.util.HashMap;
import java.util.Scanner;

public class CountGivenSum {

    public static HashMap<Integer, Integer> getCounts(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        return map;
    }

    public static int getPairsCount(int[] arr, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map = getCounts(arr);
        int sum = 0, cursum = 0;

        // pending
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int ans = getPairsCount(arr, n, k);
        System.out.println(ans);
    }
}
