package contest711;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
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

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            long w = sc.nextLong();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);
            boolean flag = false;
            int sumlast = 0, ans = 1;
            for(int i = n-1; i >= 0; i--) {
                sumlast += arr[i];
                if(sumlast > w) {
                    if(i == 0) {
                        ans = 2;
                    } else {
                        flag = true;
                        break;
                    }
                }
            }

            if(!flag) {
                System.out.println(ans);
            } else {
                int level = 0;
                ArrayList<Integer> list = new ArrayList<>(n);
                list.add(0);
//                int j = 0;
                for(int i = n-1; i >= 0; i--) {
                    if(arr[i] == -1) {
                        continue;
                    }
                    if(list.get(level) + arr[i] <= w) {
                        list.set(level, list.get(level) + arr[i]);
                        arr[i] = -1;
                    } else {
//                        for(; j < i; j++) {
//                            if(arr[j] != -1) {
//                                if(list.get(level) + arr[j] <= w) {
//                                    list.set(level, list.get(level) + arr[j]);
//                                    arr[j] = -1;
//                                } else {
//                                    break;
//                                }
//                            }
                        for(int j = i; j >= 0; j--) {
                            if(arr[j] != -1) {
                                if(list.get(level) + arr[j] <= w) {
                                    list.set(level, list.get(level) + arr[j]);
                                    arr[j] = -1;
                                }
                            }
                        }
//                        if(j != i) {
                            level++;
                            list.add(arr[i]);
                            arr[i] = -1;
//                        }
                    }
                }

                System.out.println(level+1);
            }
        }
    }
}
