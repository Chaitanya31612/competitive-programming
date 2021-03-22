package queue_array;

public class QueueUsingArray {
    private int data[];
    private int front;
    private int rear;
    private int size;

    public QueueUsingArray() {
        data = new int[10];
        front = rear = -1;
        size = 0;
    }

    public QueueUsingArray(int capacity) {
        data = new int[capacity];
        front = rear = -1;
        size = 0;
    }

    public int size() {
        return  size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int front() throws QueueEmptyException {
        if(size == 0) {
            throw new QueueEmptyException();
        }
        return data[front];
    }

    public void enqueue(int element) throws QueueFullException {

        if(size == data.length) {

//            throw new QueueFullException();
            doubleCapacity();
        }

        if(isEmpty()) {
            front = 0;
        }

        size++;

        rear = (rear + 1) % data.length;
        // OR
//        rear++;
//        if(rear == data.length) {
//            // circular rotation
//            rear = 0;
//        }
        data[rear] = element;
    }

    private void doubleCapacity() {
        int[] temp = data;
        data = new int[2 * temp.length];

        int indx = 0;
        // copy elements with and after front
        for(int i = front; i < temp.length; i++) {
            data[indx++] = temp[i];
        }
        // copy upto front - 1;
        for(int i = 0; i <= front - 1; i++) {
            data[indx++] = temp[i];
        }

        // update front and rear
        front = 0;
        rear = temp.length - 1;
    }

    public int dequeue() throws QueueEmptyException {
        if(isEmpty()) {
            throw new QueueEmptyException();
        }

        int temp = data[front];
        front = (front + 1) % data.length;

//        front++;
//        if(front == data.length) {
//            front = 0;
//        }
        size--;
        if(isEmpty()) {
            front = rear = -1;
        }
        return temp;

    }

}
