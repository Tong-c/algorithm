package com.tong.wangzheng.queue;

/**
 * 数组实现队列结构
 */
public class ArrayQueue {

    private int[] items;
    private int count;
    private int head;
    private int tail;

    public ArrayQueue() {
        this.items = new int[5];
    }

    /**
     * 入队
     */
    public void enqueue(int item) {
        if (count == items.length) {//队列已满
            return;
        }

        if (head == 0 && tail == items.length) {
            tail = 0;
        }


        if (tail == items.length && tail != head) {//触发搬移操作
            for (int i = 0; i < tail - head; i++) {
                items[i] = items[i + head];
            }
            tail = tail - head;
            head = 0;
        }

        items[tail] = item;
        tail++;
        count++;
    }


    /**
     * 出队
     */
    public int dequeue() {
        if (head == tail && count == 0) {//队列为空
            return -1;
        }
        int item = items[head];
        head++;
        count--;
        if (head == items.length) {
            head = 0;
        }
        return item;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        queue.enqueue(11);
        System.out.println(queue.dequeue());
        queue.enqueue(12);
        queue.enqueue(13);
    }

}
