package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Articulation {

    static int n, e;
    static ArrayList<ArrayList<Integer>> graph;
    // lowest time, discovery time
    static int[] low, dis;
    static boolean[] visited;
    static ArrayList<Integer> art_points;
    static ArrayList<ArrayList<Integer>> bridges;

    public static void scan_and_memset() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        e = sc.nextInt();

        // 1 based indexing
        graph = new ArrayList<>(n + 1);
        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        low = new int[n + 1];
        dis = new int[n + 1];
        visited = new boolean[n + 1];
        art_points = new ArrayList<>();
        bridges = new ArrayList<>();
    }

    public static void dfs(int node, int disTime, int par) {
        dis[node] = disTime;
        visited[node] = true;
//        low[node] = Integer.MAX_VALUE;
        low[node] = disTime;
        int num_child = 0;

        for(int child : graph.get(node)) {
            if(!visited[child]) {
                num_child++;
                dfs(child, disTime + 1, node);
                low[node] = Math.min(low[node], low[child]);

                // articulation points
                if(low[node] >= dis[node]) {
                    art_points.add(node);
                }
                 // articulation bridges
                if(low[node] > dis[node]) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(node);
                    temp.add(child);
                    bridges.add(temp);
                }
            }
            // found backedge which is visited but not to it's parent
            else if(child != par) {
                low[node] = Math.min(low[node], dis[child]);
            }
        }

        // checking for the root node, root can be a articulation point only when it has 2
        // or more children as then only will the connected components increase
        if(num_child >= 2 && par == -1) {
            art_points.add(node);
        }
    }

    public static void main(String[] args) {
        scan_and_memset();
        dfs(1, 1, -1);

        System.out.println(Arrays.toString(dis));
        System.out.println(Arrays.toString(low));
    }
}

/* Sample Input
8 9
1 2
1 3
2 4
2 5
4 5
3 6
6 7
6 8
3 7

Output
discovery time = [0, 1, 2, 2, 3, 4, 3, 4, 4]
lowest time = [0, 1, 2, 2, 2, 2, 2, 2, 4]
* */