import java.util.HashMap;
import java.util.Set;

public class MapUse {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // insertion
        map.put("abc", 1);
        map.put("def", 2);

        // contains
        if(map.containsKey("abc")) {
            System.out.println("contains abc");
        }

        if(map.containsValue(2)) {
            System.out.println("contains 2");
        }

        // deletion
        map.remove("abc");

        // size
        System.out.println(map.size());

        // get value
        /*
        Now this will give null pointer exception as abc is deleted and get method returns null
        */
//        int v = map.get("abc");
//        System.out.println(v);

        // traverse
        // unordered list
        Set<String> keys = map.keySet();
        for(String str : keys) {
            System.out.println(str);
        }
    }
}
