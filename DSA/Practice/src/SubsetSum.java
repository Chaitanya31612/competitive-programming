import java.util.Scanner;
import java.util.Stack;

public class SubsetSum {
    static int[] arr;
    static int sum;
    static Stack<Integer> solutionSet;

    public static void subsetSum(int currSum, int idx) {
        if(currSum > sum) {
            return;
        }
        if(currSum == sum) {
            for(int e : solutionSet) {
                System.out.print(e + " ");
            }
            System.out.println();
            return;
        }

        for(int i = idx; i < arr.length; i++) {
            solutionSet.push(arr[i]);
            subsetSum(currSum + arr[i], i + 1);
            solutionSet.pop();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        sum = sc.nextInt();
        solutionSet = new Stack<>();
        subsetSum(0, 0);
    }
}
