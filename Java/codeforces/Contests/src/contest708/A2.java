package contest708;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class A2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));


        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>(n);
            for(int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }

            Collections.sort(list);

            for(int i = 0; i < n-1; i++) {
                if(list.get(i) == list.get(i+1)) {
                    int temp = list.get(i);
                    list.remove(i);
                    list.add(temp);
                }
            }
            for(int i = 0; i < n; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}
