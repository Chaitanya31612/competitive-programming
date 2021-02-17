import java.util.*;

class GfG {
    public static void printFirstNegative(int[] arr, int n, int k) {
        // deque implementation
        LinkedList<Integer> Di = new LinkedList<>();
        int i = 0;
        for (; i < k; i++) {
            if (arr[i] < 0) {
                Di.add(i);
            }
        }

        for (; i < n; i++) {
            if (!Di.isEmpty()) {
                System.out.print(arr[Di.peek()] + " ");
            } else {
                System.out.print(0 + " ");
            }

            while (!Di.isEmpty() && Di.peek() < (i - k + 1)) {
                Di.remove();
            }

            if (arr[i] < 0) {
                Di.add(i);
            }
        }

        if (!Di.isEmpty()) {
            System.out.print(arr[Di.peek()]);
        } else {
            System.out.print(0 + " ");
        }
        System.out.println();
    }
}

public class FirstNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int k = sc.nextInt();

            GfG gfg = new GfG();
            gfg.printFirstNegative(arr, n, k);

            // for (int i = 0; i <= n - k; i++) {
            //     int temp = k, a = i, p = 0;
            //     while (a < n && temp-- > 0) {
            //         if (arr[a] < 0) {
            //             p = arr[a];
            //             break;
            //         } else {
            //             a++;
            //         }
            //     }
            //     System.out.print(p + " ");
            // }
            // System.out.println();
        }
    }
}
