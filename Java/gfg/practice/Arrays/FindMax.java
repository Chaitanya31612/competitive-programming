import java.util.*;

public class FindMax {
    public static void main(String[] args) {
        String str = "38293367";
        int[] arr = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = Integer.parseInt(str.substring(i, i+1));
        }
        
        Arrays.sort(arr);
        String newStr = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            newStr = newStr + arr[i];
        }
        System.out.println(newStr);
    }
}
