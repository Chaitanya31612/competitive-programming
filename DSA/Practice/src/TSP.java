import java.util.Scanner;

public class TSP {
    public static int tsp(int[][] graph, boolean[] visited, int currPos, int count, int cost, int ans, int n) {
        if(count == n && graph[currPos][0] > 0) {
            ans = Math.min(ans, cost + graph[currPos][0]);
            return ans;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i] && graph[currPos][i] > 0) {
                visited[i] = true;
                ans = tsp(graph, visited, i, count + 1, cost + graph[currPos][i], ans, n);
                visited[i] = false;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                graph[i][j] = sc.nextInt();

        boolean[] visited = new boolean[n];
        visited[0] = true;

        int ans = Integer.MAX_VALUE;
        ans = tsp(graph, visited, 0, 1, 0, ans, n);
        System.out.println(ans);
    }
}
