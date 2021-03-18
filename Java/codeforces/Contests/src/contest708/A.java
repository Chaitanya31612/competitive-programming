package contest708;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class A {
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
//            int[] arr = new int[n];
//            for(int i = 0; i < n; i++) {
//                arr[i] = sc.nextInt();
//            }
//
//            Arrays.sort(arr);

            Collections.sort(list);
            ArrayList<Integer> list2 = new ArrayList<>();

            int c = 0;
            while (c < list.size() - 1){
                if(list.get(c) == list.get(c+1)) {
                    int temp = list.get(c);
                    list.remove(c);
                    list2.add(temp);
                }
                c++;
            }
            Collections.sort(list2, Collections.reverseOrder());
            for(int i = 0; i < list2.size(); i++) {
                list.add(list2.get(i));
            }
//            System.out.println(list);
            for(int i = 0; i < n; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}
