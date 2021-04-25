package Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GroupScoreList {

    static int maxScore = Integer.MIN_VALUE;

    private static int bfs(ArrayList<ArrayList<Integer>> adj, int[] arr, int src, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true;
        int doubleCount = 0;
        int maxPoints = 0;

        while(!q.isEmpty()) {
            int front = q.poll();

            maxPoints = Math.max(maxPoints, arr[front]);
            doubleCount += adj.get(front).size();

            for(int neigh : adj.get(front)) {
                if(!visited[neigh]) {
                    q.add(neigh);
                    visited[neigh] = true;
                }
            }
        }

        return maxPoints + (doubleCount/2);
    }

    public static void bfs(ArrayList<ArrayList<Integer>> adj, int[] arr) {
        boolean[] visited = new boolean[adj.size()];

        for(int i = 0; i < adj.size(); i++) {
            if(!visited[i]) {

                int val = bfs(adj, arr, i, visited);
                maxScore = Math.max(maxScore, val);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }


        int n = num;
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            u = u - 1;
            v = v - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        bfs(adj, arr);
        System.out.println(maxScore);
    }
}
