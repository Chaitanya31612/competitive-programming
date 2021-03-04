import java.util.HashMap;
import java.util.Map;

public class DuplicateCount {

    static void duplArr(String str) {
        int[] arr = new int[256];
        for(int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)]++;
        }

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 1) {
                System.out.println((char)(i) +
                        ", count = " + arr[i]);
            }
        }
    }

    static void duplHash(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < str.length(); i++) {
            if(!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
            } else {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }
        }

        for (Map.Entry mapElement : map.entrySet()) {
            char key = (char)mapElement.getKey();
            int value = ((int)mapElement.getValue());

            if (value > 1)
                System.out.println(key
                        + ", count = " + value);
        }

    }

    public static void main(String[] args) {
        String str = "test string";
        duplArr(str);
        duplHash(str);
    }
}
