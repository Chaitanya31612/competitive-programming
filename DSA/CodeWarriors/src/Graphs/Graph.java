import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {


    private static void bfs(int[][] edges, int sv, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(sv);
        visited[sv] = true;

        while(!queue.isEmpty()) {
            sv = queue.poll();
            System.out.println(sv);

            for(int i = 0; i < edges.length; i++) {
                if(edges[sv][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void bfs(int[][] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(edges, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt();


        int[][] edges = new int[n][n];

        for(int i = 0; i < e; i++) {
            int firstvertex = sc.nextInt();
            int secondvertex = sc.nextInt();

            edges[firstvertex][secondvertex] = 1;
            edges[secondvertex][firstvertex] = 1;
        }

        bfs(edges);
    }
}
