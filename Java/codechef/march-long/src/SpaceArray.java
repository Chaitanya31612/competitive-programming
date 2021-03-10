import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SpaceArray {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int sumN = (n*(n+1))/2;
            if(sum(arr) > sumN) {
                System.out.println("Second");
            } else {
                Arrays.sort(arr);
                String person = "";
                boolean flag = true;
                while(true) {
                    int count = 0;
                    for(int i = 0; i < n; i++) {
                        if(arr[i] < i+1) {
                            arr[i]++;
                            person = flag ? "First" : "Second";
                            flag = !flag;
                            count++;
                            break;
                        }
                    }
                    if(count == 0) {
                        System.out.println(person);
                        break;
                    }
                }

            }

        }
    }
}
