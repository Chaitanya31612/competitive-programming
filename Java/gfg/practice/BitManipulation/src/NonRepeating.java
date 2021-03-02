import java.util.Arrays;
import java.util.Scanner;

public class NonRepeating {

    public static int oneElement(int[] arr) {
        int res = 0;
        for(int i = 0; i < arr.length; i++) {
            res = res ^ arr[i];
        }

        return res;
    }



    public static int[] twoElement(int[] arr) {
        int res = 0;
        int num1=0, num2=0;
        for(int i = 0; i < arr.length; i++) {
            res = res ^ arr[i];
        }

        int[] odd = new int[arr.length];
        int[] even = new int[arr.length];
        int o = 0, e = 0;

        if((res&1) == 1) {
            for(int i = 0; i < arr.length; i++) {
                if((arr[i]&1) == 0) {
                    even[e++] = arr[i];
                } else {
                    odd[o++] = arr[i];
                }
            }
            num1 = res;
            for(int i = 0; i < even.length; i++) {
                num1 = num1^even[i];
            }
            num2 = num1^res;

        } else {

        }
        int[] ans = new int[]{num1, num2};
        Arrays.sort(ans);
        return ans;
    }

    public static void UniqueNumbers2(int[] arr,int n)
    {
        int sum =0;
        for(int i = 0;i<n;i++)
        {

            // Xor  all the elements of the array
            // all the elements occuring twice will
            // cancel out each other remaining
            // two unnique numbers will be xored
            sum = (sum^arr[i]);
        }

        // Bitwise & the sum with it's 2's Complement
        // Bitwise & will give us the sum containing
        // only the rightmost set bit
        sum = (sum&-sum);

        // sum1 and sum2 will contains 2 unique
        // elements elements initialized with 0 box
        // number xored with 0 is number itself
        int sum1 = 0;
        int sum2 = 0;

        // traversing the array again
        for(int i = 0;i<arr.length;i++)
        {

            // Bitwise & the arr[i] with the sum
            // Two possibilities either result == 0
            // or result > 0
            if((arr[i]&sum) > 0)
            {

                // if result > 0 then arr[i] xored
                // with the sum1
                sum1 = (sum1^arr[i]);
            }
            else
            {
                // if result == 0 then arr[i]
                // xored with sum2
                sum2 = (sum2^arr[i]);
            }
        }

        // print the the two unique numbers
        System.out.println("The non-repeating elements are "+
                sum1+" and "+sum2);
    }


    public static int[] twoelement2(int[] arr) {
        int res = 0;
        int num1=0, num2=0;
        for(int i = 0; i < arr.length; i++) {
            res = (res^arr[i]);
        }

        // contains the rightmost set bit
        // like for 6 = "110" res will contain "010"
        res = (res&-res);

        for(int i = 0; i < arr.length; i++) {
            /*
            now we divide array into two, one those who have same set bit so there &'and' will be >0
             and other those do not so there will be 0
             this is helpful because we can iterate over it and find our element
              it is guaranteed that these two element will be in different groups as only one of them will be having that bit
              eg. 3(011) and 5(101) then 3^5 = 6 (110) and res = 010 so as only one of them is having 1 at 2 they will be in different group
             */



            if((arr[i]&res) > 0) {
                num1 = (num1^arr[i]);
            } else {
                num2 = (num2^arr[i]);
            }
        }
        int[] ans = new int[]{num1, num2};
//        Arrays.sort(ans);
        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a1 = {1,2,3,2,1,5,5};
//        System.out.println(oneElement(a1));

        int[] a2 = {1,2,3,2,1,4};
        int[] a3 = new int[]{7, 6, 25, 4, 25, 15, 15, 7, 4, 3, 5, 6};
        System.out.println(Arrays.toString(twoElement(a2)));

//        UniqueNumbers2((new int[]{7, 6, 25, 4, 25, 15, 15, 7, 4, 3, 5, 6}), 12);

        System.out.println(Arrays.toString(twoelement2(a3)));
    }
}
