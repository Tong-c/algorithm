package com.tong.practise.y2021.m11;


import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleArea3 {

    public static int largestRectangleArea(int[] heights) {
        int area = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] newHeights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++) {
            newHeights[i] = heights[i - 1];
        }

        for (int i = 0; i < newHeights.length; i++) {
            int curr = newHeights[i];
            while (!stack.isEmpty() && newHeights[stack.peek()] > curr) {
                Integer topIndex = stack.pop();
                int currArea = newHeights[topIndex] * (i - stack.peek() - 1);
                if (area < currArea) {
                    area = currArea;
                }
            }
            stack.push(i);
        }
        return area;
    }


    public static void main(String[] args) {
        int[] heights = {1, 1, 1};
        System.out.println(largestRectangleArea(heights));
    }
}
