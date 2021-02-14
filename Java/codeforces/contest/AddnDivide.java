import java.util.*;

public class AddnDivide {

	static int getCount(int a, int b) {
		int c = 0;
		while(a != 0) {
			a = a / b;
			c++;
		}
		return c;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while(t-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			int count = 0;
			if(b == 1) {
				b++;
				count++;
			}

			while(true) {
				int c1 = count;
				int c2 = count;

				int a1 = a;
				int b1 = b;
				c1 += getCount(a1, b1);
				a1 = a;
				b1++;
				c2 += getCount(a1, b1) + 1;
				if(c1 < c2) {
					count = c1;
					break;
				} else {
					count++;
					b++;
				}
			}

			System.out.println(count);
		}
	}
}