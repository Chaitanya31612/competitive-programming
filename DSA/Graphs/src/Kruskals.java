import java.util.Arrays;
import java.util.Scanner;

public class Kruskals {

    public static class Edge implements Comparable<Edge> {
        int source;
        int dest;
        int weight;


        @Override
        public int compareTo(Edge o) {
            // sort in ascending order according to weight
            return this.weight - o.weight;
        }
    }


    /* UNION FIND Algorithm */
    /* kruskals algorithm for finding and printing the minimum spanning tree of a graph */
    public static void kruskals(Edge input[], int n) {
        // this will sort input array according to weight as we have override the compareTo method of Comparable class
        Arrays.sort(input);

        // the size is n - 1 as there are n - 1 edges for a minimum spanning tree
        Edge output[] = new Edge[n - 1];

        /* parent array which will store the immediate parent of a vertex and will be used to find
        * top level parent of array for finding if there is a path from source to destination
        * initially every node is a parent of itself */
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // count variable for keeping count of number of edges and for mst it should be n - 1
        int count = 0;
        // i is for the current edge on which we are working
        int i = 0;

        while(count != n - 1) {
            Edge currentEdge = input[i];

            int sourceParent = findParent(currentEdge.source, parent);
            int destParent = findParent(currentEdge.dest, parent);

            /* If they are not equal which means that we don't have any path from source to destination
            * initially so adding the edge will be safe */
            if(sourceParent != destParent) {
                output[count] = currentEdge;
                count++;

                // changing parent of source to destination
                parent[sourceParent] = destParent;
            }

            i++;
        }

        // print edges
        for(int j = 0; j < n - 1; j++) {
            // print source destination weight
            if(output[j].source < output[j].dest) {
                System.out.println(output[j].source + " " + output[j].dest + " " + output[j].weight);
            } else {
                System.out.println(output[j].dest + " " + output[j].source + " " + output[j].weight);
            }
        }

    }

    public static int findParent(int v, int[] parent) {
        /*
        [0, 1, 2, 3, 4, 5] - array initially, so recursion will end in base case
        [2, 1, 2, 3, 4, 5] - in this parent of 0 is 2
         */

        if(parent[v] == v) {
            return v;
        }

        return findParent(parent[v], parent);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // number of vertices
        int n = sc.nextInt();
        // number of edges
        int E = sc.nextInt();

        // array of edges which will store edge data
        Edge input[] = new Edge[E];

        for(int i = 0; i < E; i++) {
            // input[i] is initially null, so we have to create an object of type Edge
            input[i] = new Edge();
            input[i].source = sc.nextInt();
            input[i].dest = sc.nextInt();
            input[i].weight = sc.nextInt();
        }

        kruskals(input, n);
    }
}

/* Sample Input */
/*
6 11
0 1 2
0 2 4
2 3 6
1 3 1
2 4 9
4 5 5
3 5 7
4 3 11
2 5 10
2 1 8
0 3 3

output
1 3 1
0 1 2
0 2 4
4 5 5
3 5 7
 */