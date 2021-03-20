import java.util.Arrays;
import java.util.Stack;

public class SortStack {

    public static void sortedInsert(int data, Stack<Integer> s) {
        if(s.isEmpty() || s.peek() < data) {
            s.push(data);
        } else {
            int temp = s.pop();
            sortedInsert(data, s);
            s.push(temp);
        }
    }

    public static Stack<Integer> sortR(Stack<Integer> s) {
        if(!s.isEmpty()) {
            int temp = s.pop();
            sortR(s);
            sortedInsert(temp, s);
        }
        return s;
    }

    public static Stack<Integer> sort(Stack<Integer> s) {
        Object temp[] = s.toArray();
        Arrays.sort(temp);
//        System.out.println(Arrays.toString(temp));

        s.clear();
        for(int i = 0; i < temp.length; i++) {
            s.push((Integer) temp[i]);
        }

        return s;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = StackClass.takeInput();

//        stack = sort(stack);

        stack = sortR(stack);
        StackClass.print(stack);

    }
}
