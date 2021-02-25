import java.lang.reflect.Array;
import java.util.*;

class Priority {
    int id;
    int value;
    
    public Priority(int id, int value) {
        this.id=id;
        this.value = value;
    }
}

public class ChefAndPatients2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            List<Priority> P = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int value = sc.nextInt();
                Priority val = new Priority(i, value);
                P.add(val);
            }

            Collections.sort(P, new Comparator<Priority>() {
                public int compare(Priority p1, Priority p2) {
                    if (p1.value == p2.value) {
                        return p1.value - p2.value;
                    } else {
                        return p2.value - p1.value;
                    }
                }
            });
            // for (int i = 0; i < P.size(); i++) {
            //     System.out.println(P.get(i).value + " " +P.get(i).id);
            // }

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(P.get(i).id, i + 1);
            }

            for (int i = 0; i < n; i++) {
                System.out.print(map.get(i) + " ");
            }
            System.out.println();
        }
    }
}
