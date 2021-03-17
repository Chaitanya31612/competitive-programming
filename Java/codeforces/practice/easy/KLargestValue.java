package easy;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;
public class KLargestValue {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();
        int q = sc.nextInt();

        int a[] = new int[n];

        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        int one = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == 1) one++;
        }

        for (int i = 1; i <= q; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                int x = sc.nextInt();
                if (a[x - 1] == 1) { one--; } else {one++;}
                a[x - 1] = 1 - a[x - 1];
            } else {

                int k = sc.nextInt();
                if (one >= k) output.write(1 + "\n");
                else output.write(0 + "\n");
            }
        }

        output.flush();

    }
}