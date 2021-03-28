package lunchtimemarch;

import java.io.*;

public class Dinner2 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));


        int t = Integer.parseInt(input.readLine());
        while (t-- > 0) {
            String[] input2 = input.readLine().split(" ");
            long a = Long.parseLong(input2[0]);
            long y = Long.parseLong(input2[1]);
            long x = Long.parseLong(input2[2]);

            if(y > a) {
                System.out.println(x*a + 1);
            } else {
                System.out.println(x * y);
            }
        }
    }
}
