import java.util.Arrays;

public class MergeSort {

    public static void merge(int[] input, int start, int mid, int end) {
        if(start > end) {
            return;
        }

        int i = start, j = mid+1, k = 0;
        int[] ans = new int[end - start + 1];
        while(i <= mid && j <= end) {
            if(input[i] < input[j]) {
                ans[k++] = input[i++];
            } else {
                ans[k++] = input[j++];
            }
        }

        while(i <= mid) {
            ans[k++] = input[i++];
        }

        while(j <= end) {
            ans[k++] = input[j++];
        }

        for(int c = 0; c < ans.length; c++) {
            input[start + c] = ans[c];
        }


    }

    public static void mergesort(int[] input, int start, int end) {
        if(start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        // first sort both half arrays and then merge them
        mergesort(input, start, mid);
        mergesort(input, mid + 1, end);
        merge(input, start, mid, end);
    }

    public static void main(String[] args) {
        int[] input = {8, 1, 4, 3, 9 , 2, 7};
        mergesort(input, 0, input.length-1);
        System.out.println(Arrays.toString(input));
    }
}
