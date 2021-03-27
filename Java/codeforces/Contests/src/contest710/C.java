package contest710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class C {

    public static String[] findSubsequences(String str) {
        if(str.length() == 0) {
            return new String[]{""};
        }

        String[] smallAns = findSubsequences(str.substring(1));
        String[] ans = new String[2 * smallAns.length];

        // copy into ans
        for(int i = 0; i < smallAns.length; i++) {
            ans[i] = smallAns[i];
            ans[smallAns.length + i] = str.charAt(0) + smallAns[i];
        }

        return ans;
    }

    static void sort(String []s, int n)
    {
        for (int i=1 ;i<n; i++)
        {
            String temp = s[i];

            // Insert s[j] at its correct position
            int j = i - 1;
            while (j >= 0 && temp.length() < s[j].length())
            {
                s[j+1] = s[j];
                j--;
            }
            s[j+1] = temp;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0) {
            String a = sc.nextLine();
            String b = sc.nextLine();

            String small = a.length() <= b.length() ? a : b;
            String longStr = a.length() > b.length() ? a : b;
//            System.out.println(small);
//            System.out.println(longStr);

            String arr[] = findSubsequences(small);
//            System.out.println(Arrays.toString(arr));
//            if(small.length() <= 18) {
//                sort(arr, arr.length);
//            }

            Arrays.sort(arr, new java.util.Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    // TODO: Argument validation (nullity, length)
                    return s1.length() - s2.length();// comparision
                }
            });

//            System.out.println(Arrays.toString(arr));

            int indx = -1, maxCount = 0;
            for(int i = arr.length - 1; i > 0; i--) {
                int count = 0;
                indx = longStr.indexOf(arr[i]);
                if(indx != -1) {
//                    count = indx + (longStr.length() - (indx + small.length()));
                    if(small.length() > 0) {
                        count += small.length() - arr[i].length();
                    }
                    if(longStr.length() > 0) {
                        count += longStr.length() - arr[i].length();
                    }

                    maxCount = Math.max(maxCount, count);
//                    break;
                }
            }
            if(indx == -1 && maxCount == 0) {
                maxCount = longStr.length() + small.length();
            }

            System.out.println(maxCount);
        }

    }
}
