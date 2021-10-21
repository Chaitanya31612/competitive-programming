import java.util.Arrays;
import java.util.Scanner;

public class Kruskals {
    public static class Edge implements Comparable<Edge> {
        int source;
        int dest;
        int weight;

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void kruskals(Edge[] input, int n) {
        Arrays.sort(input);
        Edge[] output = new Edge[n - 1];
        int[] parent = new int[n];
        for(int i = 0; i < n; i++)
            parent[i] = i;

        int count = 0, i = 0;
        while(count != n - 1) {
            Edge edge = input[i];
            int sourceParent = findParent(edge.source, parent);
            int destParent = findParent(edge.dest, parent);
            if(sourceParent != destParent) {
                output[count] = edge;
                count++;
                parent[destParent] = sourceParent;
            }
            i++;
        }

        for(int j = 0; j < n -1; j++) {
            int s = output[j].source;
            int d = output[j].dest;
            int w = output[j].weight;
            System.out.println(Math.min(s, d) + " - " + Math.max(s, d) + " : " + w);
        }
    }

    public static int findParent(int v, int[] parent) {
        if(parent[v] == v) {
            return v;
        }

        return findParent(parent[v], parent);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        Edge[] input = new Edge[e];
        for(int i = 0; i < e; i++) {
            Edge edge = new Edge();
            edge.source = sc.nextInt();
            edge.dest = sc.nextInt();
            edge.weight = sc.nextInt();
            input[i] = edge;
        }

        kruskals(input, n);
    }
}
