package lunchtimemarch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Motivation {
    public static HashMap<Long, Long> sortByValue(HashMap<Long, Long> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Long, Long> > list =
                new LinkedList<Map.Entry<Long, Long> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Long, Long> >() {
            public int compare(Map.Entry<Long, Long> o1,
                               Map.Entry<Long, Long> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Long, Long> temp = new LinkedHashMap<Long, Long>();
        for (Map.Entry<Long, Long> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = sc.nextInt();
        while(t-- > 0) {
            long n = sc.nextLong();
            long x = sc.nextLong();

            HashMap<Long, Long> map = new HashMap<>();
            for(int it = 0; it < n; it++) {
                long s = sc.nextLong();
                long r = sc.nextLong();
                if(s <= x) {
                    map.put(s, r);
                }
            }

            map = sortByValue(map);
//            System.out.println(map);
//            System.out.println(map2);


            long ans = 0;
            for (Map.Entry<Long, Long> en : map.entrySet()) {
                if(x - en.getKey() >= 0) {
                    ans = en.getValue();
                    break;
                }
            }

            System.out.println(ans);
        }
    }
}
