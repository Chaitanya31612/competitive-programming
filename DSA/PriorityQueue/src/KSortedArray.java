import java.util.PriorityQueue;

public class KSortedArray {

    public static void sortKSorted(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i = 0;
        // Put first k elements into the priority queue
        for(; i < k; i++) {
            pq.add(arr[i]);
        }

        // find the min element and enter it on [i-k] location and enter k+1 th element which is ith into the priority queue
        for(; i < arr.length; i++) {
            arr[i - k] = pq.remove();
            pq.add(arr[i]);
        }

        // remove in increasing order the k elements left in the priority queue
        for(int j = arr.length - k; j < arr.length; j++) {
            arr[j] = pq.remove();
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 9, 6, 8};

        sortKSorted(arr, 3);

        for(int j: arr) {
            System.out.println(j + " ");
        }
    }
}
