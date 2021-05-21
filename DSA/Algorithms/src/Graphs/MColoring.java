package Graphs;

import java.util.*;


public class MColoring {
    // using backtracking

    private static boolean isSafe(ArrayList<Integer>[] graph, int[] color, int c, int v) {

        for(int neigh : graph[v]) {
            if(color[neigh] == c) {
                return false;
            }
        }

        return true;
    }

    private static boolean graphColoringBacktrackingUtil(ArrayList<Integer>[] graph, int[] color,
                                                         int v, int m) {
        int n = graph.length;
        if(v == n) {
            return true;
        }

        // try different colors
        for(int c = 1; c <= m; c++) {
            if(isSafe(graph, color, c, v)) {
                color[v] = c;

                if(graphColoringBacktrackingUtil(graph, color, v + 1, m)) {
                   return true;
                }

                color[v] = 0;
            }
        }

        /* If no color can be assigned to
           this vertex then return false */
        return false;
    }

    public static boolean graphColoringBacktracking(ArrayList<Integer>[] G, int[] color, int i, int m) {


        if(!graphColoringBacktrackingUtil(G, color, 0, m)) {
            return false;
        }

        return true;
    }


    // using bfs
    public static boolean graphColoring(ArrayList<Integer>[] G, int[] color, int i, int m) {
        int n = G.length;
        boolean[] visited = new boolean[n];
        int maxColor = 1;

        Arrays.fill(color, 1);

        for(i = 0; i < n; i++) {
            if(visited[i]) {
                continue;
            }

            Queue<Integer> q = new LinkedList<>();
            visited[i] = true;
            q.add(i);

            while(!q.isEmpty()) {
                int front = q.poll();

                for(int neigh : G[front]) {
                    if(!visited[neigh]) {
                        if(color[neigh] == color[front]) {
                            color[neigh]++;
                        }

                        maxColor = Math.max(color[front], color[neigh]);

                        if(maxColor > m) {
                            return false;
                        }
                        q.add(neigh);
                        visited[neigh] = true;

                    }
                }

            }
        }

        return true;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int V = scan.nextInt();
        int C = scan.nextInt();
        int E = scan.nextInt();

        ArrayList<Integer>[] G = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            G[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int u = scan.nextInt() - 1;
            int v = scan.nextInt() - 1;
            G[u].add(v);
            G[v].add(u);
        }
        int[] color = new int[V];

        System.out.println(graphColoringBacktracking(G, color, 0, C) ? 1 : 0);

    }
}
