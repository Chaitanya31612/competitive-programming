package Backtracking;

import java.util.Scanner;

public class Sudoku {

    static boolean isSafe(int[][] grid, int row, int col, int num) {
        // check in row
        for(int i = 0; i < grid[0].length; i++) {
            if(grid[row][i] == num) {
                return false;
            }
        }

        // check in column
        for(int i = 0; i < grid.length; i++) {
            if(grid[i][col] == num) {
                return false;
            }
        }

        // check in 3 X 3 square
        int sqrt = (int)Math.sqrt(grid.length); // 3
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart; d < boxColStart + sqrt; d++) {
                if (grid[r][d] == num) {
                    return false;
                }
            }
        }


        return true;
    }

    static boolean SolveSudoku(int[][] grid) {
        boolean isFull = true;
        int row = -1, col = -1;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                // if any index is empty
                if(grid[i][j] == 0) {
                    row = i;
                    col = j;

                    isFull = false;
                    break;
                }
            }
            if(!isFull) {
                break;
            }
        }

        if(isFull) {
            return true;
        }

        for(int num = 1; num <= grid.length; num++) {
            if(isSafe(grid, row, col, num)) {
                grid[row][col] = num;

                if(SolveSudoku(grid)) {
                    return true;
                }

                grid[row][col] = 0;
            }
        }

        return false;
    }

    static void printGrid (int grid[][]) {
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[])
    {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                    grid[i][j] = sc.nextInt();
            }


            if(SolveSudoku(grid))
                printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();

        }
    }
}

/* Sample input
3 0 6 5 0 8 4 0 0
5 2 0 0 0 0 0 0 0
0 8 7 0 0 0 0 3 1
0 0 3 0 1 0 0 8 0
9 0 0 8 6 3 0 0 5
0 5 0 0 9 0 6 0 0
1 3 0 0 0 0 2 5 0
0 0 0 0 0 0 0 7 4
0 0 5 2 0 6 3 0 0
*/
