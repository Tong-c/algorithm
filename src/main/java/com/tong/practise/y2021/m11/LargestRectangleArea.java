package com.tong.practise.y2021.m11;

public class LargestRectangleArea {

    /**
     * 暴力法，超时
     */
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if (i == 0) {
                max = getCurrArea(i, heights);
            } else {
                int currArea = getCurrArea(i,  heights);
                if (max < currArea) {
                    max = currArea;
                }
            }
        }
        return max;
    }

    private int getCurrArea(int index, int[] heights) {
        int currArea = 0;
        int currHeight = heights[index];
        int length = heights.length;
        for (int i = index; i >= 0; i--) {
            if (heights[i] >= currHeight) {
                currArea = currArea + currHeight;
            } else {
                break;
            }
        }

        for (int i = index + 1; i < length; i++) {
            if (heights[i] >= currHeight) {
                currArea = currArea + currHeight;
            } else {
                break;
            }
        }
        return currArea;
    }

}
