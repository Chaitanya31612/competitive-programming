package contest708;

import java.util.*;

public class B3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Long> list = new ArrayList<>(n);
            for(int i = 0; i < n; i++) {
                list.add(sc.nextLong());
            }

//            int[] set = new int[m];
//            for(int i = 0; i < m; i++) {
//                set[i] = i;
//            }
            for(int i = 0; i < n; i++) {
                list.set(i, list.get(i) % m);
            }

//            System.out.println(list);

            HashMap<Long, Integer> map = new HashMap<>();
            for(long i = 0; i < m; i++) {
                map.put(i, 0);
            }
//            System.out.println(map);
            for(int i = 0; i < n; i++) {
                if(!map.containsKey(list.get(i))) {
                    map.put(list.get(i), 1);
                } else {
                    map.put(list.get(i), map.get(list.get(i)) + 1);
                }
            }
//            System.out.println(map);
            int count = 0;
            if(map.get((long)(0)) >= 1) {
                count++;
            }
            for(long i = 1; i < m; i++) {
                if(map.get(i) >= 1) {
                    if(Math.abs(map.get(i) - map.get((long)m-i)) <= 1) {
                        count++;
                    } else {
                        count += Math.abs(map.get(i) - map.get((long)m-i));
                    }
                    map.put((long)m - i, 0);
                }
            }
            System.out.println(count);
        }
    }
}
