package contest708;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class A3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                // add unique values
                if(i == 0 || arr[i] != arr[i-1]) {
                    list.add(arr[i]);
                }
            }

            for(int i = 0; i < n; i++) {
                if(i > 0 && arr[i] == arr[i-1]) {
                    list.add(arr[i]);
                }
            }

            for(int i = 0; i < n; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}
