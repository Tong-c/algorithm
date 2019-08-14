package com.tong.wangzheng.queue;

/**
 * 循环队列
 */
public class CircleQueue3 {
    private int[] items;
    private int head;
    private int tail;
    private int count;

    public CircleQueue3() {
        items = new int[5];
        head = 0;
        tail = 0;
        count = 0;
    }

    /**
     * 入队
     */
    public void enqueue(int data) {
        if (count == items.length) {
            return;
        }

        items[tail] = data;
        tail = (tail + 1) % items.length;
        count++;
    }

    /**
     * 出队
     */
    public int dequeue() {
        if (count == 0) {
            return -1;
        }

        int removeData = items[head];

        head = (head + 1) % items.length;
        count--;
        return removeData;
    }


}
