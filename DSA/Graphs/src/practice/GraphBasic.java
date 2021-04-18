package practice;

import java.util.*;

public class GraphBasic {

    private static void dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");

        for(int neigh : adj.get(s)) {
            if(!visited[neigh]) {
                dfs(adj, neigh, visited);
            }
        }
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];

        for(int i = 0; i < adj.size(); i++) {
            if(!visited[i]) {
                dfs(adj, i, visited);
            }
        }
    }


    /* Bfs */

    private static void bfs(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();

        q.add(s);
        visited[s] = true;

        while(!q.isEmpty()) {
            int front = q.poll();
            System.out.print(front + " ");

            for(int neigh : adj.get(front)) {
                if(!visited[neigh]) {
                    q.add(neigh);
                    visited[neigh] = true;
                }
            }
        }
    }

    public static void bfs(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];

        for(int i = 0; i < adj.size(); i++) {
            if(!visited[i]) {
                bfs(adj, i, visited);
            }
        }
    }


    /* Cycle detection */
    public static boolean hasCycle(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];

        for(int i = 0; i < adj.size(); i++) {
            if(!visited[i]) {
                boolean ans = hasCycleUtil(adj, i, visited);
                if(ans) {
                    return true;
                }
            }
        }

        return false;
    }

    /* using bfs*/
    private static boolean hasCycleUtil(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        int[] parent = new int[adj.size()];
        Arrays.fill(parent, -1);

        q.add(s);
        parent[s] = s;

        while(!q.isEmpty()) {
            int front = q.poll();

            for(int neigh : adj.get(front)) {
                if(visited[neigh] && parent[front] != neigh) {
                    return true;
                }

                if(!visited[neigh]) {
                    q.add(neigh);
                    visited[neigh] = true;
                    parent[neigh] = front;
                }
            }
        }

        return false;
    }


    /* cycle detection directed */
    public static boolean hasCycleDirected(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        boolean[] order = new boolean[adj.size()];

        // repeat on every edge and check during recursion that if it is visited
        for(int i = 0; i < adj.size(); i++) {
            boolean ans = hasCycleDirectedUtil(adj, i, visited, order);
            if(ans)
                return true;
        }

        return false;
    }

    private static boolean hasCycleDirectedUtil(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited,
                                                boolean[] order) {

        // if node is visited and is travelled in this single traversal only before backtracking
        if(order[s]) {
            return true;
        }

        if(visited[s]) {
            return false;
        }

        // none of the above
        visited[s] = true;
        order[s] = true;
        for(int neigh : adj.get(s)) {
            if(hasCycleDirectedUtil(adj, neigh, visited, order)) {
                return true;
            }
        }

        order[s] = false;
        return false;
    }


    public static LinkedList<Integer> topologicalSortDFS(ArrayList<ArrayList<Integer>> adj) {
        LinkedList<Integer> list = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];

        for(int i = 0; i < adj.size(); i++) {
            if(!visited[i]) {
                topologicalSortDFSUtil(adj, i, visited, list);
            }
        }

        return list;
    }

    private static void topologicalSortDFSUtil(ArrayList<ArrayList<Integer>> adj, int s,
                                               boolean[] visited, LinkedList<Integer> list) {
        visited[s] = true;

        for(int neigh : adj.get(s)) {
            if(!visited[neigh]) {
                topologicalSortDFSUtil(adj, neigh, visited, list);
            }
        }

        // add to front those who are at the last
        list.addFirst(s);
    }


    /* Bipartite graph */
    public static boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int[] colors = new int[adj.size()];
        Arrays.fill(colors, -1);
        colors[0] = 0;
        q.add(0);

        while(!q.isEmpty()) {
            int front = q.poll();

            for(int neigh : adj.get(front)) {
                if(colors[neigh] == -1) {
                    colors[neigh] = 1 - colors[front];
                    q.add(neigh);
                }

                else if(colors[neigh] == colors[front]) {
                    return false;
                }
            }
        }

        return true;
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        // directed or undirected
        boolean isBidir = false;

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

//        dfs(adj);

//        bfs(adj);

//        System.out.println(hasCycle(adj));

//        System.out.println(hasCycleDirected(adj));

//        System.out.println(topologicalSortDFS(adj));


    }
}
