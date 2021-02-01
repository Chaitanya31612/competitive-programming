import java.util.*;

public class Sumtrian {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0) {
			int n = sc.nextInt();
			int[][] a = new int[n][n];

			for(int i = 0; i < n; i++) {
				for(int j = 0; j <= i; j++) {
					a[i][j] = sc.nextInt();
				}
			}

			for(int i = n - 1; i > 0; i--) {
				for(int j = 0; j < i; j++) {
					if(a[i][j] > a[i][j+1]) {
						a[i-1][j] += a[i][j];
					} else {
						a[i-1][j] += a[i][j+1];
					}
				}
			}

			System.out.println(a[0][0]);
		}
	}
}