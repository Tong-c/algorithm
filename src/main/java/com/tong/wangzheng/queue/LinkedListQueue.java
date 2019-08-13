package com.tong.wangzheng.queue;

/**
 * 链表实现队列结构
 */
public class LinkedListQueue {
    private Node head;
    private Node tail;
    private int count;

    public LinkedListQueue() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * 入队
     */
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }

        if (tail == null) {
            tail = newNode;
        }

        tail.next = newNode;
        tail = newNode;
        count++;
    }

    /**
     * 出队
     */
    public int dequeue() {
        if (head == null || tail == null) {
            return -1;
        }

        Node removeNode = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        count--;
        return removeNode.data;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }


        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue);
    }
}
