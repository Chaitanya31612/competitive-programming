package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphTraversal {

    private static void bfs(int[][] edges, int sv, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(sv);
        visited[sv] = true;

        while (!queue.isEmpty()){
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
        boolean[] visited = new boolean[edges.length];

        for(int i = 0; i < edges.length; i++) {
            if(!visited[i]) {
                bfs(edges, i, visited);
            }
        }
    }


    private static void dfs(int[][] edges, int sv, boolean[] visited) {
        System.out.println(sv);
        visited[sv] = true;

        for(int i = 0; i < edges.length; i++) {
            if(edges[sv][i] == 1 && !visited[i]) {
                dfs(edges, i, visited);
            }
        }
    }

    public static void dfs(int[][] edges) {
        boolean[] visited = new boolean[edges.length];

        for(int i = 0; i < edges.length; i++) {
            if(!visited[i]) {
                dfs(edges, i, visited);
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt();

        int[][] edges = new int[n][n];

        for(int i = 0; i < e; i++) {
            int fv = sc.nextInt();
            int sv = sc.nextInt();

            edges[fv][sv] = 1;
            edges[sv][fv] = 1;
        }

        dfs(edges);
        System.out.println("===================");
        bfs(edges);
    }
}
