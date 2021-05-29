import java.util.Scanner;

public class CountTotalSetBits {

    // for counting number of setbits for all the numbers till n
    // time - O(nlogn)
    public int numSetBits(int n) {
        int ans = 0;
        while(n > 0) {
            if((n & 1) == 1)
                ans++;
            n = n >> 1;
        }

        return ans;
    }

    public int numSetBitsBetter(int n) {
        if(n <= 0)
            return 0;

        // x is the largest power of 2 present in that number
        int x = (int)(Math.log(n) / Math.log(2));

        int numBitsTillx = (1<<(x-1))*x;
        int numBitsBegin = (n - (1<<x) + 1);

        return numBitsTillx + numBitsBegin + numSetBitsBetter(n - (1<<x));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CountTotalSetBits c = new CountTotalSetBits();

        int n = sc.nextInt();

        System.out.println(c.numSetBitsBetter(n));
        int ans = 0;
        for(int i = 1; i <= n; i++)
            ans += c.numSetBits(i);

        System.out.println(ans);

    }
}
