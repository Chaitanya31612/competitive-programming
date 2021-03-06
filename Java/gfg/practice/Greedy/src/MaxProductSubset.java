public class MaxProductSubset {

    static int maxProductSubset(int[] a, int n) {
        if(n == 1)
            return a[0];

        int negmax = Integer.MIN_VALUE,
        count_neg = 0, count_zero = 0;
        int product = 1;

        for(int i = 0; i < n; i++) {
            if(a[i] == 0) {
                count_zero++;
                continue;
            }

            if(a[i] < 0) {
                count_neg++;
                negmax = Math.max(negmax, a[i]);
            }


            product *= a[i];
        }

        if(count_zero == n) {
            return 0;
        }

        if((count_neg&1)==1) {

            // Exceptional case: There is only
            // negative and all other are zeros
            if (count_neg == 1
                    && count_zero > 0
                    && count_zero + count_neg == n) {
                return 0;
            }

            product /= negmax;
        }

        return product;
    }

    public static void main(String[] args) {
        int a[] = { -1, -1, -2, 4, 3 };
        int n = 5;

        System.out.println(maxProductSubset(a, n));
    }
}
