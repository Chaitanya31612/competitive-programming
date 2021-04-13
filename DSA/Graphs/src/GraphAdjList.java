import java.util.*;

public class GraphAdjList {

    private static void bfsOfGraph(int sv, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> list) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(sv);
        visited[sv] = true;

        while (!queue.isEmpty()) {
            sv = queue.poll();
            list.add(sv);

//            for(int i = 0; i < adj.get(sv).size(); i++) {
//                if(!visited[adj.get(sv).get(i)]) {
//                    queue.add(adj.get(sv).get(i));
//                    visited[adj.get(sv).get(i)] = true;
//                }
//            }

            /* OR */
            for (int n : adj.get(sv)) {
                if (!visited[n]) {
                    queue.add(n);
                    visited[n] = true;
                }
            }
        }
    }

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                bfsOfGraph(i, adj, visited, list);
            }
        }
        return list;
    }


    private static void dfsOfGraph(int s, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> list) {
        list.add(s);
        visited[s] = true;

//        for(int i = 0; i < adj.get(s).size(); i++) {
//            if(!visited[adj.get(s).get(i)]) {
//                dfsOfGraph(adj.get(s).get(i), adj, visited, list);
//            }
//
//        }

        /* OR */
        for(int n : adj.get(s)) {
            if(!visited[n]) {
                dfsOfGraph(n, adj, visited, list);
            }
        }

    }

    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean[] visited = new boolean[V];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                dfsOfGraph(i, adj, visited, list);
            }
        }

        return list;
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

    /* Check for cycle in graph */
//    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
//
//    }



    public static boolean hasPathBFS(ArrayList<ArrayList<Integer>> adj, int v1, int v2) {
        if(v1 == v2) {
            return true;
        }

        int V = adj.size();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v1);
        visited[v1] = true;

        while (!queue.isEmpty()) {
            v1 = queue.poll();

            for(int neigh : adj.get(v1)) {
                if(neigh == v2) {
                    return true;
                }

                if(!visited[neigh]) {
                    queue.add(neigh);
                    visited[neigh] = true;
                }
            }
        }


        return false;
    }


    public static boolean hasPathDFS(ArrayList<ArrayList<Integer>> adj, int v1, int v2) {
        boolean[] visited = new boolean[adj.size()];

        return hasPathDFS(adj, v1, v2, visited);
    }

    private static boolean hasPathDFS(ArrayList<ArrayList<Integer>> adj, int v1, int v2, boolean[] visited) {
        if(v1 == v2) {
            return true;
        }

        visited[v1] = true;

        boolean ans = false;
        for(int i : adj.get(v1)) {
            if(!visited[i]) {
                ans = hasPathDFS(adj, i, v2, visited);
            }
        }

        return ans;
    }


    public static boolean isConnected(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> list = new ArrayList<>();
        dfsOfGraph(0, adj, visited, list);

        for(int i = 0; i < adj.size(); i++) {
            if(!visited[i]) {
                return false;
            }
        }

        return true;
    }


    public static ArrayList<ArrayList<Integer>> connectedComponents(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < adj.size(); i++) {
            if(!visited[i]) {
                ArrayList<Integer> sublist = new ArrayList<>();
                dfsOfGraph(i, adj, visited, sublist);
                list.add(sublist);
            }
        }

        return list;
    }




//    public static int[] dijkstra(int V, ArrayList<ArrayList<Integer>> adj, int S) {
//        boolean[] visited = new boolean[V];
//        int[] distances = new int[V];
//        for(int i = 1; i < V; i++) {
//            distances[i] = Integer.MAX_VALUE;
//        }
//        distances[0] = 0;
//
//        for(int i = 0; i < V; i++) {
//            // find unvisited minimum distance
//            int minIndex = findMin(distances, visited);
//
//            visited[minIndex] = true;
//            for(int neigh : adj.get(i)) {
//                int curr_weight
//            }
//        }
//    }


    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        // number of vertices in graph
        int n = sc.nextInt();
        // number of edges in graph
        int e = sc.nextInt();

        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adjacencyList.get(v1).add(v2);
            adjacencyList.get(v2).add(v1);
        }

        printGraph(adjacencyList);
        System.out.println(dfsOfGraph(n, adjacencyList));
        System.out.println(bfsOfGraph(n, adjacencyList));

        System.out.println(hasPathBFS(adjacencyList, 1, 3));
        System.out.println(hasPathDFS(adjacencyList, 1, 3));

        System.out.println(connectedComponents(adjacencyList));
    }
}
