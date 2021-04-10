import java.util.Scanner;

public class CountNumberwith4 {

    public static boolean hasfour(int n) {
        String str = String.valueOf(n);
        return str.contains("4");
    }

    public static int countNumberswith4(int n) {
        if(n < 4) {
            return 0;
        }

        int[] storage = new int[n + 1];
        storage[0] = storage[1] = storage[2] = storage[3] = 0;


        for(int i = 4; i <= n; i++) {
            boolean has4  = hasfour(i);
            if(has4) {
                storage[i] = storage[i - 1] + 1;
            } else {
                storage[i] = storage[i - 1];
            }
        }

        return storage[n];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(countNumberswith4(n));
    }
}
