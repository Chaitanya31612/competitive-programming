public class MajorityElement {

    public static int findMajority(int[] arr, int n) {
        int maj_indx = 0, count = 1;
        for(int i = 1; i < n; i++) {
            if(arr[maj_indx] == arr[i]) {
                count++;
            } else {
                count--;
            }

            if(count == 0) {
                maj_indx = i;
                count = 1;
            }
        }

        if(isMajority(arr, n, arr[maj_indx])) {
            return arr[maj_indx];
        } else {
            return -1;
        }
    }

    public static boolean isMajority(int[] arr, int n, int maj) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == maj) {
                count++;
            }
        }
        if(count > n/2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 1, 2};
        int ans = findMajority(arr, arr.length);
        System.out.println(ans);
    }
}
