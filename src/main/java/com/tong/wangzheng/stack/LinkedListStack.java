package com.tong.wangzheng.stack;


/**
 * 链表实现栈结构
 */
public class LinkedListStack {

    private Node head;
    private int count;

    public LinkedListStack() {

    }

    /**
     * 入栈
     */
    public void push(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        count++;
    }


    /**
     * 出栈
     */
    public int pop() {
        if (count == 0) {
            return -1;
        }

        Node currNode = head;
        head = head.next;
        count--;
        return currNode.data;
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
        LinkedListStack stack = new LinkedListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }


}
