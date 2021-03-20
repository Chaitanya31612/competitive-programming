package stack_array;

import java.util.HashMap;
import java.util.Stack;

public class BracketsBalancing {

    public static HashMap<Character, Character> getTable() {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');

        return map;
    }

    public static boolean checkBalancing(String str) {
        Stack<Character> stack = new Stack<>();

        HashMap<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(map.containsKey(ch)) {
                stack.push(ch);
            } else {
                if(stack.size() > 0 && map.get(stack.peek()) == ch) {
                    stack.pop();
                } else {
                    return false;
                }
            }

        }

        if(stack.size() == 0) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        String str = "{(})";

        System.out.println(checkBalancing(str));
    }
}
