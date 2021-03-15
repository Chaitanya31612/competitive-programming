package contest1;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int c = 0;
            int[] ans = new int[n];

            for(int i = 0; i < n; i++) {
                if(arr[i] == 0) {
                    continue;
                } else if(arr[i] > 0) {
                    int temp = arr[i];
                    int indx = i;
                    while(indx >= 0 && --temp >= 0) {
                        ans[indx--] = 1;
                    }
                }
            }

//            while(c < n) {
//                while(c < n && arr[c] == 0) {
//                    c++;
//                }
//                int temp = c;
//                c++;
//                if(temp < n) {
//                    int count = arr[temp];
//                    while(temp >= 0 && --count >= 0) {
//                        ans[temp--] = 1;
//                    }
//                }
//            }

            for(int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
