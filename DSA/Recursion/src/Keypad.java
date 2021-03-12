import java.util.Arrays;
import java.util.HashMap;

public class Keypad {

    public static String[] helper(int n) {
        HashMap<Integer, String[]> map = new HashMap<>();
        map.put(2, new String[]{"a", "b", "c"});
        map.put(3, new String[]{"d", "e", "f"});
        map.put(4, new String[]{"g", "h", "i"});
        map.put(5, new String[]{"j", "k", "l"});
        map.put(6, new String[]{"m", "n", "o"});
        map.put(7, new String[]{"p", "q", "r", "s"});
        map.put(8, new String[]{"t", "u", "v"});
        map.put(9, new String[]{"w", "x", "y", "z"});

        return map.get(n);
    }

    public static String[] returnKeypad(int number) {
        if(number == 0) {
            return new String[]{""};
        }

        String[] smallAns = returnKeypad(number/10);

        String[] helpArr = helper(number % 10);
        int k = 0;
        String[] ans = new String[smallAns.length * helpArr.length];
        for(int i = 0; i < smallAns.length; i++) {
            for(int j = 0; j < helpArr.length; j++) {
                ans[k++] = smallAns[i] + helpArr[j];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] arr = returnKeypad(234);
        System.out.println(Arrays.toString(arr));
    }
}
