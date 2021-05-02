package BitManipulation;

import java.util.Scanner;

public class NQueenCount {

    static int n, ans = 0, DONE;

    /*
    * rowmask - mask for the current row
    * ld - left diagonal
    * rd - right diagonal
    * */
    public static void count(int rowmask, int ld, int rd) {
        if(rowmask == DONE) {
            ans++;
            return;
        }

        /* Find safe bits
        * OR of rowmask, ld, rd is done because they are the areas where we cannot put queen
        * DONE is used to remove extra bits */
        int safe = DONE & ~(rowmask | ld | rd);

        while(safe > 0) {
            // find the rightmost set bit, for placing the queen
            int p = safe & (-safe);
            safe = safe - p;
            /*
            * rowmask | p - because the col of p is now unsafe
            * (ld | p ) << 1 - left shift because the left diagonal is also unsafe
            * (rd | p) >> 1 - right shift because right diagonal is also unsafe
            */
            count(rowmask | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        DONE = (1 << n) - 1; // 2^n - 1 - which is the number positions available for queen
        // eg for n = 4, DONE = 1111 which means that all the positions are available for queen

        count(0, 0, 0);
        System.out.println(ans);
    }
}

/* Sample Input
4
output - 2

8
output - 92
*/