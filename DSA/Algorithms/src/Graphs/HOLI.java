package Algorithms;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class HOLI {

    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

    private static int dfs(ArrayList<ArrayList<ArrayList<Integer>>> adj, int N, int node, boolean[] visited,
                           int[] count, long[] ans) {

        visited[node] = true;
        count[node] = 1;

        for(ArrayList<Integer> neighbour : adj.get(node)) {
            int v = neighbour.get(0);
            if(!visited[v]) {

                count[node] += dfs(adj, N, v, visited, count, ans);
                // number of element from vertex v
                int S = count[v];
                ans[0] += 2 * Math.min(S, N - S) * neighbour.get(1);
            }
        }

        return count[node];
    }


    public static long dfs(ArrayList<ArrayList<ArrayList<Integer>>> adj, int N) {
        boolean[] visited = new boolean[N];
        int[] count = new int[N];

        long[] ans = new long[1];
        dfs(adj, N, 0, visited, count, ans);
        return ans[0];
    }


    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();

        int t = sc.nextInt();
        for(int tt = 1; tt <= t; tt++) {
            int N = sc.nextInt();

            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

            for(int i = 0; i < N; i++) {
                adj.add(new ArrayList<>());
            }

            for(int i = 1; i <= N - 1; i++) {
                int u = sc.nextInt();
                u = u - 1;
                int v = sc.nextInt();
                v = v - 1;
                int w = sc.nextInt();

                ArrayList<Integer> t1 = new ArrayList<>();
                ArrayList<Integer> t2 = new ArrayList<>();

                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }

//            System.out.println(adj);
            System.out.println("Case #" + tt+": "+dfs(adj, N));
        }
    }
}
