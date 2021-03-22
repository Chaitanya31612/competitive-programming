package queue_ll;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCollection {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.poll();
        queue.peek();
        queue.isEmpty();
        
    }
}
