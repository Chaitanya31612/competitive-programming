import java.util.ArrayList;
import java.util.Scanner;

public class CommonElements {

    public static ArrayList<Integer> commonElements(int[] A, int[] B, int[] C, int n1, int n2, int n3) {
        int i = 0, j = 0, k = 0;

        ArrayList<Integer> list = new ArrayList<>();

        while(i < n1 && j < n2 && k < n3) {
            // first we move pointer to the last duplicate value if any
            while(i > 0 && i < n1 && A[i - 1] == A[i])
                i++;

            while(j > 0 && j < n2 && B[j - 1] == B[j])
                j++;

            while(k > 0 && k < n3 && C[k - 1] == C[k])
                k++;

            if(i < n1 && j < n2 && k < n3) {
                if(A[i] == B[j] && B[j] == C[k]) {
                    list.add(A[i]);
                    i++;
                    j++;
                    k++;
                } else if(A[i] < B[j]) {
                    i++;
                } else if(B[j] < C[k]) {
                    j++;
                } else {
                    k++;
                }

            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        int[] A = new int[n1];
        int[] B = new int[n2];
        int[] C = new int[n3];

        for(int i = 0; i < n1; i++)
            A[i] = sc.nextInt();
        for(int i = 0; i < n2; i++)
            B[i] = sc.nextInt();
        for(int i = 0; i < n3; i++)
            C[i] = sc.nextInt();

        System.out.println(commonElements(A, B, C, n1, n2, n3));
    }
}
