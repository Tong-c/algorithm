package com.tong.wangzheng.linkedlist;


/**
 * 单向循环链表
 */
public class LoopSinglyLinkedlist {

    private Node head;
    private Node tail;
    int size;

    public LoopSinglyLinkedlist() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * 头部插入节点
     */
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (size == 0) {
            newNode.next = newNode;
            head = newNode;
            tail = newNode;
            size++;
        } else {
            tail.next = newNode;
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    /**
     * 尾部插入节点
     */
    public void addTail(int data) {
        Node newNode = new Node(data);
        if (size == 0) {
            newNode.next = newNode;
            head = newNode;
            tail = newNode;
            size++;
        } else {
            tail.next = newNode;
            tail = newNode;
            newNode.next = head;
            size++;
        }
    }


    /**
     * 删除节点
     */
    public void deleteNodeByValue(int data) {
        Node currNode = head;
        Node prev = head;
        while (currNode.next != head) {
            int currData = currNode.data;
            if (currData == data) {
                if (currNode == head) {//头节点删除
                    head = currNode.next;
                    prev = head;
                    currNode = head;
                } else {
                    prev.next = currNode.next;
                    currNode = currNode.next;
                }
                size--;
            } else {
                prev = currNode;
                currNode = currNode.next;
            }
        }
        if (currNode.data == data) {//尾节点删除
            prev.next = head;
            size--;
        }
    }


    static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }


    public static void main(String[] args) {
        LoopSinglyLinkedlist list = new LoopSinglyLinkedlist();
        list.addTail(2);
        list.addTail(3);
        list.addTail(7);
        list.deleteNodeByValue(7);
        System.out.println(list);
    }
}
