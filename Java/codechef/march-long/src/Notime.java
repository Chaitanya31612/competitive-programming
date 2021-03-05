import java.util.Scanner;

public class Notime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int x = sc.nextInt();

        int[] T = new int[n];
        for(int i = 0; i < n; i++) {
            T[i] = sc.nextInt();
        }
        String ans = "NO";

        if(x >= h) {
            ans = "YES";
        } else {
            for(int i = 0; i < n; i++) {
                if(x+T[i] >= h) {
                    ans = "YES";
                    break;
                }
            }
        }
        System.out.println(ans);

    }
}
