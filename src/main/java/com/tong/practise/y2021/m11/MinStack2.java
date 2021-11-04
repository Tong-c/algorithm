package com.tong.practise.y2021.m11;

public class MinStack2 {

    Node first;
    Node last;
    int min;

    public MinStack2() {

    }

    public void push(int val) {
        Node node = new Node(val);
        if (first == null) {
            min = val;
            first = node;
            last = node;
        } else {
            if (val < min) {
                min = val;
            }
            node.prev = last;
            last.next = node;
            last = node;
        }
    }

    public void pop() {
        if (null != last.prev) {
            last.prev.next = null;

            if (last.val == min) {
                min = first.val;
                Node curr = first;
                while (curr != null) {
                    int val = curr.val;
                    if (val < min) {
                        min = val;
                    }
                    curr = curr.next;
                }
            }

            last = last.prev;
        } else {
            first = null;
            last = null;
        }
    }

    public int top() {
        return last.val;
    }

    public int getMin() {
        return min;
    }


    static class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MinStack2 minStack2 = new MinStack2();
        minStack2.push(-2);
        minStack2.push(0);
        minStack2.push(-3);
        System.out.println(minStack2.getMin());
        minStack2.pop();
        System.out.println(minStack2.top());
        System.out.println(minStack2.getMin());
    }
}
