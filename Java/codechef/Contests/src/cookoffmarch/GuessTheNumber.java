package cookoffmarch;

import java.io.*;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = sc.nextInt();
        while(t-- > 0) {
            double l = 1;
            double r = Math.pow(10,6);


            for(int i = 1; i <= 1000; i++) {
                // perfect square numbers have odd number of factors
                int num = i*i;
                System.out.println(num);
                System.out.flush();

                int response = sc.nextInt();
                if(response == 1) {
                    break;
                } else if(response == 0) {
                    continue;
                } else if(response == -1) {
                    System.exit(0);
                }
            }
        }

    }
}
