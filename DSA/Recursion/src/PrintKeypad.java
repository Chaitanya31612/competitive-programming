import java.util.HashMap;

public class PrintKeypad {

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

    public static void printKeypad(int number, String output) {
        if(number == 0) {
            System.out.println(output);
            return;
        }

        String[] helpArr = helper(number%10);
        for(int i = 0; i < helpArr.length; i++) {
            printKeypad(number/10, helpArr[i] + output);
        }
    }

    public static void printKeypad(int num) {
        printKeypad(num, "");
    }

    public static void main(String[] args) {
        printKeypad(23);
    }
}
