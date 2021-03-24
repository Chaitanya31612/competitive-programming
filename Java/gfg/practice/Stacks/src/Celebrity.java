import java.io.IOException;
import java.util.Scanner;

public class Celebrity {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrityBrute(M,N));
//            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    }
}

class Solution {
    int celebrityBrute(int M[][], int n){

        for(int j = 0; j < n; j++) {
            int count = 0;
            for(int i = 0; i < n; i++) {
                if(i != j) {
                    if(M[i][j] == 1) {
                        count++;
                    }
                }
            }
            if(count == n-1 && count != 1) {
                return j;
            }
        }
        return -1;
    }

//    public int celebrity(int[][] M, int n) {
//
//    }
}