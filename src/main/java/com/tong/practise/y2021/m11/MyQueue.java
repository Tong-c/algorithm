package com.tong.practise.y2021.m11;

import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {

    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> queue = new ArrayDeque<>();

    public MyQueue() {

    }

    public void push(int x) {

        while (!queue.isEmpty()) {
            stack.push(queue.pop());
        }
        stack.push(x);
        while (!stack.isEmpty()) {
            queue.push(stack.pop());
        }
    }

    public int pop() {
        return queue.pop();
    }

    public int peek() {
        Integer top = queue.peek();
        if (null == top) {
            return 0;
        }
        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
    }


    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}

