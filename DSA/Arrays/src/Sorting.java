public class Sorting {
    public static void print(int[] arr){
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void selection(int[] arr) {
        // 2 9 1 10 4 7
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            int minIndx = i;
            for(int j = i+1; j < n; j++) {
                if(arr[minIndx] > arr[j]) {
                    minIndx = j;
                }
            }
            if(i != minIndx) {
                int temp = arr[minIndx];
                arr[minIndx] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void bubble(int[] arr) {
        /** Bubble sort used for sorting the given array */
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void insertion(int[] arr){
        // 2 | 9 1 10 4 7

        int n = arr.length;
        for(int i = 1; i < n; i++) {
            int ele = arr[i];
            int j = i-1;
            while(j >= 0 && ele < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = ele;
            // i = 1, j = 0, ele = 9,
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 9, 1, 10, 4, 7};

//        selection(arr);
//        bubble(arr);
        insertion(arr);

        print(arr);
    }
}
