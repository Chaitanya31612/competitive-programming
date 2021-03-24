package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Presents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            map.put(a, i);
        }

        TreeMap<Integer, Integer> sorted = new TreeMap<>();
        sorted.putAll(map);

        for(Map.Entry<Integer, Integer> entry : sorted.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }

    }
}
