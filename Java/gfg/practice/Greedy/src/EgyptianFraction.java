import java.util.Scanner;

public class EgyptianFraction {

    static void printUnit(int nr, int dr) {
        if(nr == 0 || dr == 0)
            return;

        int c = (int)Math.ceil((double)dr/(double) nr);
        System.out.print("1/"+ c + " ");

        printUnit(c*nr - dr, dr*c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nr = sc.nextInt();
        int dr = sc.nextInt();

        printUnit(nr, dr);
    }
}
