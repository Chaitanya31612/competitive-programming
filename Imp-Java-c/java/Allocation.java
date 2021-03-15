import java.util.*;

public class Allocation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int k = 1; k <= T; k++){
			int N = sc.nextInt();
			int B = sc.nextInt();
			int A[] = new int[N];
			for(int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}

			Arrays.sort(A);
			int count = 0, sum = 0;
			for(int i = 0; i < N; i++) {
				sum += A[i];
				if(sum <= B) {
					count++;
				} else {
					break;
				}
				
			}
			System.out.println("Case #" + k + ": " + count);
		}
	}
}