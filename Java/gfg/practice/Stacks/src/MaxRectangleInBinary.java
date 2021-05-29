import java.util.Scanner;

public class MaxRectangleInBinary {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        MaxAreaHistogram maxAreaHistogram = new MaxAreaHistogram();

        int maxArea = maxAreaHistogram.getMaxArea(arr[0], n);

        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] != 0) {
                    arr[i][j] += arr[i - 1][j];
                }
            }


            int currArea = maxAreaHistogram.getMaxArea(arr[i], n);
            maxArea = Math.max(maxArea, currArea);
        }

        System.out.println(maxArea);
    }
}

/* Sample
4 4
0 1 1 0
1 1 1 1
1 1 1 1
1 1 0 0

8

2 8
0 0 1 0 0 0 0 0
1 1 1 1 1 1 1 0

7

8 17
1 0 0 1 0 0 1 0 0 1 1 0 1 0 1 0 1
1 1 0 1 1 0 1 1 0 1 1 1 0 1 0 0 1
1 1 1 1 1 0 0 1 0 0 0 0 0 0 0 0 0
1 0 1 0 0 0 1 1 0 1 1 0 0 0 0 0 0
1 0 0 1 0 1 1 0 0 0 1 1 1 1 1 0 0
0 1 0 1 0 1 1 0 0 0 1 1 1 1 0 0 0
1 0 1 1 1 0 1 0 0 0 1 0 0 0 1 1 1
1 1 1 1 1 1 1 1 0 1 0 0 0 0 0 1 0

8

1 12
0 1 0 1 0 1 0 1 1 1 0 0

3
* */