import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueInbuilt {

    static class MaxPQComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];

        int[] arr = {2, 4, 1, 9, 6, 8};
        MaxPQComparator maxPQComparator = new MaxPQComparator();
        // by default priority queue in collections class create minheap
        PriorityQueue<Integer> pq = new PriorityQueue<>(maxPQComparator);

        // without using custom comparator, we can use Collections.reverseOrder() which gives similar comparator
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int j : arr) {
            pq.add(j);
        }

        System.out.println(pq.element());
        System.out.println(pq.peek());

        while(!pq.isEmpty()) {
            System.out.print(pq.remove() + " ");
        }

    }
}
