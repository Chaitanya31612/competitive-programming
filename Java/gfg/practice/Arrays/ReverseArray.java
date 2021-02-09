import java.util.*;

public class ReverseArray {

    static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5};
        int[] b = { 1, 2, 3, 4, 5, 6 };
        
        int i = 0, j = 4, k = 5; // i = start , j -> a, k -> b
        // for a
        while (i <= j) {
            swap(a, i, j);
            i++;
            j--;
        }

        i = 0;
        while (i <= k) {
            swap(b, i, k);
            i++;
            k--;
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        String str = "abcd";
        
    }
}
