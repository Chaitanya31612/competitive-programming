package Graphs;

import java.util.*;

public class ShortestPathUnweighted {

    static ArrayList<ArrayList<Integer>> graph;

    public static boolean bfs(int src, int des, int n, int[] dis, int[] par) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.add(src);
        visited[src] = true;
        dis[src] = 0;

        while(!q.isEmpty()) {
            int front = q.poll();

            for(int neigh : graph.get(front)) {
                if(!visited[neigh]) {
                    visited[neigh] = true;
                    q.add(neigh);
                    dis[neigh] = dis[front] + 1;
                    par[neigh] = front;

                    // checking condition
                    if(neigh == des) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for(int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        int src = sc.nextInt();
        int des = sc.nextInt();
        int[] dis = new int[n];
        int[] par = new int[n];

        Arrays.fill(dis, Integer.MAX_VALUE);
        Arrays.fill(par, -1);

        if(!bfs(src, des, n, dis, par)) {
            System.out.println("Not Connected");
        }

        System.out.println(Arrays.toString(dis));
        System.out.println(Arrays.toString(par));
    }
}
/*
8 10
0 1
0 3
1 2
3 4
3 7
4 5
4 6
4 7
5 6
6 7
0 7
* */