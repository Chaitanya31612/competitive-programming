package contest713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class D {
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

    public static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for(int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        return sum;
    }

    public static void print(ArrayList<Integer> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int[] b = new int[n + 2];
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < b.length; i++) {
                b[i] = sc.nextInt();
                set.add(b[i]);
            }

            Arrays.sort(b);
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < b.length - 1; i++) {
                list.add(b[i]);
            }

            boolean done = false;
            for(int i = 0; i < list.size(); i++) {
                ArrayList<Integer> list1 = new ArrayList<>();
                int count = 0;
                for(int j = i; count < b.length - 2; j++) {
                    if(j >= b.length - 1) {
                        j = 0;
                    }
                    list1.add(b[j]);
                    count++;
                }

//                System.out.println(list1);
                if(set.contains(sum(list1))) {
                    print(list1);
                    done = true;
                    break;
                }
            }


            if(!done) {
                System.out.println(-1);
            }


//            while (true) {
//                for(int i = 0; i < b.length - 2; i++) {
//                    list.add(b[i]);
//                }
//
//                if(sum(list) == b[n - 1]) {
//                    print(list);
//                    break;
//                } else {
//
//                }
//
//            }
        }
    }
}
