

public class MergeSorted {
    public static void main(String[] args) {
        int[] arr1 = {2, 4, 5, 7, 8};
        int[] arr2 = {1, 2, 3, 6, 9};
        int[] arr3 = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] <= arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }

        while(i < arr1.length) {
            arr3[k++] = arr1[i++];
        }

        while(j < arr2.length) {
            arr3[k++] = arr2[j++];
        }

        Sorting.print(arr3);
    }
}
