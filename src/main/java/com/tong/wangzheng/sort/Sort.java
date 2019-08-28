package com.tong.wangzheng.sort;

import java.util.Arrays;

/**
 * 排序
 */
public class Sort {

    /**
     * 冒泡排序
     */
    public void bubbleSort(int[] nums) {
        int length = nums.length;

        if (length <= 1) {
            return;
        }

        for (int i = 0; i < length; i++) {
            boolean flag = true;
            for (int j = 0; j < length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = false;
                    swap(nums, j, j + 1);
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 插入排序
     */
    public void insertSort(int[] nums) {
        
    }


    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public static void main(String[] args) {
        int[] data = {1};
        Sort sort = new Sort();
        sort.bubbleSort(data);
    }
}
