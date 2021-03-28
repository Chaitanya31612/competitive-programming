package startersmarch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Victory {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String[] input2 = input.readLine().split(" ");
        int r = Integer.parseInt(input2[0]);
        int o = Integer.parseInt(input2[1]);
        int c = Integer.parseInt(input2[2]);

        int cal = (20 - o) * 6 * 6;
        int btotal = cal + c;
        if(btotal > r) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
