package Algorithms;

import java.util.*;

public class Bipartite {

    public static boolean isBipartite(ArrayList<ArrayList<Integer>> adj, int s) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(s);
        int[] colors = new int[adj.size()];
        Arrays.fill(colors, -1);
        colors[s] = 0;

        while(!queue.isEmpty()) {
            int front = queue.poll();
            
            for(int neighbour : adj.get(front)) {
                // not yet visited
                if(colors[neighbour] == -1) {
                    colors[neighbour] = 1 - colors[front];
                    queue.add(neighbour);
                }
                // violation of condition of bipartite graph
                else if(colors[neighbour] == colors[front]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        if(isBipartite(adj, 0)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
