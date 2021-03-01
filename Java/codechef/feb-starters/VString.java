import java.util.*;

public class VString {
    static int maxZeros(int n) {
        // If there are no 1's or there is only
        // 1, then return -1
        if (n == 0 || (n & (n - 1)) == 0) {
            return -1;
        }
        // int size in java is 4 byte
        byte b = 4;
        // loop to find position of right most 1
        // here sizeof int is 4 that means total 32 bits
        int setBit = 1, prev = 0, i;
        for (i = 1; i <= b * 8; i++) {
            prev++;

            // we have found right most 1
            if ((n & setBit) == setBit) {
                setBit = setBit << 1;
                break;
            }

            // left shift setBit by 1 to check next bit
            setBit = setBit << 1;
        }

        // now loop through for remaining bits and find
        // position of immediate 1 after prev
        int max0 = Integer.MIN_VALUE, cur = prev;
        for (int j = i + 1; j <= b * 8; j++) {
            cur++;

            // if cuurent bit is set, then compare
            // difference of cur - prev -1 with
            // previous maximum number of zeros
            if ((n & setBit) == setBit) {
                if (max0 < (cur - prev - 1)) {
                    max0 = cur - prev - 1;
                }

                // update prev
                prev = cur;
            }
            setBit = setBit << 1;
        }
        return max0;
    }

    static String leftrotate(String str, int d) {
        String ans = str.substring(d) + str.substring(0, d);
        return ans;
    }

    // function that rotates s towards right by d
    static String rightrotate(String str, int d) {
        return leftrotate(str, str.length() - d);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int c = sc.nextInt();

            sc.nextLine();
            String str = sc.nextLine();
            int value = Integer.parseInt(str, 2);
            // System.out.println(value);
            System.out.println(maxZeros(value));
            if (maxZeros(value) <= c) {
                System.out.println("YES");
            } else {
                String str2 = str;
                int count = 0;
                while (true) {
                    str2 = rightrotate(str2, 1);
                    count++;
                    System.out.println(maxZeros(value) + str2);
                    if (maxZeros(value) <= c && count <= n) {
                        System.out.println("YES");
                        break;
                    } else if (count == n) {
                        System.out.println("NO");
                        break;
                    }
                }
            }
        }
    }
}
