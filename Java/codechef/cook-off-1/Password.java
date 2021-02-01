import java.util.*;

public class Password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        while (T-- != 0) {
            String str = sc.nextLine();
            boolean lower = false, upper = false, digit = false, special = false;

            if (str.length() >= 10) {
                for (int i = 0; i < str.length(); i++) {
                    char ch = str.charAt(i);
                    int asciich = (int) ch;
    
                    if (lower && upper && digit && special) {
                        break;
                    } else {
                        if (asciich >= 65 && asciich <= 90 && i != str.length() - 1) {
                            upper = true;
                        } else if (asciich >= 97 && asciich <= 122) {
                            lower = true;
                        } else if (asciich >= 48 && asciich <= 57 && i != str.length() - 1) {
                            digit = true;
                        } else if ((asciich == 63 || asciich == 64 || asciich == 35 || asciich == 37 || asciich == 38) && i != str.length() - 1) {
                            special = true;
                        }
                    }
                }
                if (lower && upper && digit && special) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
            
        }
    }
}