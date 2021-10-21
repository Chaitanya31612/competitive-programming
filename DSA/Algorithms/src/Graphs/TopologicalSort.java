package Graphs;

import java.util.*;

public class TopologicalSort {

    private static void topoSortDFS(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited,
            ArrayList<Integer> output) {
        visited[src] = true;

        for (int neigh : adj.get(src)) {
            if (!visited[neigh]) {
                topoSortDFS(neigh, adj, visited, output);
            }
        }

        output.add(0, src);

    }

    public static int[] topoSortDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoSortDFS(i, adj, visited, output);
            }
        }

        int[] ans = new int[output.size()];
        for (int i = 0; i < output.size(); i++) {
            ans[i] = output.get(i);
        }
        return ans;
    }

    /* topological sort bfs approach */

    public static ArrayList<Integer> topoSortBFS(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];

        ArrayList<Integer> ans = new ArrayList<>();
        // for (int i = 0; i < adj.size(); i++) {
        // if (!visited[i]) {
        bfs(adj, adj.size(), 0, visited, ans);
        // }
        // }

        return ans;
    }

    private static void bfs(ArrayList<ArrayList<Integer>> adj, int v, int s, boolean[] visited,
            ArrayList<Integer> ans) {
        int[] indegree = new int[v];
        Queue<Integer> q = new LinkedList<>();

        // initialize indegree of every vertex
        for (int i = 0; i < v; i++) {
            for (int neigh : adj.get(i)) {
                indegree[neigh]++;
            }
        }

        // find vertices with indegree 0 and add them to queue
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        visited[s] = true;
        while (!q.isEmpty()) {
            int front = q.poll();
            ans.add(front);

            for (int neigh : adj.get(front)) {
                indegree[neigh]--;

                if (indegree[neigh] == 0) {
                    q.add(neigh);
                    visited[neigh] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adj.get(v1).add(v2);
        }

        int[] arr = topoSortDFS(v, adj);
        System.out.println(Arrays.toString(arr));
        System.out.println(topoSortBFS(adj));
    }
}
