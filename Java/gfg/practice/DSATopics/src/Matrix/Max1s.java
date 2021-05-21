package Matrix;

import java.util.Scanner;

public class Max1s {
    public static int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        // int ans = 0, ind = -1;

        // for(int i = 0; i < n; i++) {
        //     int temp = 0;
        //     for(int j = m - 1; j >= 0; j--) {
        //         if(arr[i][j] == 1) {
        //             temp++;
        //         } else {
        //             break;
        //         }
        //     }
        //     if(temp > ans) {
        //         ans = temp;
        //         ind = i;
        //     }
        // }

        // return ind;
        int res_index = -1;
        int j = m - 1;

        for(int i = 0; i < n; i++)
        {
            while(j >= 0)
            {
                if(arr[i][j] == 1)
                {
                    j--;

                    res_index = i;
                }
                else
                {
                    break;
                }
            }
        }

        return res_index;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int ans = rowWithMax1s(arr, n, m);
        System.out.println(ans);


    }
}