import java.util.*;

public class ChefAndPatients {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] A = new int[n];
            int[] sortArray = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
                sortArray[i] = A[i];
            }

            int[] ans = new int[n];
            
            Arrays.sort(sortArray);
            int k = 1;
            for (int i = sortArray.length - 1; i >= 0; i--) {
                int key = sortArray[i];
                
                for (int j = 0; j < n; j++) {
                    if (A[j] == key) {
                        ans[j] = k;
                        A[j] = -1;
                        k++;
                    }
                }
            }
            // System.out.println(Arrays.toString(ans));
            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }    
}
