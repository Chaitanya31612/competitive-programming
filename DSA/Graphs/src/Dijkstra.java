import java.util.Scanner;

public class Dijkstra {


    private static int findMin(int[] distances, boolean[] visited) {
        int minVal = Integer.MAX_VALUE;
        int indx = -1;
        for(int i = 0; i < distances.length; i++) {
            if((distances[i] < minVal) && !visited[i]) {
                minVal = distances[i];
                indx = i;
            }
        }

        return indx;
    }

    /* Finding Shortest path
    * time - O(V^2) */
    public static void dijkstra(int[][] edges, int n) {
        boolean[] visited = new boolean[n];
        int[] distances = new int[n];
        for(int i = 1; i < n; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[0] = 0;

        for(int i = 0; i < n; i++) {
            int minIndex = findMin(distances, visited);

            visited[minIndex] = true;

            for(int j = 0; j < n; j++) {
                if(edges[minIndex][j] > 0) {
                    int cur_dist = distances[minIndex] + edges[minIndex][j];

                    if(cur_dist < distances[j]) {
                        distances[j] = cur_dist;
                    }

                }
            }
        }

        for(int i = 1; i < n; i++) {
            System.out.println(0 + " " + i + " " + distances[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt();

        int[][] edges = new int[n][n];

        for(int i = 0; i < e; i++) {
            int fv = sc.nextInt();
            int sv = sc.nextInt();
            int weight = sc.nextInt();

            edges[fv][sv] = weight;
            edges[sv][fv] = weight;
        }

        dijkstra(edges, n);
    }
}
