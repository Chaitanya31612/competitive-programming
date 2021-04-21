package Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class isCycleDirected {

    private static boolean dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited,
                               boolean[] path) {
        if(path[s]) {
            return true;
        }

        if(visited[s]) {
            return false;
        }

        visited[s] = true;
        path[s] = true;

        for(int neigh : adj.get(s)) {
            if(dfs(adj, neigh, visited, path)) {
                return true;
            }
        }
        path[s] = false;

        return false;
    }

    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        // order tells whether node is visited again in the current traversal
        boolean[] path = new boolean[V];

        boolean ans = false;
        for(int i = 0; i < V; i++) {
            ans = dfs(adj, i, visited, path);
            if(ans)
                return true;
        }

        return false;
    }



    /* Space optimised approach */
    public static boolean isCyclicBetter(ArrayList<ArrayList<Integer>> adj) {
        // only one array inplace of two arrays
        /*
        * 0 - not visited and not in path
        * 1 - visited but not in path
        * 2 - visited and in path*/

        int[] visited = new int[adj.size()];

        for(int i = 0; i < adj.size(); i++) {
            if(visited[i] == 0) {
                if(isCyclicBetterUtil(adj, i, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isCyclicBetterUtil(ArrayList<ArrayList<Integer>> adj, int s,
                                              int[] visited) {
        visited[s] = 2;

        for(int neigh : adj.get(s)) {
            // if neigh is in path and visited
            if(visited[neigh] == 2) {
                return true;
            }

            if(visited[neigh] == 0) {
                if(isCyclicBetterUtil(adj, neigh, visited)) {
                    return true;
                }
            }
        }

        visited[s] = 1;
        return false;
    }


    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = sc.nextInt();
        int E = sc.nextInt();
        for(int i = 0; i < V+1; i++)
            adj.add(i, new ArrayList<Integer>());
        for(int i = 0; i < E; i++)
        {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
        }
        if(isCyclic(V, adj))
            System.out.println("1");
        else System.out.println("0");

        System.out.println(isCyclicBetter(adj));
    }
}