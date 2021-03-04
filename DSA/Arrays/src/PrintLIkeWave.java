import java.util.Scanner;

public class PrintLIkeWave {

    static void printTopBottom(int[][] arr, int col) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][col] + " ");
        }
    }

    static void printBottomTop(int[][] arr, int col) {
        for(int i = arr.length-1; i >= 0; i--) {
            System.out.print(arr[i][col] + " ");
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            boolean top = true;
            for(int i = 0; i < m; i++) {
                if(top) {
                    printTopBottom(arr, i);
                    top = false;
                } else {
                    printBottomTop(arr, i);
                    top = true;
                }
            }
        }
    }
}
