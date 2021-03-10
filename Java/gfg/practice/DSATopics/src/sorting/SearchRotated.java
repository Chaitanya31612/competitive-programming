package sorting;

public class SearchRotated {

    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            // left array is sorted
            else if(nums[l] <= nums[mid]) {
                if(target >= nums[l] && target <= nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            // right is sorted
            else {
                if(target >= nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        System.out.println(search(nums, target));
    }
}
