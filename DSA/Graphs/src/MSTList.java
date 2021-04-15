import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class MSTList {

    public static int findMin(int[] weight, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for(int i = 0; i < weight.length; i++) {
            if((weight[i] < min) && !visited[i]) {
                min = weight[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static int spanningTreePrims(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        boolean[] visited = new boolean[V];
        int[] weights = new int[V];
        int[] parent = new int[V];

        for(int i = 1; i < V; i++) {
            weights[i] = Integer.MAX_VALUE;
        }
        weights[0] = 0;
        parent[0] = -1;

        for(int i = 0; i < V; i++) {
            int minIndex = findMin(weights, visited);

            visited[minIndex] = true;

            for(int j = 0; j < adj.get(minIndex).size(); j++) {
                // from list
                int edgeWeight = adj.get(minIndex).get(j).get(1);
                int edge = adj.get(minIndex).get(j).get(0);
                if((edgeWeight < weights[edge]) && !visited[edge]) {
                    weights[edge] = edgeWeight;
                    parent[edge] = minIndex;
                }
            }
        }

//        for(int i = 1; i < V; i++) {
//            if(parent[i] < i)
//                System.out.println(parent[i] + " " + i + " " + weights[i]);
//            else
//                System.out.println(i + " " + parent[i] + " " + weights[i]);
//        }

        int minWeight = 0;
        for(int i = 1; i < V; i++) {
            minWeight += weights[i];
        }

        return minWeight;
    }


    /* Kruskals */
    /* return MST weight */

    static class Edge implements Comparable<Edge> {
        int source;
        int dest;
        int weight;


        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static int findEdges(ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int E = 0;
        for(int i = 0; i < adj.size(); i++) {
            E += adj.get(i).size();
        }

        return E;
    }

    public static int findParent(int v, int[] parent) {
        if(parent[v] == v) {
            return v;
        }

        return findParent(parent[v], parent);
    }

    public static int spanningTreeKruskals(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int E = findEdges(adj) / 2;
        Edge[] input = new Edge[E];

        int ind = 0;
        for(int i = 0; i < E - 1; i++) {
            for(int j = 0; j < adj.get(i).size(); j++) {
                if(adj.get(i).get(j).get(0) > i) {
                    Edge edge = new Edge();
                    edge.source = i;
                    edge.dest = adj.get(i).get(j).get(0);
                    edge.weight = adj.get(i).get(j).get(1);

                    input[ind++] = edge;
                }
            }
        }

        Arrays.sort(input);

        Edge[] output = new Edge[V - 1];

        int[] parent = new int[V];
        for(int i = 0; i < V; i++) {
            parent[i] = i;
        }

        int count = 0;
        int i = 0;

        while(count != V - 1) {
            Edge currEdge = input[i];

            int sourceParent = findParent(currEdge.source, parent);
            int destParent = findParent(currEdge.dest, parent);

            if(sourceParent != destParent) {
                output[count] = currEdge;
                count++;

                parent[sourceParent] = destParent;
            }
            i++;
        }


        int minWeight = 0;
        for(int j = 0; j < V - 1; j++) {
            minWeight += output[j].weight;
        }

        return minWeight;
    }




    public static void main(String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        for(int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            ArrayList<Integer> t1 = new ArrayList<Integer>();
            ArrayList<Integer> t2 = new ArrayList<Integer>();
            t1.add(v);
            t1.add(w);
            t2.add(u);
            t2.add(w);
            adj.get(u).add(t1);
            adj.get(v).add(t2);
        }


//        System.out.println(spanningTreePrims(V, adj));

        System.out.println(spanningTreeKruskals(V, adj));

    }
}
