import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet {

    private void printSubsequences(String str, String output) {
        if(str.length() == 0) {
            System.out.println(output);
            return;
        }

        printSubsequences(str.substring(1), output);
        printSubsequences(str.substring(1), output + str.charAt(0));
    }

    public void printSubsequences(String str) {
        printSubsequences(str, "");
    }

    public List<String> subsequences(String str) {
        if(str.length() == 1) {
            List<String> ans = new ArrayList<>();
            ans.add("");
            ans.add(str);
            return ans;
        }

        List<String> smallAns = subsequences(str.substring(1));
        List<String> output = new ArrayList<>(2 * smallAns.size());
        for(int i = 0; i < 2*smallAns.size(); i++)
            output.add("");

        for(int i = 0; i < smallAns.size(); i++) {
            output.set(i, smallAns.get(i));
            output.set(smallAns.size() + i, str.charAt(0) + smallAns.get(i));
        }

        return output;
    }

    public static void main(String[] args) {
        PowerSet p = new PowerSet();
//        p.printSubsequences("abc");

        List<String> list = p.subsequences("abc");
        Collections.sort(list);
        list.remove(0);
        System.out.println(list);
    }
}
