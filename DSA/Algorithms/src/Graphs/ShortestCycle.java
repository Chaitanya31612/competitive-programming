package Algorithms;

import java.util.*;

public class ShortestCycle {

    public static int shortest_cycle(ArrayList<ArrayList<Integer>> adj, int v) {
        int ans = Integer.MAX_VALUE;

        // run bfs for each edge to cover all cycles which are not covered by single bfs or dfs
        for(int i = 0; i < v; i++) {
            Queue<Integer> q = new LinkedList<>();
            int[] distances = new int[v];
            Arrays.fill(distances, Integer.MAX_VALUE);

            int[] parent = new int[v];
            Arrays.fill(parent, -1);
            // distance from i to i is 0
            distances[i] = 0;
            parent[i] = i;
            q.add(i);

            while (!q.isEmpty()) {
                int front = q.poll();

                for(int neigh : adj.get(front)) {
                    // if node is unvisited
                    if(distances[neigh] == Integer.MAX_VALUE) {
                        distances[neigh] = distances[front] + 1;
                        parent[neigh] = front;
                        q.add(neigh);
                    }
                    // traverse to all neighbours except it's parent
                    else if(parent[front] != neigh) {
                        ans = Math.min(ans, distances[neigh] + distances[front] + 1);
                    }
                }
            }
        }

        // graph has no cycle
        if(ans == Integer.MAX_VALUE) {
            return 0;
        }

        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        // directed or undirected
        boolean isBidir = true;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adj.get(v1).add(v2);
            if(isBidir)
                adj.get(v2).add(v1);
        }


        System.out.println(shortest_cycle(adj, v));
    }
}

/* Sample Input
a.
5 5
0 1
0 4
1 2
1 3
2 3

3


b.
4 4
0 1
1 2
2 3
3 0

4
 */