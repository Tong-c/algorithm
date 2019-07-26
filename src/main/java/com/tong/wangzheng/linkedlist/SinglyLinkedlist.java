package com.tong.wangzheng.linkedlist;

/**
 * 单链表
 */
public class SinglyLinkedlist {

    private Node head = null;
    private Node;


    /**
     * 从头部插入
     *
     * @param newNode
     */
    public void addToHead(Node newNode) {
        newNode.next = head;
        head = newNode;
    }

    /**
     * 从尾部插入
     */
    public void addToTail(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            newNode.next = node.next;
            node.next = newNode;
        }
    }

    /**
     * 根据数值，删除节点
     *
     * @param data
     * @return
     */
    public Node deleteByValue(int data) {
        Node current = head;
        Node previous = head;

        while (current.getData() != data) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }

        if (current == head) {
            head = head.next;
        } else {
            previous.next = current.next;
        }

        return current;
    }

    /**
     * 根据数值，查找节点
     *
     * @param data
     * @return
     */
    public Node findByValue(int data) {
        Node currNode = head;
        while (currNode.getData() != data) {
            if (currNode.getNext() == null) {
                return null;
            }
            currNode = currNode.next;
        }
        return currNode;
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
        SinglyLinkedlist list = new SinglyLinkedlist();
        list.addToHead(new Node(6));
        list.addToHead(new Node(8));
        list.addToHead(new Node(9));
        System.out.println(list);
    }

}
