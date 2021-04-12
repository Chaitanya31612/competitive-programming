package contest713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

            char[][] matrix = new char[n][n];
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                String line = sc.nextLine();
                char[] points = line.toCharArray();
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = points[j];
                    if(points[j] == '*') {
                        ArrayList<Integer> list1 = new ArrayList<>();
                        list1.add(i);
                        list1.add(j);
                        list.add(list1);
                    }
                }
            }

//            System.out.println(list);
            int firstRow = list.get(0).get(0), secondRow = list.get(1).get(0);
            int firstCol = list.get(0).get(1), secondCol = list.get(1).get(1);
            if((firstRow == secondRow)) {
                if(firstRow + 1 >= n) {
                    matrix[firstRow - 1][firstCol] = '*';
                    matrix[secondRow - 1][secondCol] = '*';
                } else {
                    matrix[firstRow + 1][firstCol] = '*';
                    matrix[secondRow + 1][secondCol] = '*';
                }
            }
            else if((firstCol == secondCol)) {
                if(firstCol + 1 >= n) {
                    matrix[firstRow][firstCol - 1] = '*';
                    matrix[secondRow][secondCol - 1] = '*';
                } else {
                    matrix[firstRow][firstCol + 1] = '*';
                    matrix[secondRow][secondCol + 1] = '*';
                }
            } else {
                matrix[firstRow][secondCol] = '*';
                matrix[secondRow][firstCol] = '*';
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        }
    }
}
