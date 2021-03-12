public class SumArray {
    public static int sum(int[] arr) {
        if(arr.length == 1) {
            return arr[0];
        }

        int nth = arr[0];
        int[] temp = new int[arr.length - 1];
        for(int i = 1; i < arr.length; i++) {
            temp[i-1] = arr[i];
        }

        return nth + sum(temp);
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 3, 1};
        System.out.println(sum(arr));
    }
}
