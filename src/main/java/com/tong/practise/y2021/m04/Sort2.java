package com.tong.practise.y2021.m04;

public class Sort2 {

    /**
     * 堆排序
     *
     * @param nums 待排序数组
     * @return 已排序数组
     */
    public int[] heapSort(int[] nums) {
        buildHeap(nums);
        int size = nums.length;
        while (size > 1) {
            swap(nums, 0, size - 1);
            size--;
            heapify(nums, 0, size);
        }
        return nums;
    }

    private void heapify(int[] nums, int index, int size) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        while (left < size) {
            int largerIndex;
            if (nums[left] < nums[right] && right < size) {
                largerIndex = right;
            } else {
                largerIndex = left;
            }
            if (nums[index] > nums[largerIndex]) {
                break;
            }
            swap(nums, index, largerIndex);
            index = largerIndex;
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
    }

    private void buildHeap(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int currIndex = i;
            int fatherIndex = (i - 1) / 2;
            while (nums[currIndex] > nums[fatherIndex]) {
                swap(nums, currIndex, fatherIndex);
                currIndex = fatherIndex;
                fatherIndex = (fatherIndex - 1) / 2;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
