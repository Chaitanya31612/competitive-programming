package contest708;

import java.util.Arrays;
import java.util.Scanner;

public class C {

    public static int sum(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void print(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[3];
            if((n&1) == 0) {
                Arrays.fill(arr, 2);

            } else {
                Arrays.fill(arr, 1);
            }
            if(sum(arr) == n) {
                print(arr);
            } else {
                int max = n / 2;
                int iniSum = sum(arr);
                for(int i = 0; i < 3; i++) {
                    if(iniSum == n) {
                        break;
                    }
                    for(int j = 2; j + 2 <= max; j+=2) {
                        if(iniSum == n) {
                            break;
                        }
                        arr[i] += 2;
                        iniSum += 2;
                    }
                }

                print(arr);
            }
        }
    }
}
