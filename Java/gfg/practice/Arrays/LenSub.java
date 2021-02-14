import java.util.*;

public class LenSub {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            if (arr.length == 1) {
                if (arr[0] < 0) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
            } else if (arr.length == 2) {
                if (arr[0] >= 0 && arr[1] >= 0) {
                    System.out.println(2);
                } else if (arr[0] > 0 || arr[1] > 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } 
            
            else {
                int a = 0, max = Integer.MIN_VALUE;
                while (a < n) {
                    int count = 0;
                    while (a < n && arr[a] >= 0) {
                        count++;
                        a++;
                    }
                    if (a < n && arr[a] < 0) {
                        while (a < n && arr[a] < 0) {
                            a++;
                        }
                    }
                    max = Integer.max(max, count);
                }
                System.out.println(max);

            }
            
        }
    }
}
