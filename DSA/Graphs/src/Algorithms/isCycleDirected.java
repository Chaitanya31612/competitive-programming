package Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class isCycleDirected {

    private static boolean dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited,
                               boolean[] order) {
        if(order[s]) {
            return true;
        }

        if(visited[s]) {
            return false;
        }

        visited[s] = true;
        order[s] = true;

        for(int neigh : adj.get(s)) {
            if(dfs(adj, neigh, visited, order)) {
                return true;
            }
        }
        order[s] = false;

        return false;
    }

    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        // order tells whether node is visited again in the current traversal
        boolean[] order = new boolean[V];

        boolean ans = false;
        for(int i = 0; i < V; i++) {
            ans = dfs(adj, i, visited, order);
            if(ans)
                return true;
        }

        return false;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int V = sc.nextInt();
        int E = sc.nextInt();
        for(int i = 0; i < V+1; i++)
            list.add(i, new ArrayList<Integer>());
        for(int i = 0; i < E; i++)
        {
            int u = sc.nextInt();
            int v = sc.nextInt();
            list.get(u).add(v);
        }
        if(isCyclic(V, list))
            System.out.println("1");
        else System.out.println("0");
    }
}