//package educational106;

import java.util.Scanner;

public class B {

    public static String getSorted(String str) {
        int fromInd = 0;
        while (true) {
            int ind = str.indexOf("00", fromInd);
            if(ind == -1) {
                return "YES";
            } else {
                int oneind = str.indexOf("11");
                if(oneind == -1) {
                    return "YES";
                } else if(oneind < ind){
                    return "NO";
                } else {
                    fromInd = ind + 2;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0) {
            String str = sc.nextLine();

            System.out.println(getSorted(str));

        }
    }
}
