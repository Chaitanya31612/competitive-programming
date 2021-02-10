import java.util.*;

public class Sort012 {

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int zero = -1;

        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                zero++;
                swap(a, zero, i);
            }
        }

        int one = zero;
        // System.out.println(zero + " " + one);
        for (int i = zero + 1; i < n; i++) {
            if (a[i] == 1) {
                if (zero == -1) {
                    one = 0;
                } else {
                    one++;
                }
                swap(a, one, i);
            }
        }

        // System.out.println(Arrays.toString(a));

    }    
}
