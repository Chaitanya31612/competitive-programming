import java.util.*;

public class BeautifulMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[5][5];

        int row = 0, column = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) {
                    row = i;
                    column = j;
                }
            }
        }

        int ans = (int)(Math.abs(2 - row) + Math.abs(2 - column));
        System.out.println(ans);

    }
}
