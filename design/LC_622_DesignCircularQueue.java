package design;

class MyCircularQueue {

    /*
     * TC: O(1) for all operations
     * SC: O(K) where K is the capacity of the queue
     */

    int[] queue;
    int currSize;
    int capacity;
    int frontPtr;
    int rearPtr;

    public MyCircularQueue(int k) {
        queue = new int[k];
        currSize = 0;
        capacity = k;
        frontPtr = 0;
        rearPtr = -1;
    }

    public boolean enQueue(int value) { // only move rearPtr in enQueue
        if (isFull()) {
            return false;
        }
        rearPtr = (rearPtr + 1) % capacity;
        queue[rearPtr] = value;
        currSize++;
        return true;
    }

    public boolean deQueue() { // only move frontPtr in deQueue
        if (isEmpty()) {
            return false;
        }
        frontPtr = (frontPtr + 1) % capacity;
        currSize--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[frontPtr];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[rearPtr];
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    public boolean isFull() {
        return currSize == capacity;
    }
}

public class LC_622_DesignCircularQueue {

    public static void main(String[] args) {

        MyCircularQueue queue = new MyCircularQueue(3);
        System.out.println(queue.enQueue(1)); // true
        System.out.println(queue.enQueue(2)); // true
        System.out.println(queue.enQueue(3)); // true
        System.out.println(queue.enQueue(4)); // false (queue is full)

        System.out.println(queue.Rear());     // 3
        System.out.println(queue.isFull());   // true

        System.out.println(queue.deQueue());  // true
        System.out.println(queue.enQueue(4)); // true

        System.out.println(queue.Rear());     // 4

        // Edge cases
        MyCircularQueue emptyQueue = new MyCircularQueue(2);
        System.out.println(emptyQueue.deQueue());  // false
        System.out.println(emptyQueue.Front());    // -1
        System.out.println(emptyQueue.Rear());     // -1

        System.out.println(emptyQueue.enQueue(10)); // true
        System.out.println(emptyQueue.enQueue(20)); // true
        System.out.println(emptyQueue.enQueue(30)); // false (full)
        System.out.println(emptyQueue.isFull());    // true
        System.out.println(emptyQueue.deQueue());   // true
        System.out.println(emptyQueue.Front());     // 20
    }
}
