import java.util.HashMap;
import java.util.Scanner;

public class CountPairs {

    public static int countPairsBrute(int[] arr, int n, int k) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] + arr[j] == k)
                    count++;
            }
        }

        return count;
    }

    public static int countPairs(int[] arr, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
                continue;
            }
            map.put(arr[i], map.get(arr[i]) + 1);
        }
        int twice_count = 0;

//        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
//            while (entry.getValue() > 0) {
//                int comp = k - entry.getKey();
//                if(map.containsKey(comp) && map.get(comp) > 0) {
//                    map.put(comp, map.get(comp) - 1);
//                    map.put(entry.getKey(), entry.getValue() - 1);
//                    count++;
//                } else {
//                    break;
//                }
//            }
//        }

        for(int i = 0; i < n; i++) {
            if(map.containsKey(k - arr[i])) {
                twice_count += map.get(k - arr[i]);

                // they form one single pair
                if(arr[i] == k - arr[i]) {
                    twice_count--;
                }
            }
        }

        return twice_count / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int ans = countPairs(arr, n, k);
        System.out.println(ans);
    }
}
