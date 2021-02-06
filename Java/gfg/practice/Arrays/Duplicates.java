import java.util.*;

public class Duplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int[] A = new int[10];

            for (int i = 0; i < 10; i++) {
                A[i] = sc.nextInt();
            }

            int[] newArray = new int[10];
            newArray[0] = A[0];
            for (int j = 1; j < 10; j++) {
                newArray[j] = A[j];
                if (newArray[j] == newArray[j - 1]) {
                    System.out.println(newArray[j]);
                    break;
                }
            }
        }
    }    
}
