package Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class isCyclicUndirected {

    public static boolean bfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int s) {
        int[] parent = new int[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);

        while(!q.isEmpty()) {
            int front = q.poll();

            for(int neigh : adj.get(front)) {
                if(visited[neigh] && parent[front] != neigh) {
                    return true;
                }

                if(!visited[neigh]) {
                    q.add(neigh);
                    parent[neigh] = front;
                    visited[neigh] = true;
                }
            }
        }

        return false;

    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {


        boolean[] visited = new boolean[V];
        boolean ans = false;

        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                ans = bfs(adj, visited, i);
                if(ans) {
                    return true;
                }
            }
        }


        return false;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
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
            if(isCycle(V, list))
                System.out.println("1");
            else System.out.println("0");
        }
    }
}