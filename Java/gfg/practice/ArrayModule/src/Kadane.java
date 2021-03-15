public class Kadane {

    public static int maxSumArray(int[] arr, int n) {

        // O(n) solution
        int maxsum = Integer.MIN_VALUE, cursum = 0;
        for(int i = 0; i < n; i++) {
            cursum = cursum + arr[i];
            if(cursum > maxsum) {
                maxsum = cursum;
            }
            if(cursum < 0) {
                cursum = 0;
            }
        }
        return maxsum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,-2,5};

        int ans = maxSumArray(arr, arr.length);
        System.out.println(ans);
    }
}
