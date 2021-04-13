import java.util.Scanner;

public class Prims {

    public static int min(int[] weights, boolean[] visited) {
        int minVal = Integer.MAX_VALUE;
        int indx = -1;
        for(int i = 0; i < weights.length; i++) {
            if((weights[i] < minVal) && !visited[i]) {
                minVal = weights[i];
                indx = i;
            }
        }

        return indx;
    }

    /* time - O(V^2) */
    public static void prims(int[][] edges, int n) {
        boolean[] visited = new boolean[n];
        int[] weights = new int[n];
        int[] parent = new int[n];

        // initialize weights to infinity for all except the starting index
        for(int i = 1; i < n; i++) {
            weights[i] = Integer.MAX_VALUE;
        }
        weights[0] = 0;

        // initialize parent of starting index to -1
        parent[0] = -1;

        for(int i = 0; i < n; i++) {
            // index of element with minimum value out of unvisited vertices
            int minIndex = min(weights, visited);
            visited[minIndex] = true;

            for(int j = 0; j < n; j++) {
                int edgeWeight = edges[minIndex][j];
                if(edgeWeight > 0) {
                    if((edgeWeight < weights[j]) && !visited[j]) {
                        weights[j] = edgeWeight;
                        parent[j] = minIndex;
                    }
                }
            }
        }

        for(int i = 1; i < n; i++) {
            if(parent[i] < i)
                System.out.println(parent[i] + " " + i + " " + weights[i]);
            else
                System.out.println(i + " " + parent[i] + " " + weights[i]);
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

        prims(edges, n);
    }
}

/* Input
5
7
0 1 4
0 2 8
1 2 2
1 3 6
2 3 3
2 4 9
3 4 5

Output
0 1 4
1 2 2
2 3 3
3 4 5
* */