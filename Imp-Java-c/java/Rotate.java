import java.util.*;


  

public class Rotate {
     
    public static void main(String[] args) {
        int[][] a = new int[1000][1000];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        rotate(a, n);
        display(a, n);
    }
    
    static void display(int[][] a, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    static void rotate(int[][] a, int n){
        for (int row = 0; row < n; row++) {
            int start_col = 0;
            int end_col = n - 1;
            while (start_col < end_col) {
                int temp = a[row][start_col];
                a[row][start_col] = a[row][end_col];
                a[row][end_col] = temp;
                start_col++;
                end_col--;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    int temp = a[i][j];
                    a[i][j] = a[j][i];
                    a[j][i] = temp;
                }
            }
        }
    }
}