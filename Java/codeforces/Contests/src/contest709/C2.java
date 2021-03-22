package contest709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class C2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Integer> ans = new ArrayList<>();
            boolean flag = true;
            for (int i = 0; i < m; i++) {
                int k = sc.nextInt();
                int[] arr = new int[k];
                for (int j = 0; j < k; j++) {
                    arr[j] = sc.nextInt();
                }

                if(ans.isEmpty()) {
                    ans.add(arr[0]);
                } else {
                    int min = Integer.MAX_VALUE, ind = -1;
                    for(int cc = 0; cc < arr.length; cc++) {
                        int freq = Collections.frequency(ans, arr[cc]);
                        if(freq < min && freq < Math.ceil((double)m/(double) 2)) {
                            min = freq;
                            ind = cc;
                        } else if(freq < Math.ceil((double)m/(double) 2)) {
                            ind = cc;
                        }
                    }

                    if(ind != -1) {
                        ans.add(arr[ind]);
                    } else {
                        System.out.println("NO");
                        flag = false;
                        break;
                    }
                }


            }
            if(flag) {
                System.out.println("YES");
                for(int in = 0; in < ans.size(); in++) {
                    System.out.print(ans.get(in) + " ");
                }
                System.out.println();

            }
        }
    }
}
