package aprilday;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int[] arr = new int[str.length()];
        for(int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - 'A';
        }
        boolean flag = false;
        for(int i = 2; i < str.length(); i++) {
            if(arr[i] != (arr[i-1] + arr[i-2]) % 26) {
                flag = true;
                System.out.println("NO");
                break;
            }
        }
        if(!flag)
            System.out.println("YES");
    }
}
