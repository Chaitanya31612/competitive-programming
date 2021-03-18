package contest708;

import java.util.Arrays;
import java.util.Scanner;

public class C2 {
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
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[3];
            int max = n / 2;

            if ((n & 1) == 0) {
                if((max&1) == 0) {
                    Arrays.fill(arr, max);
                } else {
                    Arrays.fill(arr, max - 1);
                }
                int iniSum = sum(arr);
                if(iniSum == n) {
                    print(arr);
                } else {
                    int diff = iniSum - n;
                    for(int i = 0; i < 3; i++) {
                        if(diff == 0) {
                            print(arr);
                            break;
                        } else if(diff > 0) {
                            diff = Math.abs(diff - arr[i] + 2);
                            arr[i] = 2;
                        }

                    }
                }
            } else {
                if((max&1) == 1) {
                    Arrays.fill(arr, max);
                } else {
                    Arrays.fill(arr, max - 1);
                }
                int iniSum = sum(arr);
                int diff = iniSum - n;
                for(int i = 0; i < 3; i++) {
                    if(diff == 0) {
                        print(arr);
                        break;
                    } else if(diff > 0) {
                        diff = Math.abs(diff - arr[i] + 1);
                        arr[i] = 1;
                    }

                }
            }


        }
    }
}
