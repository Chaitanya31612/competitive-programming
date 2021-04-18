import java.util.Arrays;
import java.util.Scanner;

public class BellmanFord {

    static class Edge {
        int src;
        int dest;
        int weight;
    }


    public static void BellmanFord(Edge[] edges, int src, int v, int e) {
        int[] distances = new int[v];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;

        // Relaxation code
        for(int i = 1; i <= v - 1; i++) {
            for(int j = 0; j < e; j++) {
                int s = edges[j].src;
                int d = edges[j].dest;
                int wt = edges[j].weight;

                // Relaxation check
                if(distances[s] != Integer.MAX_VALUE && distances[d] > distances[s] + wt) {
                    distances[d] = distances[s] + wt;
                }
            }
        }


        // Check for Negative cycle
        for(int j = 0; j < e; j++) {
            int s = edges[j].src;
            int d = edges[j].dest;
            int wt = edges[j].weight;

            // Relaxation check
            if(distances[s] != Integer.MAX_VALUE && distances[d] > distances[s] + wt) {
                System.out.println("Has Negative Cycle");
                return;
            }
        }


        for(int i = 0; i < v; i++) {
            System.out.println(i + " - " + distances[i]);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        Edge[] edges = new Edge[e];

        for(int i = 0; i < e; i++) {
            edges[i] = new Edge();
            edges[i].src = sc.nextInt();
            edges[i].dest = sc.nextInt();
            edges[i].weight = sc.nextInt();
        }

        BellmanFord(edges, 0, v, e);
    }
}

/* Sample Input
5 8
0 1 -1
0 2 4
1 2 3
3 2 5
4 3 -3
1 4 2
1 3 2
3 1 1
* */