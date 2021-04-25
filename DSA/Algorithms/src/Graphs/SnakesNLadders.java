package Algorithms;

import java.util.*;

public class SnakesNLadders {

    public static int bfs(ArrayList<ArrayList<Integer>> adjList, int src, int dest) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[35];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        queue.add(src);

        while(!queue.isEmpty()) {
            int front = queue.poll();

            for(int neigh : adjList.get(front)) {
                if(neigh < 31 && distance[neigh] == Integer.MAX_VALUE) {
                    distance[neigh] = distance[front] + 1;
                    queue.add(neigh);
                }
            }

        }

        return distance[dest];

    }

    public static int minThrow(int n, int[] arr) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        int[] board = new int[32];
        for(int i = 0; i < arr.length - 1; i += 2) {
            board[arr[i]] = arr[i + 1] - arr[i];
        }

        for(int i = 0; i <= 30; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int u = 0; u <= 30; u++) {
            for(int dice = 1; dice <= 6; dice++) {
                int v;
                if(u + dice > 31) {
                    v = u + dice;
                } else {
                    v = u + dice + board[u + dice];
                }

                adjList.get(u).add(v);
            }
        }

//        System.out.println(Arrays.toString(board));
//        System.out.println(adjList);

        return bfs(adjList, 1, 30);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[2 * n];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(minThrow(n, arr));
    }
}
