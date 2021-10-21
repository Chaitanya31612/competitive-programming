import java.util.Arrays;
import java.util.Scanner;

public class TransitiveClosure {
    public static void transitiveClosure(int[][] graph, int n) {
        int[][] reach = new int[n][n];

        reach = graph.clone();

        for(int k = 0; k < n; k++)
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    reach[i][j] = (reach[i][j] == 1) || (reach[i][k] == 1 && reach[k][j] == 1) ? 1 : 0;


        for(int[] arr : reach)
            System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] graph = new int[n][n];

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                graph[i][j] = sc.nextInt();

        transitiveClosure(graph, n);
    }
}
