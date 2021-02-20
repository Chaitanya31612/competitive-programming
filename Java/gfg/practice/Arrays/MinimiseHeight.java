import java.util.*;

class Solution {
    class Pair {
        private int value;
        private int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return this.value;
        }

        public int getIndex() {
            return this.index;
        }
    }


    public int getMinDiff(int[] arr, int n, int k) {
        ArrayList<Pair> possibleHeights = new ArrayList<>();
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] - k >= 0) {
                possibleHeights.add(new Pair(arr[i] - k, i));
            }
            possibleHeights.add(new Pair(arr[i] + k, i));
            visited[i] = 0;
        }
        Collections.sort(possibleHeights, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2) {
                return p1.getValue() - p2.getValue();
            }
        });

        int ele = 0, left = 0, right = 0, size = possibleHeights.size();
        while (ele < n && right < size) {
            if (visited[possibleHeights.get(right).getIndex()] == 0) {
                ele++;
            }
            visited[possibleHeights.get(right).getIndex()]++;
            right++;
        }
        int ans = possibleHeights.get(right - 1).getValue() - possibleHeights.get(left).getValue();

        while (right < size) {
            // slide window
            if (visited[possibleHeights.get(left).getIndex()] == 1) { // if only 1 element is left then decrement the ele
                ele--;
            }
            visited[possibleHeights.get(left).getIndex()]--;
            left++;

            while (ele < n && right < size) {
                if (visited[possibleHeights.get(right).getIndex()] == 0) {
                    ele++;
                }
                visited[possibleHeights.get(right).getIndex()]++;
                right++;
            }

            if (ele == n) {
                ans = Math.min(ans, possibleHeights.get(right - 1).getValue() - possibleHeights.get(left).getValue());
            } else {
                break;
            }
        }
        return ans;
    }
}

public class MinimiseHeight {

    static int try1(int[] arr, int n, int k) {
        if (n == 1) {
            return 0;
        }

        Arrays.sort(arr);
        int ans = arr[n - 1] - arr[0];
        int small = arr[0] + k;
        int big = arr[n - 1] - k;

        int temp = 0;

        if (small > big) {
            temp = small;
            small = big;
            big = temp;
        }

        for (int i = 1; i < n - 1; i++) {
            int subtract = arr[i] - k;
            int add = arr[i] + k;

            if (subtract >= small || add <= big)
                continue;

            // Either subtraction causes a smaller
            // number or addition causes a greater
            // number. Update small or big using
            // greedy approach (If big - subtract
            // causes smaller diff, update small
            // Else update big)
            if (big - subtract <= add - small)
                small = subtract;
            else
                big = add;
        }
        return Math.min(ans, big - small);
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = new Solution().getMinDiff(arr, n, k);
        System.out.println(ans);
    }
}
