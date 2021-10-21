package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NQueens {

    public static boolean isSafe(int[][] board, int row, int col) {
        // check in row
        for(int i = 0; i < board[0].length; i++) {
            if(board[row][i] == 1) {
                return false;
            }
        }

        // check that column
        for(int i = 0; i < board.length; i++) {
            if(board[i][col] == 1) {
                return false;
            }
        }

        // diagonals
        // left upward
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }

        // right upward
        for(int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++) {
            if(board[i][j] == 1) {
                return false;
            }
        }

        // bottom left
        for(int i = row + 1, j = col - 1; i < board[0].length && j >= 0; i++, j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }

        // bottom right
        for(int i = row + 1, j = col + 1; i < board[0].length && j < board[0].length; i++, j++) {
            if(board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static boolean nQueen(int[][] board, int row) {
        if (row >= board.length) {
            return true;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                if (nQueen(board, row + 1)) {
                    return true;
                }
                // backtracking step
                board[row][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] board = new int[n][n];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        System.out.println(nQueen(board, 0));

        for (int[] row : board)
            System.out.println(Arrays.toString(row));
    }
}

/*
4
true
[0, 1, 0, 0]
[0, 0, 0, 1]
[1, 0, 0, 0]
[0, 0, 1, 0]
* */