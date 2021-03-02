import java.util.Scanner;

public class NoOfOnes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int b = 7;
//        System.out.println(n&(n-1));
        int check = n&(n-1);
        int count = 1;
        while(check!=0) {
            n = n&(n-1);
            check = n&(n-1);
            count++;
        }
        System.out.println(count);
    }
}
