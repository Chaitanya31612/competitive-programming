import java.util.HashMap;
import java.util.Stack;

public class ValidSubstring {

    public static int findMaxLen(String S) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        int count = 0;
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if(map.containsKey(ch)) {
                stack.push(ch);
            } else {
                if(!stack.isEmpty() && map.get(stack.peek()) == ch) {
                    count += 2;
                    stack.pop();
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String S = "((())(";

        System.out.println(findMaxLen(S));
    }
}
