import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxArraySumKNeg {


    static int maximumSum(int arr[], int n, int k)
    {
        // Modify array K number of times
        for (int i = 1; i <= k; i++)
        {
            int min = +2147483647;
            int index = -1;

            // Find minimum element in array for
            // current operation and modify it
            // i.e; arr[j] --> -arr[j]
            for (int j = 0; j < n; j++)
            {
                if (arr[j] < min)
                {
                    min = arr[j];
                    index = j;
                }
            }

            // this the condition if we find 0 as
            // minimum element, so it will useless to
            // replace 0 by -(0) for remaining operations
            if (min == 0)
                break;

            // Modify element of array
            arr[index] = -arr[index];
        }
        // Calculate sum of array
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];
        return sum;
    }


    static int sol(int arr[], int k)
    {
        // Sorting given array using in-built
        // java sort function
        Arrays.sort(arr);
        int sum = 0;

        int i = 0;
        while (k > 0)
        {
            // If we find a 0 in our
            // sorted array, we stop
            if (arr[i] == 0)
                k = 0;

            else
            {
                arr[i] = (-1) * arr[i];
                k = k - 1;
            }

            i++;
        }

        // Calculating sum
        for (int j = 0; j < arr.length; j++)
        {
            sum += arr[j];
        }
        return sum;
    }

    static long maxsol(int[] a, int n, int k) {
        Arrays.sort(a);

        int i = 0;
        while(k > 0) {
            if(i == a.length) {
                i = 0;
            }
            if(a[i] < 0) {
                a[i] = (-1) * a[i];
                k--;
            }

            else if(a[i] == 0) {
                k = 0;
            }
            else if(a[i] > 0){
                if((k&1)==0) {
                    k = 0;
                } else {
                    a[i] = (-1) * a[i];
                    k = 0;
                }
            }

            i++;
        }

        long sum =0;
        for(long x : a) {
            sum += x;
        }
        return sum;
    }

    static int maxSum(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : arr) {
            pq.add(x);
        }

        while (k-- > 0)
        {
            // Retrieve and remove min element
            int temp = pq.poll();
            System.out.println(temp);

            // Modify the minimum element and add back
            // to priority queue
            temp *= -1;
            pq.add(temp);
            System.out.println(pq);
        }

        int sum = 0;
        for (int x : pq)
            sum += x;
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 0, 5, -1, 2};
        int k = 4;
//        System.out.println(maxSum(arr, k));

        int[] a = {1,2,3,4,5};
        System.out.println(maxSum(a, 5));
    }
}
