import java.util.*;
import java.lang.*;

public class PrintPermutationLexi {
    static String swap(String str, int i, int j)
    {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

    public static void sortLexicographically(String strArr[])
    {
        for (int i = 0; i < strArr.length; i++) {
            for (int j = i + 1; j < strArr.length; j++) {
                if (strArr[i].compareToIgnoreCase(strArr[j])
                        > 0) {
                    String temp = strArr[i];
                    strArr[i] = strArr[j];
                    strArr[j] = temp;
                }
            }
        }
    }

    static void permute(String[] sArr, String s, int l, int r) {
        if(l == r) {
            sArr[Integer.parseInt(sArr[0])] = s;
            sArr[0] = String.valueOf(Integer.parseInt(sArr[0]) + 1);
            return;
        }

        for(int i = l; i <= r; i++) {
            s = swap(s, l, i);
            permute(sArr, s, l+1, r);
            s = swap(s, l, i);
        }
    }


    public static void main (String[] args)
    {
        //code
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0) {
            String s = sc.nextLine();
            int[] fact = {1,2,6,24,120};
            String[] sArr = new String[(int)(fact[s.length()-1] + 1)];
            sArr[0] = "1";
            permute(sArr, s, 0, s.length()-1);
//            sortLexicographically(sArr);
            Arrays.sort(sArr,
                    String.CASE_INSENSITIVE_ORDER);
            for(int i = 1; i < sArr.length; i++) {
                System.out.print(sArr[i] + " ");
            }
            System.out.println();
        }

    }
}
