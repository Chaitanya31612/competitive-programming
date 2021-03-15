import java.util.*;

public class seiveOfEratosthenes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// boolean array with true as prime 
		boolean prime[] = new boolean[n+1];
		for(int i = 2; i < n; i++) {
			prime[i] = true;
		}

		for(int p = 2; p * p <= n; p++) {
			if(prime[p] == true) {
				for(int i = p * p; i <= n; i+=p) {
					prime[i] = false;
				}
			}
		}

		for (int i = 2; i <= n; i++) {
			if(prime[i]) {
				System.out.println(i);
			}
		}
	}
}


// public static String checkPrime(int n) {
//         for(int i = 2; i * i <= n; i++) {
//             if(n % i == 0) {
//                 return "Not prime";
//             }
//         }
//         return "Prime";
//     }

