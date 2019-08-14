package com.tong.wangzheng.queue;


/**
 * 数组实现循环队列
 */
public class CircleQueue {
    private int[] items;
    private int count;
    private int head;
    private int tail;

    public CircleQueue() {
        items = new int[5];
        count = 0;
        head = 0;
        tail = 0;
    }

    /**
     * 入队
     */
    public void enqueue(int data) {

        if (count == items.length) {//队列已满
            return;
        }

        if (tail == items.length && head > 0) {//从头部重新添加元素
            tail = 0;
        }

        items[tail] = data;
        count++;
        tail++;

        if (tail == items.length && head > 0) {//从头部重新添加元素
            tail = 0;
        }

    }


    /**
     * 出队
     */
    public int dequeue() {
        if (head == tail && count == 0) {//队列为空
            return -1;
        }

        if (head == items.length - 1 && tail > 0) {
            head = 0;
        }

        int removeData = items[head];
        count--;
        head++;

        if (head == items.length - 1 && tail > 0) {
            head = 0;
        }
        return removeData;
    }


    public int Front() {
        return items[head];
    }

    public int Rear() {
        return items[tail - 1];
    }

    public boolean isEmpty() {
        if (head == tail && count == 0) {//队列为空
            return true;
        }

        return false;
    }

    public boolean isFull() {
        if (count == items.length) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue();
        queue.enqueue(1);
        queue.dequeue();
        queue.enqueue(2);
        queue.enqueue(9);
        queue.dequeue();
        queue.isFull();
        queue.isFull();
        queue.Front();
        queue.dequeue();
        queue.enqueue(3);
        queue.Front();
    }


}
