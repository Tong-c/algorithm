package com.tong.wangzheng.linkedlist;


/**
 * 双向链表
 */
public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * 头部添加数据
     */
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    /**
     * 尾部添加数据
     */
    public void addTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    /**
     * 删除指定数据的节点
     */
    public void deleteNodeByData(int data) {
        Node curr = head;
        Node prev = null;
        while (curr.next != null) {//有后续节点
            if (curr.data == data) {
                if (curr == head) {//首节点
                    head = curr.next;
                    curr = curr.next;
                } else {//非首节点
                    prev.next = curr.next;
                    curr.next.prev = prev;
                    curr = curr.next;
                }
            } else {//指针向后移动
                prev = curr;
                curr = curr.next;
            }
        }

        if (head == tail) {
            if (curr.data == data) {//单节点头部
                head = null;
                tail = null;
            }
        }

        if (head != tail) {
            if (curr.data == data) {//非单节点尾部
                prev.next = null;
                tail = prev;
            }
        }

    }


    static class Node {
        private int data;
        private Node next;
        private Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
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

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }


    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(8);
        System.out.println(list);

        DoublyLinkedList list2 = new DoublyLinkedList();
        list2.addTail(3);
        list2.addTail(8);
        list2.addTail(9);
        System.out.println(list2);

        list2.deleteNodeByData(8);
        list2.deleteNodeByData(9);
        list2.deleteNodeByData(3);
        System.out.println(list2);
    }

}
