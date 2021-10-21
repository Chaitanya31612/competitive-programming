import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort {
    public static void topologicalSort(ArrayList<ArrayList<Integer>> graph, int V) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                topologicalSortUtil(graph, i, visited, stack);
            }
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void topologicalSortUtil(ArrayList<ArrayList<Integer>> graph, int s, boolean[] visited, Stack<Integer> stack) {
        visited[s] = true;

        for(int neigh : graph.get(s)) {
            if(!visited[neigh]) {
                topologicalSortUtil(graph, neigh, visited, stack);
            }
        }

        stack.push(s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        int V = sc.nextInt();
        int e = sc.nextInt();
        for(int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        for(int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
        }

        topologicalSort(graph, V);
    }
}
