import java.util.*;
import java.lang.*;

public class LeadGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] a = new int[n][2];

		while(n-- > 0) {
			for(int i = 0; i < n+1; i++) {
				for(int j = 0; j < 2; j++) {
					a[i][j] = sc.nextInt();
					if(i > 0) {
						a[i][j] += a[i-1][j];
					}
				}
			}

			// for(int i = 0; i < n; i++) {
			// 	for(int j = 0; j < 2; j++) {
			// 		System.out.println();
			// 		System.out.print(a[i][j]);
			// 	}
			// 	System.out.println();
			// }
			System.out.println(n + " " + a[n][0]);
			int[] lead = new int[n+1];
			int[] win = new int[n+1];
			for(int i = 0; i < n+1; i++) {
				// System.out.println(Arrays.toString(a[i]));
				int diff = a[i][0] - a[i][1];

				lead[i] = Math.abs(diff);
				if(diff > 0) {
					win[i] = 1;
				} else {
					win[i] = 2;
				}
				// System.out.println(diff + " " + win[i]);
			}

			int max = -1;
			int w = -1;
			for(int i = 0; i < n+1; i++) {
				if(lead[i] > max) {
					max = lead[i];
					w = win[i];
				}
			}

			if(max != -1 && w != -1) {
				System.out.println(w + " " + max);
			}

			// System.out.println(Arrays.toString(lead));
			// System.out.println(Arrays.toString(win));
		}
	}
}