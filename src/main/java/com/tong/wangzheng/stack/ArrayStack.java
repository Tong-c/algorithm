package com.tong.wangzheng.stack;

/**
 * 数组实现栈结构
 */
public class ArrayStack {

    private int[] items;
    private int count;

    public ArrayStack() {
        items = new int[10];
    }

    /**
     * 入栈
     */
    public void push(int item) {
        if (count == items.length) {
            return;
        }
        items[count] = item;
        count++;
    }

    /**
     * 出栈
     */
    public int pop() {
        if (count == 0) {
            return -1;
        }

        int item = items[count - 1];
        count--;
        return item;
    }


    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
