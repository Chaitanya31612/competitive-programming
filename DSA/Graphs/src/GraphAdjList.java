import java.util.ArrayList;

public class GraphAdjList {
    private static void dfsOfGraph(int s, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> list) {
        list.add(s);
        visited[s] = true;

        for(int i = 0; i < adj.get(s).size(); i++) {
            if(adj.get(s).get(i) < adj.size() && !visited[adj.get(s).get(i)]) {
                dfsOfGraph(adj.get(s).get(i), adj, visited, list);
            }

        }

    }

    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < adj.size(); i++) {
            if(!visited[i]) {
                dfsOfGraph(i, adj, visited, list);
            }
        }

        return list;
    }

    static void addEdge(ArrayList<ArrayList<Integer> > adj,
                        int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // A utility function to print the adjacency list
    // representation of graph
    static void printGraph(ArrayList<ArrayList<Integer> > adj)
    {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex " + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> "+adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        // Creating a graph with 5 vertices
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        // Adding edges one by one
//        addEdge(adj, 0, 1);
//        addEdge(adj, 0, 4);
//        addEdge(adj, 1, 2);
//        addEdge(adj, 1, 3);
//        addEdge(adj, 1, 4);
//        addEdge(adj, 2, 3);
//        addEdge(adj, 3, 4);
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 2, 4);

        System.out.println(adj);
        printGraph(adj);

//        System.out.println(adj.get(2).get(1) < adj.size());
        System.out.println(dfsOfGraph(0, adj));
    }
}
