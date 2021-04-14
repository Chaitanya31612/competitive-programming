import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DirectedList {

    public static int findParent(int v, int[] parent) {

        if(parent[v] == v) {
            return v;
        }

        return findParent(parent[v], parent);
    }

    public static boolean isCyclicUnion(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] parent = new int[V];
        for(int i = 0; i < V; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < adj.size(); i++) {
            for(int j = 0; j < adj.get(i).size(); j++) {

                int sourceParent = findParent(i, parent);
                int destParent = findParent(adj.get(i).get(j), parent);

                if(sourceParent == destParent) {
                    return true;
                }

                parent[i] = destParent;
            }
        }

        return false;
    }


    private static boolean isCyclic(int sv, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(sv);
        visited[sv] = true;

        while (!queue.isEmpty()) {
            sv = queue.poll();

            for (int n : adj.get(sv)) {
                if(visited[n]) {
                    return true;
                } else {
                    queue.add(n);
                    visited[n] = true;
                }
            }
        }

        return false;
    }

    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        boolean ans = false;
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                ans = isCyclic(i, adj, visited);

                if(ans) {
                    return true;
                }
            }
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