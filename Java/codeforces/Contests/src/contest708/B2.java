package contest708;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class B2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Long> list = new ArrayList<>(n);
            for(int i = 0; i < n; i++) {
                list.add(sc.nextLong());
            }

//            Collections.sort(list);

            int ind = 0, count = 0;
            while(list.size() > 0) {
                for(int i = 0; i < list.size(); i++) {
                    if(ind != i && list.get(i) != -1 && (list.get(ind) + list.get(i)) % m == 0) {
//                        list.set(ind, (long) -1);
                        list.remove(ind);
                        if(ind > i) {
                            ind = i;
                        } else {
                            ind = i-1;
                        }
                        i = -1;
                    }
                }

//                list.set(ind, (long) -1);
                list.remove(ind);
                ind = 0;
                count++;
            }

            output.write(count + "\n");
//            System.out.println(count);
        }
        output.flush();
    }

}