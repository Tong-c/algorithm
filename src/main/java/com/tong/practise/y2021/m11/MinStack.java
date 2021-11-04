package com.tong.practise.y2021.m11;

public class MinStack {

    int[] nums;
    int length;
    int capacity;
    int min;

    public MinStack() {
        length = 10;
        nums = new int[length];
    }

    public void push(int val) {
        if (capacity == 0) {
            min = val;
        } else {
            if (val < min) {
                min = val;
            }
        }
        if (capacity == length) {
            nums = resize(nums);
        }
        nums[capacity] = val;
        capacity++;
    }

    private int[] resize(int[] nums) {
        int[] newNums = new int[length * 2];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
        }
        length = length * 2;
        return newNums;
    }

    public void pop() {
        int topNum = nums[capacity - 1];
        nums[capacity - 1] = 0;
        capacity--;
        if (topNum == min) {
            min = getMin(nums);
        }
    }

    private int getMin(int[] nums) {
        int currMin = 0;
        for (int i = 0; i < capacity; i++) {
            if (i == 0) {
                currMin = nums[i];
            } else {
                if (currMin > nums[i]) {
                    currMin = nums[i];
                }
            }
        }
        return currMin;
    }

    public int top() {
        return nums[capacity - 1];
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.push(0);
        System.out.println(minStack.getMin());
    }
}
