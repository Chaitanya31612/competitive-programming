package BitManipulation;

public class CountBits {

    public static int countBits(int n) {
        int ans = 0;

        while(n > 0) {
            // -n -> 2's compliment
            // this will give the set bit from right
            int p = n & (-n);
            n = n - p;
            System.out.println(Integer.toBinaryString(p));
            System.out.println(Integer.toBinaryString(n));
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countBits(9));
    }
}
