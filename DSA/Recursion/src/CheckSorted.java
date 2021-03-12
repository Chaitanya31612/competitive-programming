public class CheckSorted {

    public static boolean checkSorted(int[] input) {
        if(input.length <= 1) {
            return true;
        }

        if(input[0] > input[1]) {
            return false;
        }

        int[] temp = new int[input.length-1];
        for(int i = 1; i < input.length; i++) {
            temp[i-1] = input[i];
        }

        return checkSorted(temp);
    }

    public static boolean checkSortedBetter(int[] input, int startIndx) {
        int n = input.length;
        if(startIndx == n - 1) {
            return true;
        }

        if(input[startIndx] > input[startIndx + 1]) {
            return false;
        }

        return checkSortedBetter(input, startIndx+1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 7};
        System.out.println(checkSorted(arr));
        System.out.println(checkSortedBetter(arr, 0));
    }
}
