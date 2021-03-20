package pastpractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Plates {

    public static int maxArray(int[] arr) {
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int findMax(List<Stack<Integer>> stackList) {
        int max = Integer.MIN_VALUE;
        int indx = -1;
//        int[] temp = new int[stackList.size()];
        for(int i = 0; i < stackList.size(); i++) {
            if(!stackList.get(i).isEmpty() && stackList.get(i).peek() > max) {
                max = stackList.get(i).peek();
                indx = i;
            }
//            temp[i] = stackList.get(i).peek();
        }

//        int max = maxArray(temp);
//        for(int i = 0; i < stackList.size(); i++) {
//            if(stackList.get(i).peek() == max) {
//                stackList.get(i).pop();
//            }
//        }
        stackList.get(indx).pop();
        return max;
    }

    public static void main(String[] args) {
//        List<Stack<Integer>> cards = new ArrayList<Stack<Integer>>();
//
//        Stack<Integer> elem = new Stack<>();
//        elem.push(10);
//        elem.push(10);
//        elem.push(100);
//        elem.push(30);
//
//        cards.add(elem);
//
//        elem.pop();
//        System.out.println(cards.get(0));


        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int tt = 1; tt <= t; ++tt) {
            int n = in.nextInt();
            int k = in.nextInt();
            int p = in.nextInt();

            List<Stack<Integer>> stackList = new ArrayList<Stack<Integer>>();

            for(int i = 0; i < n; i++) {
                Stack<Integer> stack = new Stack<>();
                int[] temp = new int[k];
                for(int j = 0; j < k; j++) {
                    temp[j] = in.nextInt();
                }
                for(int j = temp.length-1; j>=0; j--) {
                    stack.push(temp[j]);
                }
                stackList.add(stack);
            }

            int sum = 0, count = 0;
//            while (count <= p) {
//                for(int i = 0; i < stackList.get(i).size() && (i+1 <= p); i++) {
//                    sum = sum + findMax(stackList);
//                }
//            }

            while(count < p) {
                sum = sum + findMax(stackList);
                count++;
            }
//            System.out.println(stackList);
//            System.out.println(sum);

//            System.out.println(findMax(stackList));
//            System.out.println(stackList);
            System.out.println("Case #" + tt + ": " + sum);
        }

    }
}
