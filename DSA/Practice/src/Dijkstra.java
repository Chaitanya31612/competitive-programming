import java.util.Arrays;

public class Dijkstra {
    public static void dijkstra(int[][] graph) {
        int v = graph.length;
        boolean[] visited = new boolean[v];
        int[] dist = new int[v];

        for(int i = 1; i < v; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[0] = 0;

        for(int i = 0; i < v - 1; i++) {
            int minInd = findMin(visited, dist);
            visited[minInd] = true;
            for(int j = 0; j < v; j++) {
                if(!visited[j] && graph[minInd][j] != 0 && dist[minInd] != Integer.MAX_VALUE &&
                dist[minInd] + graph[minInd][j] < dist[j]) {
                    dist[j] = dist[minInd] + graph[minInd][j];
                }
            }
        }

        System.out.println(Arrays.toString(dist));
    }

    public static int findMin(boolean[] visited, int[] dist) {
        int min = Integer.MAX_VALUE, indx = -1;

        for(int i = 0; i < dist.length; i++) {
            if(!visited[i] && dist[i] < min) {
                min = dist[i];
                indx = i;
            }
        }

        return indx;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        dijkstra(graph);
    }
}
