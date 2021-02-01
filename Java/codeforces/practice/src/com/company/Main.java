package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        int ans = 0;

        if (a[k] <= 0) {
            ans = 0;
        } else {
            ans += k;
            int i = k;
            while (a[++i] == a[k] && i <= n) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
