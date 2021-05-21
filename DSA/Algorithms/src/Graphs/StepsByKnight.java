package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StepsByKnight {

    static class Cell {
        int x, y, dis;

        public Cell(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    public static boolean isSafe(int x, int y, int N) {
        return x >= 1 && x <= N && y >= 1 && y <= N;
    }

    public static int minStepToReachTarget(int[] KnightPos, int[] TargetPos, int n) {
        Queue<Cell> q = new LinkedList<>();

        boolean[][] visited = new boolean[n + 1][n + 1];

        int[] dx = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };

        q.add(new Cell(KnightPos[0], KnightPos[1], 0));
        visited[KnightPos[0]][KnightPos[1]] = true;

        while(!q.isEmpty()) {
            Cell front = q.poll();

            if(front.x == TargetPos[0] && front.y == TargetPos[1]) {
                return front.dis;
            }

            // try all reachable locations

            for(int i = 0; i < 8; i++) {
                int x = front.x + dx[i];
                int y = front.y + dy[i];



                if(isSafe(x, y, n) && !visited[x][y]) {
                    q.add(new Cell(x, y, front.dis + 1));
                    visited[x][y] = true;
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        n = n * n;
        int[] knightPos = new int[2];
        int[] targetPos = new int[2];

        knightPos[0] = sc.nextInt(); knightPos[1] = sc.nextInt();
        targetPos[0] = sc.nextInt(); targetPos[1] = sc.nextInt();

        System.out.println(minStepToReachTarget(knightPos, targetPos, n));
    }
}
