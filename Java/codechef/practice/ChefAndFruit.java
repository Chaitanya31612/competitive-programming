import java.util.*;

public class ChefAndFruit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();

            while (K != 0) {
                if (N == M) {
                    // if (K % 2 == 0) {
                        N += K / 2;
                        M += K / 2;
                        K = 0;
                        break;
                    // }
                    // else {
                    //     N += (K - 1) / 2;
                    //     M += (K - 1) / 2;
                    //     K = 1;
                    // }
                } else if (N > M) {
                    if (K >= N - M) {
                        M = N;
                        K -= N - M;
                    } else {
                        M += K;
                        K = 0;
                    }
                } else if (M > N) {
                    if (K >= M - N) {
                        N = M;
                        K -= M - N;
                    } else {
                        N += K;
                        K = 0;
                    }
                }
            }
            
            System.out.println(Math.abs(N - M));
        }
    }
}
