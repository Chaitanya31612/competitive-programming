public class RainTrapping {

    public static int rainTrapped(int[] a, int n) {
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = a[0];
        int leftMax = a[0];
        for(int i = 1; i < n; i++) {
            left[i] = Math.max(leftMax, a[i]);
            leftMax = left[i];
        }

        right[n-1] = a[n-1];
        int rightMax = a[n-1];
        for(int i = n-2; i >= 0; i--) {
            right[i] = Math.max(a[i], rightMax);
            rightMax = right[i];
        }

        int trapped = 0;
        for(int i = 0; i < n; i++) {
            trapped += Math.min(left[i], right[i]) - a[i];
        }

        return trapped;
    }

    public static void main(String[] args) {
        int[] a = {3,1,2,4,0,1,3,2};

        System.out.println(rainTrapped(a, a.length));
    }
}
