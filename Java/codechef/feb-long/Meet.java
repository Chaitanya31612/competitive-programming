import java.util.*;
import java.io.*;
import java.text.*;

public class Meet {

    static String parseDate(String str) throws ParseException {
        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
        Date date = parseFormat.parse(str);
        // System.out.println(parseFormat.format(date) + " = " + displayFormat.format(date));

        return displayFormat.format(date);
    }
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String P = sc.nextLine();
            String nP = parseDate(P);
            String ans = "";
            int N = sc.nextInt();
            sc.nextLine();
            while (N-- > 0) {
                String line = sc.nextLine();

                // System.out.println(line);
                String L = line.substring(0, 8);
                String R = line.substring(9);
                System.out.println(L + " " + R);
                String nL = parseDate(L);
                String nR = parseDate(R);

                // System.out.println(nP + " " + nL + " " + nR + " " + nL.replace(':', '.'));

                Double l = Double.parseDouble(nL.replace(':', '.'));
                Double r = Double.parseDouble(nR.replace(':', '.'));
                Double p = Double.parseDouble(nP.replace(':', '.'));

                if (p >= l && p <= r) {
                    ans += "1";
                } else {
                    ans += "0";
                }
            }
            System.out.println(ans);
        }
    }    
}
