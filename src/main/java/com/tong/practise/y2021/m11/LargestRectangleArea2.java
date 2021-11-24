package com.tong.practise.y2021.m11;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LargestRectangleArea2 {


    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] newHeights = new int[heights.length + 2];

        for (int i = 1; i < heights.length + 1; i++) {
            newHeights[i] = heights[i - 1];
        }

        System.out.println(Arrays.toString(newHeights));

        for (int i = 0; i < newHeights.length; i++) {
            System.out.println("栈弹出前:" + stack.toString());
            while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {
                int curr = stack.pop();
                System.out.println("栈弹出后:" + stack.toString());
                System.out.println("面积为:" + (i - stack.peek() - 1) * newHeights[curr]);
                res = Math.max(res, (i - stack.peek() - 1) * newHeights[curr]);
            }
            stack.push(i);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        System.out.println(largestRectangleArea(arr));
    }
}
