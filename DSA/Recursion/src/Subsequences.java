import java.util.Arrays;

public class Subsequences {

    public static String[] findSubsequences(String str) {
        if(str.length() == 0) {
            return new String[]{""};
        }

        String[] smallAns = findSubsequences(str.substring(1));
        String[] ans = new String[2 * smallAns.length];

        // copy into ans
        for(int i = 0; i < smallAns.length; i++) {
            ans[i] = smallAns[i];
            ans[smallAns.length + i] = str.charAt(0) + smallAns[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findSubsequences("xyz")));
    }
}
