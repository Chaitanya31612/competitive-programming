import java.util.Arrays;

public class DuplicateFind {

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};

        Arrays.sort(nums);
        int k = 0;
        while(k < nums.length-1 && nums[k] < nums[k+1]) {
            k++;
        }
        if(k == nums.length) {
            System.out.println(-1);
        } else {
            System.out.println(nums[k]);
        }

    }
}

