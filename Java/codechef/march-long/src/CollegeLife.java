import java.util.Arrays;

public class CollegeLife {

    static String min(int a, int b, int c) {
        if (a <= b && a <= c)
            return "a";

        else if (b <= a && b <= c)
            return "b";

        else
            return "c";

    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int e = sc.nextInt();
            int h = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int[] temp = new int[3];
            temp[0] = a;
            temp[1] = b;
            temp[2] = c;
            Arrays.sort(temp);

            String[] arr = new String[3];
            arr[0] = min(a, b, c);
            if(arr[0] == "a") {
                arr[1] = b < c ? "b" : "c";
                arr[2] = b > c ? "b" : "c";
            } else if(arr[0] == "b"){
                arr[1] = a < c ? "a" : "c";
                arr[2] = a > c ? "a" : "c";
            } else if(arr[0] == "c"){
                arr[1] = b < a ? "b" : "a";
                arr[2] = b > a ? "b" : "a";
            }

            int mincost = 0, count = 0;
            if((e == 0 && h == 0) || (e < n && h < n)) {
                System.out.println(-1);
            } else {
                if(e == n && h == n) {
                    mincost = n*c;
                } else if(e == 0 && (h/3) >= n) {
                    mincost = n*b;
                } else if(h == 0 && (e/2) >= n) {
                    mincost = n * a;
                } else {
                    if(temp[0] > 0 && count < n) {
                        if (arr[0] == "a") {
                            count += e/2;
                            e = e%2;
                        } else if(arr[0] == "b") {
                            count += h/3;
                            h = h%3;
                        } else if(arr[0] == "c") {
//                            count += ;

                        }
                    } else if(temp[1] > 0 && count < n) {
                        if (arr[1] == "a") {

                        } else if(arr[1] == "b") {

                        } else if(arr[1] == "c") {

                        }
                    } else if(temp[2] > 0 && count < n) {
                        if (arr[2] == "a") {

                        } else if(arr[2] == "b") {

                        } else if(arr[2] == "c") {

                        }
                    }
                }

//                else {
//                    System.out.println(-1);
//                }
            }
        }
    }
}
