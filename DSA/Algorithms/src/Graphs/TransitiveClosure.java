package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class TransitiveClosure {

    public static ArrayList<ArrayList<Integer>> transitiveClosure(int n, int graph[][]) {
        ArrayList<ArrayList<Integer>> reach = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            reach.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                reach.get(i).add(graph[i][j]);
                if(reach.get(i).get(j) == 0 && i == j) {
                    reach.get(i).set(j, 1);
                }
            }
        }

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    int val = (reach.get(i).get(j) != 0) ||
                            ((reach.get(i).get(k) != 0) && (reach.get(k).get(j) != 0)) ? 1 : 0;
                    reach.get(i).set(j, val);
                }
            }
        }

        return reach;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] graph = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.println(transitiveClosure(n, graph));
    }
}

/* Sample
4
1 1 0 1
0 1 1 0
0 0 1 1
0 0 0 1

[
[1, 1, 1, 1],
[0, 1, 1, 1],
[0, 0, 1, 1],
[0, 0, 0, 1]
]

3
0 0 0
0 0 0
0 0 0

[[1, 0, 0],
[0, 1, 0],
[0, 0, 1]]
* */