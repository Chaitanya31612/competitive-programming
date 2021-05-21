package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BellmanFordNegativeCycle {

    public static int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here

        int src = 0;
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        int e = edges.length;
        for(int i = 0; i < n - 1; i++) {
            for (int[] edge : edges) {
                int s = edge[0];
                int d = edge[1];
                int wt = edge[2];

                if (distance[s] != Integer.MAX_VALUE &&
                        distance[d] > distance[s] + wt) {
                    distance[d] = distance[s] + wt;
                }
            }
        }

        for (int[] edge : edges) {
            int s = edge[0];
            int d = edge[1];
            int wt = edge[2];

            if (distance[s] != Integer.MAX_VALUE &&
                    distance[d] > distance[s] + wt) {
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }

            int ans = isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }
}