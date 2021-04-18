package Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class JourneyToMoon {



    static int numCount = 0;
    private static void dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
        visited[s] = true;
        numCount++;
        for(int neigh : adj.get(s)) {
            if(!visited[neigh]) {
                dfs(adj, neigh, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int p = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < p; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        int total_ways = (n)*(n - 1)/2;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(adj, i, visited);
                total_ways -= (numCount)*(numCount - 1)/2;
                numCount = 0;
            }
        }

        System.out.println(total_ways);
    }
}
