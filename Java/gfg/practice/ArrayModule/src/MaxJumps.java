import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxJumps {

    static int minJumps(int[] arr) {
        // your code here
        int len = arr.length;
        int steps = 0, jump = 0, cur = 0;

        if (len <= 1)
            return 0;

        if (arr[0] == 0) {
            return -1;
        }

        for (int i = 0; i < len; i++) {

            if (cur >= len - 1) {
                return jump;
            }

            jump++;
            int idx = cur;
            for (int j = 1; j <= arr[cur]; j++) {
                if (cur + j >= len - 1) {
                    return jump;
                }
                if(arr[cur + j] == 0) {
                    continue;
                }
                if (arr[cur + j] > steps) {
                    steps = arr[cur + j];
                    idx = cur + j;
                }
            }
            if(idx == cur)
                return -1;
            steps = 0;
            cur = idx;
        }

        return jump;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        String[] arrStr = ((String) br.readLine()).split("\\s+");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        System.out.println(minJumps(arr));

    }

}