package contest709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C {

    public static int findMinOcc(int[] arr, int[] ans, int m) {
        int ind = -1, min = Integer.MAX_VALUE;

        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < ans.length; i++)
        {
            if (mp.containsKey(arr[i]))
            {
                mp.put(ans[i], mp.get(arr[i]) + 1);
            }
            else
            {
                mp.put(ans[i], 1);
            }
        }

        for(int i = 0; i < arr.length; i++) {
            if(mp.containsKey(arr[i])) {
                if(mp.get(arr[i]) + 1 > Math.ceil((double)m/(double)2)) {
                    continue;
                } else if(arr[i] < min) {
                    min = arr[i];
                    ind = i;
                }
            }
        }

        if(ind == -1) {
            return -1;
        } else {
            return ind;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] ans = new int[n];
            boolean flag = true;
            for(int i = 0; i < m; i++) {
                int k = sc.nextInt();
                int[] arr = new int[k];
                for(int j = 0; j < k; j++) {
                    arr[j] = sc.nextInt();
                }


                if(ans.length == 0) {
                    // todo check
                    ans[0] = arr[0];
                } else {
                    int indx = findMinOcc(arr, ans, m);
                    if(indx == -1) {
                        System.out.println("NO");
                        flag = false;
                        break;
                    } else {
                        ans[i] = arr[indx];
                    }
                }
            }

            if(flag) {
                for(int i = 0; i < n; i++) {
                    System.out.println("YES");
                    System.out.print(ans[i] + " ");
                }
            }
        }
    }
}
