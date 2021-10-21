import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Traversals {
    public static void dfs(ArrayList<ArrayList<Integer>> graph, int s, boolean[] visited) {
        System.out.print(s + " ");
        visited[s] = true;

        for(int neigh: graph.get(s)) {
            if(!visited[neigh]) {
                dfs(graph, neigh, visited);
            }
        }
    }

    public static void bfs(ArrayList<ArrayList<Integer>> graph, int v) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];

        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty()) {
            int front = queue.poll();
            System.out.print(front + " ");

            for(int neigh : graph.get(front)) {
                if(!visited[neigh]) {
                    queue.add(neigh);
                    visited[neigh] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < v; i++)
            graph.add(new ArrayList<>());

        for(int i = 0; i < e; i++) {
            int u1 = sc.nextInt();
            int u2 = sc.nextInt();
            graph.get(u1).add(u2);
            graph.get(u2).add(u1);
        }

        boolean[] visited = new boolean[v];
        for(int i = 0; i < v; i++) {
            if(!visited[i]) {
                dfs(graph, i, visited);
            }
        }

        System.out.println();
        bfs(graph, v);
    }
}
