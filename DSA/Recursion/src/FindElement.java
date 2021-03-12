public class FindElement {

    public static boolean findx(int[] arr, int x) {
        int n = arr.length;
        if(n == 1) {
            if(arr[0] == x) {
                return true;
            } else {
                return false;
            }
        }

        if(arr[0] == x) {
            return true;
        }

        int[] temp = new int[n-1];
        for(int i = 1; i < n; i++) {
            temp[i-1] = arr[i];
        }

        return findx(temp, x);
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 10};
        int x = 8;
        System.out.println(findx(arr, x));
    }
}
