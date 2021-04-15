import java.util.*;

public class GraphClass<T> {

    // this will be a template for creating graph using hashmap

    private HashMap<T, ArrayList<T>> adjList = new HashMap<>();


    // u - first vertex, v - second vertex, bidir - bidirectional
    public void addEdge(T u, T v, boolean bidir) {
        if(adjList.containsKey(u)) {
            adjList.get(u).add(v);
        } else {
            ArrayList<T> neighbors1 = new ArrayList<>();
            neighbors1.add(v);
            adjList.put(u, neighbors1);
        }


        if(bidir) {
            if(adjList.containsKey(v)) {
                adjList.get(v).add(u);
            } else {
                ArrayList<T> neighbors2 = new ArrayList<>();
                neighbors2.add(u);
                adjList.put(v, neighbors2);
            }
        }
    }

    public void print() {
        for(Map.Entry<T, ArrayList<T>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");

            for(T neigh : entry.getValue()) {
                System.out.print(neigh + " ");
            }
            System.out.println();
        }
    }


    /* bfs */
    public void bfs(T src) {
        HashMap<T, Boolean> visited = new HashMap<>();

        // number of components in the graph
        int component = 1;
        dfs(src, visited);

        for(Map.Entry<T, ArrayList<T>> entry : adjList.entrySet()) {
            if(!visited.containsKey(entry.getKey()) || !visited.get(entry.getKey())) {
                bfs(entry.getKey(), visited);
                component++;
            }
        }

        System.out.println("The current graph has " + component + " components");
    }

    private void bfs(T src, HashMap<T, Boolean> visited) {
        Queue<T> q = new LinkedList<>();


        q.add(src);
        visited.put(src, true);

        while(!q.isEmpty()) {
            T front = q.poll();
            System.out.print(front + " ");

            for(T neighbor : adjList.get(front)) {
                if(!visited.containsKey(neighbor)) {
                    q.add(neighbor);
                    visited.put(neighbor, true);
                }
            }
        }
        System.out.println();
    }


    /* Single source shortest path */
    public void singleShortestPath(T src) {
        Queue<T> q = new LinkedList<>();
        HashMap<T, T> parent = new HashMap<>();
        HashMap<T, Integer> distances = new HashMap<>();

        /* for finding single source shortest path set distance of all the nodes except source to
        * infinity then do a bfs(shortest path traversal) */

        for(Map.Entry<T, ArrayList<T>> entry : adjList.entrySet()) {
            distances.put(entry.getKey(), Integer.MAX_VALUE);
        }

        distances.put(src, 0);
        parent.put(src, src);
        q.add(src);

        while(!q.isEmpty()) {
            T front = q.poll();
            System.out.print(front + " ");

            for(T neighbor : adjList.get(front)) {
                if(distances.get(neighbor) == Integer.MAX_VALUE) {
                    q.add(neighbor);
                    distances.put(neighbor, distances.get(front) + 1);
                    parent.put(neighbor, front);
                }
            }
        }
        System.out.println();
        for(Map.Entry<T, ArrayList<T>> entry : adjList.entrySet()) {
            T node = entry.getKey();
            System.out.println("distance of " + node + " from " + src + " is " + distances.get(node));
        }
    }


    /* Snakes and ladder */
    public int snakesAndLadderUtil(T src, T dest) {
        Queue<T> q = new LinkedList<>();
        HashMap<T, T> parent = new HashMap<>();
        HashMap<T, Integer> distances = new HashMap<>();

        /* for finding single source shortest path set distance of all the nodes except source to
         * infinity then do a bfs(shortest path traversal) */

        for(Map.Entry<T, ArrayList<T>> entry : adjList.entrySet()) {
            distances.put(entry.getKey(), Integer.MAX_VALUE);
        }

        distances.put(src, 0);
        parent.put(src, src);
        q.add(src);

        while(!q.isEmpty()) {
            T front = q.poll();

            for(T neighbor : adjList.get(front)) {
                if(distances.containsKey(neighbor) && distances.get(neighbor) == Integer.MAX_VALUE) {
                    q.add(neighbor);
                    distances.put(neighbor, distances.get(front) + 1);
                    parent.put(neighbor, front);
                }
            }
        }

//        for(Map.Entry<T, ArrayList<T>> entry : adjList.entrySet()) {
//            T node = entry.getKey();
//            System.out.println("distance of " + node + " is " + distances.get(node));
//        }

        T temp = dest;
        while(temp != src) {
            System.out.print(temp + " <-- ");
            temp = parent.get(temp);
        }
        System.out.println(src);

        return distances.get(dest);
    }


    /* DFS */
    public void dfs(T src) {
        HashMap<T, Boolean> visited = new HashMap<>();

        // number of components in the graph
        int component = 1;
        dfs(src, visited);

        for(Map.Entry<T, ArrayList<T>> entry : adjList.entrySet()) {
            if(!visited.containsKey(entry.getKey()) || !visited.get(entry.getKey())) {
                dfs(entry.getKey(), visited);
                component++;
            }
        }

        System.out.println();
        System.out.println("The current graph has " + component + " components");
    }

    private void dfs(T src, HashMap<T, Boolean> visited) {
        System.out.print(src + " ");

        visited.put(src, true);

        for(T neigh : adjList.get(src)) {
            if(!visited.containsKey(neigh) || !visited.get(neigh)) {
                dfs(neigh, visited);
            }
        }
    }


    /* Topological sort using dfs*/

    public void dfsTopologicalSort() {
        HashMap<T, Boolean> visited = new HashMap<>();
        LinkedList<T> output = new LinkedList<>();

        for(Map.Entry<T, ArrayList<T>> entry : adjList.entrySet()) {
            if(!visited.containsKey(entry.getKey())) {
                dfsTopologicalSort(entry.getKey(), visited, output);
            }
        }

        for(T element : output) {
            System.out.print(element + " -> ");
        }
        System.out.println();
    }

    private void dfsTopologicalSort(T src, HashMap<T, Boolean> visited, LinkedList<T> output) {
        visited.put(src, true);

        if(adjList.containsKey(src)) {
            for(T neighbor : adjList.get(src)) {
                if(!visited.containsKey(neighbor)) {
                    dfsTopologicalSort(neighbor, visited, output);
                }
            }
        }

        output.addFirst(src);
    }


    /* topological sorting using bfs - kahn's algorithm */
    public void bfsTopologicalSort() {
        Queue<T> queue = new LinkedList<>();
        HashMap<T, Boolean> visited = new HashMap<>();
        HashMap<T, Integer> indegree = new HashMap<>();

        // initialize indegree and visited in maps for adding nodes
        for(Map.Entry<T, ArrayList<T>> entry : adjList.entrySet()) {
            T node = entry.getKey();
            visited.put(node, false);
            indegree.put(node, 0);
        }

        // initialize the indegree of every node
        for(Map.Entry<T, ArrayList<T>> entry : adjList.entrySet()) {
            T node = entry.getKey();

            for(T v : adjList.get(node)) {
                if(indegree.containsKey(v))
                    indegree.put(v, indegree.get(v) + 1);
                else
                    indegree.put(v, 1);
            }
        }

        // find out all the nodes with 0 indegree
        for(Map.Entry<T, ArrayList<T>> entry : adjList.entrySet()) {
            T node = entry.getKey();

            if(indegree.get(node) == 0) {
                queue.add(node);
            }
        }


        // start the algorithm
        while(!queue.isEmpty()) {
            T node = queue.poll();
            System.out.print(node + " -> ");

            if(adjList.containsKey(node)) {
                for(T neighbor : adjList.get(node)) {

                    indegree.put(neighbor, indegree.get(neighbor) - 1);

                    if(indegree.get(neighbor) == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }
    }

}
