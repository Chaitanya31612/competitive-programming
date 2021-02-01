import java.util.*;
import java.lang.*;

public class Lapindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		while(T-- > 0) {
			String S = sc.next();

			String str1, str2;
			int n = S.length();
			if(n % 2 == 0) {
				str1 = S.substring(0, (n/2));
				str2 = S.substring((n/2));
			} else {
				str1 = S.substring(0, (n/2));
				str2 = S.substring((n/2 + 1));
			}
			// System.out.println(str1 + " " + str2);

			char[] charArray1 = str1.toCharArray();
			char[] charArray2 = str2.toCharArray();
			Arrays.sort(charArray1);
			Arrays.sort(charArray2);
			String newstr1 = new String(charArray1);
			String newstr2 = new String(charArray2);
			// System.out.println(new String(charArray1));
			// System.out.println(newstr2);
			if(newstr1.equals(newstr2)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}