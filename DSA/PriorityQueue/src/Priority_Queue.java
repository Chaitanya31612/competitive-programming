import java.util.ArrayList;

public class Priority_Queue {
    // Minimum Priority Queue

    private ArrayList<Integer> heap;

    public Priority_Queue() {
        heap = new ArrayList<>();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int size() {
        return heap.size();
    }

    public int getMin() throws PriorityQueueException {
        if(isEmpty()) {
            // throw exception
            throw new PriorityQueueException();
        }
        return heap.get(0);
    }

    public void insert(int element) {
        // insert at the end of the array and then run upward heapify
        heap.add(element);


        // up-heapify
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while(childIndex > 0) {
            if(heap.get(childIndex) < heap.get(parentIndex)) {
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
            } else {
                return;
            }
        }
    }

    public int removeMin() throws PriorityQueueException {
        if(isEmpty()) {
            // throw exception
            throw new PriorityQueueException();
        }
        int removedItem = heap.get(0);

        heap.set(0, heap.get(size() - 1));
        heap.remove(size() - 1);

        int parentIndex = 0, leftChildIndex, rightChildIndex;

        while(parentIndex < size()) {
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;
            int minIndex = parentIndex;

            if(leftChildIndex >= size()) {
                break;
            } else {
                if(heap.get(leftChildIndex) < heap.get(minIndex)) {
                    minIndex = leftChildIndex;
                }
            }
            if(rightChildIndex < size()) {
                if(heap.get(rightChildIndex) < heap.get(minIndex)) {
                    minIndex = rightChildIndex;
                }
            }

            if(minIndex == parentIndex) {
                break;
            }

            int temp = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(minIndex));
            heap.set(minIndex, temp);
            parentIndex = minIndex;
        }

        return removedItem;
    }

}
