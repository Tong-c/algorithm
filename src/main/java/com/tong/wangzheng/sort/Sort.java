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
        int length = nums.length;

        if (length <= 1) {
            System.out.println(Arrays.toString(nums));
            return;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int currUnOrder = nums[i];
                int currOrder = nums[j];
                if (currUnOrder < currOrder) {
                    swap(nums, i, j);
                    continue;
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 选择排序
     */
    public void selectSort(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            System.out.println(Arrays.toString(nums));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int indexOfMin = i;
            for (int j = i; j < nums.length - 1; j++) {
                if (nums[indexOfMin] > nums[j + 1]) {
                    indexOfMin = j + 1;
                }
            }
            swap(nums, i, indexOfMin);
        }

        System.out.println(Arrays.toString(nums));

    }


    /**
     * 归并排序
     */
    public void mergeSort(int[] nums) {
        int length = nums.length;
        int[] workSpace = new int[length];
        recMergeSort(nums, workSpace, 0, length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void recMergeSort(int[] nums, int[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(nums, workSpace, lowerBound, mid);
            recMergeSort(nums, workSpace, mid + 1, upperBound);
            merge(nums, workSpace, lowerBound, mid + 1, upperBound);
        }
    }

    private void merge(int[] nums, int[] workSpace, int lowPtr, int highPtr, int upperBound) {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;

        while (lowPtr <= mid && highPtr <= upperBound) {
            if (nums[lowerBound] < nums[highPtr]) {
                workSpace[j++] = nums[lowPtr++];
            } else {
                workSpace[j++] = nums[highPtr++];
            }
        }

        while (lowPtr <= mid) {
            workSpace[j++] = nums[lowPtr++];
        }

        while (highPtr <= upperBound) {
            workSpace[j++] = nums[highPtr++];
        }

        for (j = 0; j < n; j++) {
            nums[lowerBound + j] = workSpace[j];
        }

    }


    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    /**
     * 归并排序 2
     */
    public void mergeSort2(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            System.out.println(Arrays.toString(nums));
            return;
        }
        int[] workspace = new int[length];
        recMergeSort2(nums, workspace, 0, length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void recMergeSort2(int[] nums, int[] workspace, int lowerBound, int upperBound) {
        if (upperBound <= lowerBound) {
            return;
        }
        int mid = (upperBound + lowerBound) / 2;
        recMergeSort2(nums, workspace, lowerBound, mid);
        recMergeSort2(nums, workspace, mid + 1, upperBound);
        merge2(nums, workspace, lowerBound, mid, upperBound);
    }

    private void merge2(int[] nums, int[] workspace, int lowerBound, int mid, int upperBound) {
        int point1 = lowerBound;
        int point2 = mid + 1;
        int i = 0;
        while (point1 <= mid && point2 <= upperBound) {
            if (nums[point1] <= nums[point2]) {
                workspace[i++] = nums[point1];
                point1++;
            } else {
                workspace[i++] = nums[point2];
                point2++;
            }
        }

        while (point1 <= mid) {
            workspace[i++] = nums[point1];
            point1++;
        }

        while (point2 <= upperBound) {
            workspace[i++] = nums[point2];
            point2++;
        }

        for (int x = 0; x < i; x++) {
            nums[lowerBound + x] = workspace[x];
        }
    }

    /**
     * 归并排序 3
     *
     * @param nums
     */
    public void mergeSort3(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            System.out.println(Arrays.toString(nums));
        }

        int[] temp = new int[length];
        recMergeSort3(nums, temp, 0, length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void recMergeSort3(int[] nums, int[] temp, int left, int right) {
        if (right <= left) {
            return;
        }

        int middle = (left + right) / 2;
        recMergeSort3(nums, temp, left, middle);
        recMergeSort3(nums, temp, middle + 1, right);
        merge3(nums, temp, left, middle + 1, right);
    }

    private void merge3(int[] nums, int[] temp, int lowerBound, int middle, int upperBound) {
        int leftPointer = lowerBound;
        int rightPointer = middle;
        int i = 0;
        while (leftPointer <= middle - 1 && rightPointer <= upperBound) {
            if (nums[leftPointer] <= nums[rightPointer]) {
                temp[i++] = nums[leftPointer++];
            } else {
                temp[i++] = nums[rightPointer++];
            }
        }

        while (leftPointer <= middle - 1) {
            temp[i++] = nums[leftPointer++];
        }

        while (rightPointer <= upperBound) {
            temp[i++] = nums[rightPointer++];
        }

        for (int j = 0; j < i; j++) {
            nums[lowerBound + j] = temp[j];
        }
    }


    public static void main(String[] args) {
        int[] data = {3, 2, 1, 10, 4, 5, 4, 11, 8, 1, 8, 3};
        Sort sort = new Sort();
        sort.mergeSort3(data);
    }
}
