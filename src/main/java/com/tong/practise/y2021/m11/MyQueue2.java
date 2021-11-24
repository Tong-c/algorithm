package com.tong.practise.y2021.m11;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue2 {

    private Deque<Integer> stack;
    private Deque<Integer> queue;

    public MyQueue2() {
        stack = new ArrayDeque<>();
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        if (queue.isEmpty()) {
            while (!stack.isEmpty()) {
                queue.push(stack.pop());
            }
        }
        return queue.pop();
    }

    public int peek() {
        if (queue.isEmpty()) {
            while (!stack.isEmpty()) {
                queue.push(stack.pop());
            }
        }
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty() && stack.isEmpty();
    }

}
