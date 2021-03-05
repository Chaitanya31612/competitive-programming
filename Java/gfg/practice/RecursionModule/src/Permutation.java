import java.util.Scanner;

public class Permutation {

    static String swap(String str, int i, int j)
    {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

    static void permute(String s, int l, int r) {
        if(l == r) {
            System.out.println(s);
            return;
        }

        for(int i = l; i <= r; i++) {
            s = swap(s, l, i);
            permute(s, l+1, r);
            s = swap(s, l, i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        permute(s, 0, s.length()-1);
    }
}
