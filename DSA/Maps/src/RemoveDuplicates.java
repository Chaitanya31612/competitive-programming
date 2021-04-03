import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class RemoveDuplicates {

    public static ArrayList<Integer> removeDuplicatesSet(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int j : arr) {
            if (set.contains(j)) {
                continue;
            }
            set.add(j);
            list.add(j);
        }

        return list;
    }

    public static ArrayList<Integer> removeDuplicates(int[] arr) {
        // use hashmap as a checklist. i.e hashmap will be
        HashMap<Integer, Boolean> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int j : arr) {
            if (map.containsKey(j)) {
                continue;
            }
            map.put(j, true);
            list.add(j);
        }

        return list;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 1, 2, 1, 2, 3, 5, 7, 90};

        System.out.println(removeDuplicates(arr));
        System.out.println(removeDuplicatesSet(arr));

        System.out.println(arr);
        System.out.println(Arrays.hashCode(arr));

    }
}
