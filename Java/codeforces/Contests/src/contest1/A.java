package contest1;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < 2; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int[] tm = new int[n];
            for(int i = 0; i < n; i++) {
                tm[i] = sc.nextInt();
            }

            int arrivingTime = 0, reachingTime = 0;
            //initial delay
            arrivingTime += arr[0][0] - 0 + tm[0];
            for(int i = 1; i < n; i++) {
                int b = arr[i-1][1];
                int timeStay = (int)Math.ceil((double) (arr[i-1][1] - arr[i-1][0])/(double) 2);

                if(arrivingTime + timeStay < b) {
                    reachingTime = b;
                } else {
                    reachingTime = arrivingTime + timeStay;
                }
                int timeToReach = arr[i][0] - b + tm[i];

                arrivingTime = reachingTime + timeToReach;

            }
            System.out.println(arrivingTime);
        }
    }
}
