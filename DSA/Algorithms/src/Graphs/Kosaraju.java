package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Kosaraju {

    /* Used for finding number of strongly connected components
    * SCC - component in which we can reach every node from every vertex
    * single node is also a SCC */
    public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        // first calculate a list which contain node in their finishing time i.e add the node which is finished first
        // do dfs
        ArrayList<Integer> order = new ArrayList<>();

        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                dfs(adj, i, visited, order);
            }
        }


        // now reverse the graph i.e reverse edge direction
        ArrayList<ArrayList<Integer>> reversedGraph = reverseGraph(adj);

        /* reuse visited array for reverse order traversal */
        Arrays.fill(visited, false);

        /* now do bfs on reversed graph from reverse order in order list */
        /* increment ans for each traversal because each traversal is a strongly connected component */
        int ans = 0;
        for(int i = V - 1; i >= 0; i--) {
            if(!visited[order.get(i)]) {
                ans++;
                reverseDFS(reversedGraph, order.get(i), visited);
            }
        }


        return ans;

    }


    /* reverse dfs */
    private static void reverseDFS(ArrayList<ArrayList<Integer>> reversedGraph, int s, boolean[] visited) {
        visited[s] = true;

        for(int neigh : reversedGraph.get(s)) {
            if(!visited[neigh]) {
                reverseDFS(reversedGraph, neigh, visited);
            }
        }
    }


    /* reverse graph */
    private static ArrayList<ArrayList<Integer>> reverseGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> reversed = new ArrayList<>();
        for(int i = 0; i < adj.size(); i++) {
            reversed.add(new ArrayList<>());
        }

        for(int i = 0; i < adj.size(); i++) {
            for(int neigh : adj.get(i)) {
                reversed.get(neigh).add(i);
            }
        }

        return reversed;
    }


    /* dfs - for calculating order list */
    private static void dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, ArrayList<Integer> order) {
        visited[s] = true;

        for(int neigh : adj.get(s)) {
            if(!visited[neigh]) {
                dfs(adj, neigh, visited, order);
            }
        }

        order.add(s);
    }



    public static void main(String[] args) {
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


        System.out.println(kosaraju(V, adj));
    }
}


/* Sample Input
5 6
0 2
2 1
1 0
2 3
3 4
4 3

output
2


5 5
0 2
2 1
1 0
2 3
3 4

output
3
*
* */