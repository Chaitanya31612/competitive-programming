import java.util.*;

class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        int[] arr = { 10, 32, 54, 21, 43, 21, 4, 1, 2 };
        findVal(arr, val);
    }

    static void findVal(int[] arr, int val) {
        int i = 0;
        for (; i < arr.length; i++) {
            if (arr[i] == val) {
                System.out.println(i);
                break;
            } else {
                continue;
            }
        }
        if (i == arr.length) {
            System.out.println(-1);
        }
    }
}