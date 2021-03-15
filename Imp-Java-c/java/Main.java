import java.util.Scanner;

public class Main {
    static void prime_sieve(int[] p) {
        for (int i = 3; i <= 10000; i += 2) {
            p[i] = 1;
        }
        
        for (int i = 3; i <= 10000; i += 2) {
            if (p[i] == 1) {
                for (int j = i * i; j <= 10000; j = j + i) {
                    p[j] = 0;
                }
            }
        }
        p[2] = 1;
        p[1] = p[0] = 0;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // int n = scanner.nextInt();
        
        int[] p = new int[10005];
        prime_sieve(p);

        // for (int i = 2; i < n; i++) {
        //     if(p[i] == 1)
        //     System.out.println(i + " ");
        // }
        int[] csum = new int[10005];
        
        for (int i = 1; i <= 10000; i++) {
            csum[i] = csum[i - 1] + p[i];
        }
        
        int T = scanner.nextInt();
        while (T-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(csum[b] - csum[a-1]);
        }
    }
}