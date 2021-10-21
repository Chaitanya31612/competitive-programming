public class PriorityQueueUse {
    public static void main(String[] args) throws PriorityQueueException {
        Priority_Queue pq = new Priority_Queue();

        int[] arr = {10, 4, 20, 15, 35, 8, 5};

        for(int ele: arr) {
            pq.insert(ele);
        }

        while(!pq.isEmpty()) {
            System.out.println(pq.removeMin());
        }

    }
}
