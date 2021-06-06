package Graphs;

import java.io.IOException;
import java.util.*;

public class FordFulkerson {

    public static boolean bfs(int[][] rGraph, int n, int s, int t, int[] parent) {
        boolean[] visited = new boolean[n];

        Queue<Integer> q = new LinkedList<>();

        q.add(s);
        visited[s] = true;
        parent[s] = -1;

        while (!q.isEmpty()) {
            int u = q.poll();

            for(int v = 0; v < n; v++) {
                if(!visited[v] && rGraph[u][v] > 0) {
                    if(v == t) {
                        // found destination vertex
                        parent[v] = u;
                        return true;
                    }

                    visited[v] = true;
                    q.add(v);
                    parent[v] = u;
                }
            }
        }

        return false;
    }

    public static int solve(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        // N -> number of vertices, M -> number of edges
        // residual graph
        int[][] rGraph = new int[N][N];
        for(int i = 0; i < M; i++) {
            rGraph[Edges.get(i).get(0)-1][Edges.get(i).get(1)-1] = Edges.get(i).get(2);
            rGraph[Edges.get(i).get(1)-1][Edges.get(i).get(0)-1] = Edges.get(i).get(2);
        }

        int s = 0, t = N - 1;

//        for(int[] a: rGraph)
//            System.out.println(Arrays.toString(a));

        // this will be used to backtrack the path followed
        int[] parent = new int[N];
        int max_flow = 0;

        // use bfs to check if there is a path from source to destination and fill the parent array
        while(bfs(rGraph, N, s, t, parent)) {
            int path_flow = Integer.MAX_VALUE;

            // travel path and update the minimum path_flow
            for(int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }

            // update the residual graph
            for(int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                // subtract path_flow to edge u -> v
                rGraph[u][v] -= path_flow;
                // add path_flow to edge v -> u as we can stop u->v for passing from v->u
                rGraph[v][u] += path_flow;
            }

            max_flow += path_flow;
        }
        return max_flow;
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<>();

        for(int i=0;i<M;i++)
        {
            ArrayList<Integer> e = new ArrayList<Integer>();
            // u, v, weight
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            Edges.add(e);
        }
        int ans = solve(N, M, Edges);
        System.out.println();
        System.out.println(ans);

    }
}
/* Sample
4 4
1 2 8
2 3 4
3 4 6
4 1 5

4

4 4
1 2 8
1 3 10
4 2 2
3 4 3

5

6 10
1 6 9
3 2 7
6 1 7
5 1 2
5 3 2
5 4 5
3 2 8
2 2 8
3 5 9
2 3 3

*/
