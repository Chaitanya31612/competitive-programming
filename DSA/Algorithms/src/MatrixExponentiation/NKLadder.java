package MatrixExponentiation;

import java.util.Scanner;

public class NKLadder {
    static int n, k, ans = -1;

    public static int nkLadderRec(int i) {
        if(i == 0) {
            return 1;
        }
        if(i < 0) {
            return 0;
        }


        for(int j = 1; j <= k; j++) {
            if(nkLadderRec(i - j) == 1) {
                ans++;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        System.out.println(nkLadderRec(n));
    }
}
