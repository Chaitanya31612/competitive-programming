import java.util.*;
import java.util.regex.Pattern;

public class HelpMath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        String[] arr = inp.split(Pattern.quote("+"));

        Arrays.sort(arr);
        String ans = "";
        for (int i = 0; i < arr.length; i++) {
            ans += arr[i];
            if (i < arr.length - 1) {
                ans += "+";
            }
        }
        System.out.println(ans);
    }
}
