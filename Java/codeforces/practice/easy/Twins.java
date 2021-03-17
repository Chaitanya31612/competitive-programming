package easy;

import java.util.*;

public class Twins {

//    public static int findMinCoin(int[] arr) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int mincoins = 0;
//
//        for(int i = 0; i < arr.length; i++) {
//            if(!map.containsKey(arr[i])) {
//                map.put(arr[i], 0);
//            } else {
//                map.put(arr[i], map.get(arr[i]) + 1);
//            }
//        }
//
//        Iterator mapIterator = map.entrySet().iterator();
//
//        while (mapIterator.hasNext()) {
//            Map.Entry mapElement = (Map.Entry)mapIterator.next();
//            if((int)mapElement.getValue() % 2 != 0) {
//                mincoins++;
//            }
//        }
//        return mincoins;
//    }

    public static int sum(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
            sum += arr[i];


        return sum;
    }

    public static int findMinCoin(int[] arr) {
        int total = sum(arr);
        int half = total / 2;
        int coinCount = 0, valCount = 0;
        if(total == 0)
            return 0;

        Arrays.sort(arr);
        for(int i = arr.length - 1; i >= 0; i--) {
            if(valCount > half) {
                return coinCount;
            } else {
                valCount += arr[i];
                coinCount++;
            }
        }

        return coinCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int minCoin = findMinCoin(arr);
        System.out.println(minCoin);
    }
}
