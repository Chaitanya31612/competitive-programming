import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {0, 2, 6, 8, 9};

        int n = arr1.length;
        int m = arr2.length;
        int[] arr3 = new int[n + m];

        int i = 0, j = 0, k = 0;
        while(i < n && j < m) {
            if(arr1[i] <= arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }

        while(i < n) {
            arr3[k++] = arr1[i++];
        }

        while(j < m) {
            arr3[k++] = arr2[j++];
        }
        int indx = 0;
        for(int a = 0; a < n; a++) {
            arr1[a] = arr3[indx++];
        }
        for(int a = 0; a < m; a++) {
            arr2[a] = arr3[indx++];
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
