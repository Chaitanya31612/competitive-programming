import java.util.*;

public class MoveNegativePointer {

    static void shiftall(int[] arr, int left, int right) {
        while (left <= right) {
            if (arr[left] < 0 && arr[right] < 0) {
                left++;
            }
            else if (arr[left] >= 0 && arr[right] < 0) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            else if (arr[left] >= 0 && arr[right] >= 0) {
                right--;
            }
            else {
                left++;
                right--;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        shiftall(arr, 0, n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
