package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class nQueensGFG {


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

    public static boolean nQueen(int[][] board, int row, ArrayList<ArrayList<Integer>> list) {
        if(row >= board.length) {
            return true;
        }

        for(int col = 0; col < board[0].length; col++) {
            if(isSafe(board, row, col)) {
                board[row][col] = 1;


                if(nQueen(board, row + 1, list)) {
                    // add in list
                    ArrayList<Integer> subList = new ArrayList<>();
                    for(int i = 0; i < board.length; i++) {
                        for(int j = 0; j < board[0].length; j++) {
                            // check in first column
                            if(board[i][j] == 1) {
                                subList.add(i + 1);
                            }
                        }
                    }

                    list.add(subList);
                }

                board[row][col] = 0;
            }
        }
        return false;
    }

    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        int[][] board = new int[n][n];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        nQueen(board, 0, list);

        return list;
    }

    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());


            ArrayList<ArrayList<Integer>> ans = nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}