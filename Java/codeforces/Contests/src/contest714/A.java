package contest714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        public String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() { return Integer.parseInt(next()); }

        public long nextLong() { return Long.parseLong(next()); }

        public double nextDouble()
        {
            return Double.parseDouble(next());
        }

        public String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static boolean isPeak(int arr[], int n, int num,
                          int i, int j)
    {

        // If num is smaller than the element
        // on the left (if exists)
        if (i >= 0 && arr[i] > num)
        {
            return false;
        }

        // If num is smaller than the element
        // on the right (if exists)
        if (j < n && arr[j] > num)
        {
            return false;
        }
        return true;
    }

    public static int[] solve(int n, int k) {
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        int[] imp = new int[]{-1};

        if(k == 0) {
            return arr;
        }

        if(n <= 2) {
            return imp;
        }
        if(n - k < 3) {
            return imp;
        }

        if(n == 3) {
            arr[1] = 3;
            arr[2] = 2;
            return arr;
        }

//        int[] ans = new int[n];
//        int min = 1, max = n - 1;
//        int j = n - 4;


        int count = 0;
        for(int i = n - 1; i > 0 && count < k; i -= 2) {
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
            count++;
        }

        int no_peaks = 0;
        for (int i = 0; i < n; i++)
        {
            if (isPeak(arr, n, arr[i], i - 1, i + 1))
            {
                no_peaks++;
            }
        }

        if(no_peaks != k) {
            return imp;
        }
        return arr;
    }




    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] ans = solve(n, k);
            for(int i = 0; i < ans.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
