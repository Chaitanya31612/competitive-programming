import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class DijkstraList {

    private static int findMin(int[] distances, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for(int i = 0; i < distances.length; i++) {
            if(!visited[i] && distances[i] < min) {
                min = distances[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        boolean[] visited = new boolean[V];
        int[] distances = new int[V];
        for(int i = 0; i < V; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[S] = 0;

        for(int i = 0; i < V; i++) {
            // find unvisited minimum distance
            int minIndex = findMin(distances, visited);

            visited[minIndex] = true;
            for(int j = 0; j < adj.get(minIndex).size(); j++) {
                int newDis = distances[minIndex] + adj.get(minIndex).get(j).get(1);

                if(newDis < distances[adj.get(minIndex).get(j).get(0)]) {
                    distances[adj.get(minIndex).get(j).get(0)] = newDis;
                }
            }
        }

        return distances;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }

            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }

//            System.out.println(adj);

            int S = Integer.parseInt(read.readLine());


            int[] ptr = dijkstra(V, adj, S);

            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}


