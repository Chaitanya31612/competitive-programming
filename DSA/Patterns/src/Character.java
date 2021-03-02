import java.util.Scanner;

public class Character {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print((char)('A' + j));
            }
            System.out.println();
        }

        System.out.println();

        for(int i = 0; i < n; i++) {
            char ch = (char)('A' + i);
            for(int j = 0; j < n; j++) {
                System.out.print((char)(ch + j));
            }
            System.out.println();
        }
    }
}
