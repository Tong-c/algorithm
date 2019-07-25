package com.tong.wangzheng.linkedlist;

/**
 * 单链表
 */
public class SinglyLinkedlist {

    private Node head;

    public void add(Node node) {
        if (head.next == null) {
            head.next = node;
        } else {
            node.next = head.next;
            head.next = node;
        }

    }


    class Node {
        int data;
        Node next;

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
    }

}
