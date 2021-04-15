package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TopologicalSort {

    private static void topoSortDFS(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited,
                                    ArrayList<Integer> output) {
        visited[src] = true;

        for(int neigh : adj.get(src)) {
            if(!visited[neigh]) {
                topoSortDFS(neigh, adj, visited, output);
            }
        }

        output.add(0, src);

    }

    public static int[] topoSortDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        ArrayList<Integer> output = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                topoSortDFS(i, adj, visited, output);
            }
        }

        int[] ans = new int[output.size()];
        for(int i = 0; i < output.size(); i++) {
            ans[i] = output.get(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adj.get(v1).add(v2);
        }

        int[] arr = topoSortDFS(v, adj);
        System.out.println(Arrays.toString(arr));
    }
}
