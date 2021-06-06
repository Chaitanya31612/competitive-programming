package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NoOfIslands
{
    static int[][] graph;
    static int n, m;

    public boolean isSafe(int row, int col, boolean[][] visited) {
        if(row >= 0 && row < n && col >= 0 && col < m &&
                (graph[row][col] == 1 && !visited[row][col])) {
            return true;
        }

        return false;
    }

    public void dfs(int row, int col, boolean[][] visited) {
        int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

        visited[row][col] = true;

        for(int i = 0; i < 8; i++) {
            // checks bounds as well as visited check
            if(isSafe(row + dx[i], col + dy[i], visited)) {
                dfs(row + dx[i], col + dy[i], visited);
            }
        }
    }

    public int numIslands(char[][] grid)
    {
        n = grid.length;
        m = grid[0].length;
        graph = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                graph[i][j] = Character.getNumericValue(grid[i][j]);
            }
        }


        int count = 0;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(graph[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = S[j].charAt(0);
                }
            }

            NoOfIslands no = new NoOfIslands();
            int ans = no.numIslands(grid);
            System.out.println(ans);
        }
    }
}