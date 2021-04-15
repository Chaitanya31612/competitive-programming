import java.util.ArrayList;
import java.util.Scanner;

public class GraphCB {

    public static ArrayList<ArrayList<Integer>> createAdjacencyList() {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        System.out.print("isBidirectional? ");
        boolean isBidirectional = sc.nextBoolean();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adj.get(v1).add(v2);
            if(isBidirectional)
                adj.get(v2).add(v1);

        }

        return adj;
    }

    public static void printAdjList(ArrayList<ArrayList<Integer>> adj) {
        for(int i = 0; i < adj.size(); i++) {
            System.out.print(i + " -> ");
            for(int vertex : adj.get(i)) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // create adjacency list
        ArrayList<ArrayList<Integer>> adj = createAdjacencyList();
        printAdjList(adj);

    }
}
