import java.util.*;

public class ClosingTweets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();

        ArrayList<String> clicks = new ArrayList<String>();

        while (k-- > 0) {
            String click = sc.nextLine();
            if (click.equals("CLOSEALL")) {
                clicks.clear();
                System.out.println(0);
            } else if (clicks.contains(click)) {
                clicks.remove(click);
                System.out.println(clicks.size());
            } else if (!clicks.contains(click)) {
                clicks.add(click);
                System.out.println(clicks.size());
            }

        }

        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        // int k = sc.nextInt();
        // sc.nextLine();
        // ArrayList<String> clicks = new ArrayList<String>();

        // for (int i = 0; i < k; i++) {
        //     String s = sc.nextLine();

        //     if (s.equals("CLOSEALL")) {
        //         clicks.clear();
        //         System.out.println(0);
        //     } else if (clicks.contains(s)) {
        //         clicks.remove(s);
        //         System.out.println(clicks.size());
        //     } else if (!clicks.contains(s)) {
        //         clicks.add(s);
        //         System.out.println(clicks.size());
        //     }
        // }
    }
}
