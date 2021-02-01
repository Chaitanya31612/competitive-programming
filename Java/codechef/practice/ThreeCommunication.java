import java.util.*;
import java.lang.*;

public class ThreeCommunication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            double R = sc.nextDouble();
            int[][] D = new int[3][2];

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    D[i][j] = sc.nextInt();
                }
            }

            double dis12 = (Math.pow(D[1][0] - D[0][0], 2) + Math.pow(D[1][1] - D[0][1], 2));
            double d12 = Math.sqrt(dis12);
            
            double dis23 = (Math.pow(D[2][0] - D[1][0], 2) + Math.pow(D[2][1] - D[1][1], 2));
            double d23 = Math.sqrt(dis23);

            double dis31 = (Math.pow(D[2][0] - D[0][0], 2) + Math.pow(D[2][1] - D[0][1], 2));
            double d31 = Math.sqrt(dis31);

            int count = 0;
            if (d12 <= R) {
                count++;
            }
            if (d23 <= R) {
                count++;
            }
            if (d31 <= R) {
                count++;
            }

            if (count >= 2) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
