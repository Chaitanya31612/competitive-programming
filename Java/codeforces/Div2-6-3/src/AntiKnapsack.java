import java.util.Scanner;

public class AntiKnapsack {

    static int lengtharr(int[] arr) {
        int i = 0, length = 0;
        while(i < arr.length && arr[i] != 0) {
            length++;
            i++;
        }

        return length;
    }

    static boolean checksum(int[] arr, int k) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if(sum == k || sum == 0) {
            return false;
        } else {
            return true;
        }
    }

    static void printSubsets(int set[], int k)
    {
        int n = set.length;

        int count = 0;
        for (int i = 0; i < (1<<n); i++)
        {

            int[] temp = new int[n];
            int ind = 0;
            for (int j = 0; j < n; j++) {
                if (((i & (1 << j)) > 0)) {
//                    System.out.print(set[j] + " ");
                    temp[ind++] = set[j];
                }

            }
            if(checksum(temp, k)) {
                count++;
//                System.out.println(Arrays.toString(temp));
//                return;
            }
            if(count > 0) {
                int a = 0;
                System.out.println(lengtharr(temp));
                while (a < temp.length && temp[a] != 0) {
                    System.out.print(temp[a] + " ");
                    a++;
                }
                System.out.println();
                return;
            }

        }
         if(count == 0) {
            System.out.println(0);
            return;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] arr = new int[n];

            int indx = 0;
            for(int i = 0; i < n; i++) {
                arr[i] = i+1;
            }
            printSubsets(arr, k);
        }
    }
}
