package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RatInMaze {

    static int numPaths;

    private boolean isSafe(int[][] maze, int i, int j, int m, int n) {
        if(i >= m || j >= n)
            return false;

        if(maze[i][j] == 0) {
            return false;
        }

        return true;
    }

    private boolean isSafe(int[][] maze, boolean[][] visited, int i, int j, int m, int n) {

        if(i < 0 || i >= m || j >= n || j < 0) {
            return false;
        }

        if(maze[i][j] == 0) {
            return false;
        }

        if(visited[i][j])
            return false;

        return true;
    }

    public boolean ratInMaze(int[][] maze, int[][] soln, int i, int j, int m, int n) {
        // base case
        if(i == m - 1 && j == n - 1) {
            numPaths++;
            soln[i][j] = 1;
            // print the solution path
            System.out.println("Output");
            for(int[] arr: soln) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();
            return true;
        }

        if(isSafe(maze, i, j, m, n)) {
            soln[i][j] = 1;
            boolean rightSuccess = ratInMaze(maze, soln, i, j + 1, m, n);
            boolean downSuccess = ratInMaze(maze, soln, i + 1, j, m, n);

            // backtracking - is done while coming back
            soln[i][j] = 0;
            if(rightSuccess || downSuccess)
                return true;
        }

        return false;
    }


    /*GFG Problem*/
    // this will give the path for all possible directions, left(L), right(R), Up(U), Down(D)
    // array is n*n and we have to return arraylist of all the possible paths
    public ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> soln = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        findPathUtil(m, soln, visited, 0, 0, n);
        return soln;
    }

    static String move;
    private boolean findPathUtil(int[][] m, ArrayList<String> soln, boolean[][] visited, int i, int j, int n) {
        if(i == n - 1 && j == n - 1) {
//            soln.add(move);
            System.out.println(soln);
            return true;
        }

        if(isSafe(m, visited, i, j, n, n)) {
            visited[i][j] = true;

            soln.add("D");
            boolean downSuccess = findPathUtil(m, soln, visited, i + 1, j, n);
//            move = "D";
            if(!downSuccess) {
                soln.remove(soln.size() - 1);
            }

            soln.add("L");
            boolean leftSuccess = findPathUtil(m, soln, visited, i, j - 1, n);
//            move = "L";
            if(!leftSuccess) {
                soln.remove(soln.size() - 1);
            }

            soln.add("R");
            boolean rightSuccess = findPathUtil(m, soln, visited, i, j + 1, n);
//            move = "R";
            if(!rightSuccess) {
                soln.remove(soln.size() - 1);
            }

            soln.add("U");
            boolean upSuccess = findPathUtil(m, soln, visited, i - 1, j, n);
//            move = "U";
            if(!upSuccess) {
                soln.remove(soln.size() - 1);
            }


            if(rightSuccess || leftSuccess || upSuccess || downSuccess) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] maze = new int[m][n];

        // 0 denotes location is blocked
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        // X denotes location is blocked
//        char[][] maze = {{
//                '0', '0', '0', '0',
//                '0', '0', 'X', '0',
//                '0', '0', '0', 'X',
//                '0', 'X', '0', '0'
//        }};

        int[][] soln = new int[m][n];


        RatInMaze r = new RatInMaze();
        numPaths = 0;
//        boolean ans = r.ratInMaze(maze, soln, 0, 0, m, n);
//        System.out.println(ans);
//        System.out.println("Number of paths are: " + numPaths);

        System.out.println(r.findPath(maze, n));
        System.out.println(numPaths);
    }
}

/* Sample Input
4 4
1 1 1 1
1 1 0 1
1 1 1 0
1 0 1 1


2.
4 4
1 0 0 0
1 1 0 1
1 1 0 0
0 1 1 1
* */