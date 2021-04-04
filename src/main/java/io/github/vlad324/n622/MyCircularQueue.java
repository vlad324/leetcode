package io.github.vlad324.n622;

/**
 * {@link "https://leetcode.com/problems/design-circular-queue/"}
 */
class MyCircularQueue {

    private final int[] queue;
    private int current;
    private int size;

    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.current = -1;
        this.size = 0;
    }

    public boolean enQueue(int value) {
        if (size >= queue.length) {
            return false;
        }

        current = (current + 1) % queue.length;
        queue[current] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (size == 0) {
            return false;
        }

        size--;
        return true;
    }

    public int Front() {
        if (size == 0) {
            return -1;
        }

        return queue[frontIndex()];
    }

    public int Rear() {
        if (size == 0) {
            return -1;
        }

        return queue[current];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    private int frontIndex() {
        final var i = current + 1 - size;
        if (i >= 0) {
            return i;
        } else {
            return queue.length + i;
        }
    }
}
