import java.util.*;

public class Wines_Problem {
	public static void main(String[] args) {
		int wines[] = {2, 3, 5, 1, 4};
		int n = wines.length;
		int y = 1;
		int dp[][] = new int[100][100];
		System.out.println(profit(wines, 0, n-1, y, dp));

	}

	public static int profit(int wines[], int i, int j, int y, int dp[][]) {
		// Base Case 
		if(i>j) {
			return 0;
		}

		// dp problem
		if(dp[i][j] != 0){
			return dp[i][j];
		}

		// Recursive Case
		int op1 = wines[i]*y + profit(wines, i+1, j, y+1, dp);
		int op2 = wines[j]*y + profit(wines, i, j-1, y+1, dp);
		return dp[i][j] = Math.max(op1, op2);
	}
}