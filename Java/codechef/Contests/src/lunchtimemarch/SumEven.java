package lunchtimemarch;

import java.io.*;
import java.util.Scanner;

public class SumEven {
    public static long calcSum(long[] arr) {
        long sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            long[] arr = new long[n];


            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

            long sum = calcSum(arr);
            if((sum&1) == 0) {
                System.out.println(0);
            } else {
                boolean isTwo = false;
                for(int i = 0; i < arr.length; i++) {
                    if(arr[i] == 2) {
                        isTwo = true;
                        System.out.println(1);
                        break;
                    }
                }

                if(!isTwo) {
                    System.out.println(-1);
                }

//                long ans = 1;
//                boolean flag = false;
//                for(int i = 0; i < arr.length; i++) {
//                    long num = arr[i];
//                    long p = Math.max(0, (long)Math.ceil((double)num/ (double)2) - 1);
//                    long temp = (long)Math.pow(num, p);
//
//                    long newSum = sum - num + temp;
//                    if((newSum&1) == 0) {
//                        System.out.println(1);
//                        flag = true;
//                        break;
//                    }
//                    ans++;
//                }
//
//                if(!flag) {
//                    System.out.println(-1);
//                }
            }

        }

    }
}
