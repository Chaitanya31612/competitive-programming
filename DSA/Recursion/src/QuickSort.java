import java.util.Arrays;

public class QuickSort {

    public static int partition(int[] input, int start, int end) {
        int pivot = input[start];

        int count = 0;
        for(int i = start+1; i <= end; i++) {
            if(input[i] <= pivot) {
                count++;
            }
        }

        int pivotPos = start + count;
        int t = input[pivotPos];
        input[start + count] = pivot;
        input[start] = t;

        int i = start, j = end;
        while(i < pivotPos && j > pivotPos) {
            while (input[i] <= pivot && i < pivotPos) {
                i++;
            }
            while (input[j] > pivot && j > pivotPos) {
                j--;
            }
            int temp = input[i];
            input[i] = input[j];
            input[j] = temp;
        }

        return pivotPos;
    }

    public static void quickSort(int[] input, int start, int end) {
        // base case -> when array has only one element
        if(start >= end) {
            return;
        }

        int pivotPos = partition(input, start, end);
        quickSort(input, start, pivotPos - 1);
        quickSort(input, pivotPos + 1, end);
    }

    public static void main(String[] args) {
//        int[] input = {8, 1, 4, 3, 9 , 2, 7};
        int[] input = {6, 2, 20, 8, 15, 3, 4};
        quickSort(input, 0, input.length-1);
        int indx = partition(input, 0, input.length-1);
//        System.out.println(indx);
        System.out.println(Arrays.toString(input));
    }
}
