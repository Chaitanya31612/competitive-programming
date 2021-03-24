import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

class NextGreater2 {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            String[] inputLine = br.readLine().trim().split(" ");
            long[] arr = new long[n];
            for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
            long[] res = new Solution2().nextLargerElement(arr, n);
            for (int i = 0; i < n; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }
}


class Solution1{
    public static long[] nextLargerElement(long[] arr, int n) {
        // Your code here
        Stack<Long> stack = new Stack<>();

        long[] ans = new long[n];

        for(int i = 0; i < n; i++) {
            stack.push(arr[i]);
        }

        long finalMax = stack.peek();
        long max = stack.peek();
        ans[0] = -1;
        int j = 1;
        while(stack.size() > 1) {
            long temp = stack.pop();
            long secondLast = stack.peek();
            if(temp > secondLast) {
                if(temp > finalMax) {
                    finalMax = temp;
                }
                max = temp;
                ans[j++] = max;
            } else if(max > secondLast) {
                ans[j++] = max;
            } else {
                int k = n - j;
                boolean flag = false;
                while(k < n) {
                    if(arr[k] > secondLast) {
                        ans[j++] = arr[k];
                        flag = true;
                        break;
                    }
                    k++;
                }
                if(!flag && finalMax > secondLast) {
                    ans[j++] = finalMax;
                }
                // if(finalMax > secondLast) {
                //     ans[j++] = finalMax;
                // }
                else if(!flag && finalMax <= secondLast){
                    ans[j++] = -1;
                }
            }
        }

        for(int i = 0; i < n/2; i++) {
            long temp = ans[i];
            ans[i] = ans[n-i-1];
            ans[n-i-1] = temp;
        }

        return ans;
    }
}

class Solution2 {
    public static long[] nextLargerElement(long[] arr, int n) {
        // Your code here
        Stack<Long> stack = new Stack<>();

        HashMap<Long, Long> map = new HashMap<>();

        long[] ans = new long[n];
        int j = 0;
        stack.push(arr[0]);

        long element, next;
        for(int i = 1; i < n; i++) {
            next = arr[i];

            if(!stack.isEmpty()) {

                element = stack.pop();

                while(element < next) {

                    map.put(element, next);

                    if(stack.isEmpty()) {
                        break;
                    }
                    element = stack.pop();

                }

                if (element > next) {
                    stack.push(arr[i]);
                }
            }
            stack.push(next);
        }


        while(!stack.isEmpty()) {
            element = stack.pop();
            next = -1;
            map.put(element, next);
        }

//        for(int i = 0; i < n; i++) {
//            ans[i] = map.get(arr[i]);
//        }
//        System.out.println(map);

        return ans;
    }

    public long[] nge(long[] arr, int n) {
        Stack<Long> s = new Stack<>();
        long nge[] = new long[n];                   // Unordered Map to store all the result
        for (int i = n - 1; i >= 0; i--) {          // Run a loop in reverse order
            if (!s.empty()) {
                while (!s.empty() && s.peek() < arr[i]) { // If Peek element is less than curr element then it
                    s.pop();                              // can't be the next greater element, so pop it.
                }
            }
            nge[i] = s.empty() ? -1 : s.peek();   // If some element exist in stack then the top element is next
            s.push(arr[i]);                       // greater element. Push the current element to stack.
        }
        return nge;
    }
}