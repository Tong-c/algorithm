package com.tong.wangzheng.queue;

/**
 * 循环队列
 */
public class CircleQueue2 {
    private int[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public CircleQueue2(int capacity) {
        items = new int[capacity];
        n = capacity;
    }

    /**
     * 入队
     */
    public boolean enqueue(int item) {
        if ((tail + 1) % n == head) return false;
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    /**
     * 出队
     */
    public int dequeue() {
        if (head == tail) {
            return -1;
        }

        int ret = items[head];
        head = (head + 1) % n;
        return ret;
    }

}
