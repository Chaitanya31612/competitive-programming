import java.util.HashMap;
import java.util.Scanner;

public class CountAndSay {

    static HashMap<Integer, String> map;

    public void fillMap() {
        map = new HashMap<>();
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
    }

    public String sayNumber(String s) {
        String ans = "";

        for(int i = 0; i < s.length(); i++) {
            int count = 0;
            char num = s.charAt(i);
            while(i < s.length() && s.charAt(i) == num) {
                count++;
                i++;
            }
            i--;

            ans += "" + count + num;
        }

        return ans;
    }

    public String countAndSay(int n) {
        if(n == 1)
            return "1";

        String ans = "1";
        for(int i = 1; i < n; i++) {
            ans = sayNumber(ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        CountAndSay c = new CountAndSay();
        System.out.println(c.countAndSay(n));
    }
}
