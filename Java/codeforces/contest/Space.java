import java.util.*;

public class Space {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int px = sc.nextInt();
            int py = sc.nextInt();

            sc.nextLine();
            String s = sc.nextLine();
            char[] sArray = s.toCharArray();

            int U = 0, D = 0, R = 0, L = 0;
            for (int i = 0; i < sArray.length; i++) {
                if (sArray[i] == 'U') {
                    U++;
                } else if (sArray[i] == 'D') {
                    D++;
                } else if (sArray[i] == 'R') {
                    R++;
                } else if (sArray[i] == 'L') {
                    L++;
                }
            }

            boolean xcheck = false, ycheck = false;

            if (px > 0) {
                if (R >= px) {
                    xcheck = true;
                }
            } else {
                if (L >= -px) {
                    xcheck = true;
                }
            }

            if (py > 0) {
                if (U >= py) {
                    ycheck = true;
                }
            } else {
                if (D >= -py) {
                    ycheck = true;
                }
            }

            if (xcheck && ycheck) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
