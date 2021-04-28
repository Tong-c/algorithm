package com.tong.practise.y2021.m04;

public class Sort {

    /**
     * 快速排序
     *
     * @param nums 待排序数组
     * @return 排序后数组
     */
    public int[] quickSort(int[] nums) {
        recQuickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void recQuickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        long pivot = nums[right];
        int partition = partition(nums, left, right, pivot);
        recQuickSort(nums, left, partition - 1);
        recQuickSort(nums, partition + 1, right);
    }

    private int partition(int[] nums, int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            while (nums[++leftPtr] < pivot) {

            }

            while (rightPtr > 0 && nums[--rightPtr] > pivot) {

            }

            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(nums, leftPtr, rightPtr);
            }
        }
        swap(nums, leftPtr, right);
        return leftPtr;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    /**
     * 归并排序
     *
     * @param nums 待排序数组
     * @return 排序后数组
     */
    public int[] mergeSort(int[] nums) {
        int[] workspace = new int[nums.length];
        recMergeSort(workspace, nums, 0, nums.length -1);
        return nums;
    }

    private void recMergeSort(int[] workspace, int[] nums, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        }
        int mid = (upperBound - lowerBound) / 2;
        recMergeSort(workspace, nums, lowerBound, mid);
        recMergeSort(workspace, nums, mid + 1, upperBound);
        merge(workspace, nums, lowerBound, mid, upperBound);
    }

    private void merge(int[] workspace, int[] nums, int lowerBound, int mid, int upperBound) {
        int lowPtr = lowerBound;
        int highPtr = mid + 1;
        int i = 0;
        while (lowPtr <= mid && highPtr <= upperBound) {
            if (nums[lowPtr] <= nums[highPtr]) {
                workspace[i++] = nums[lowPtr++];
            } else {
                workspace[i++] = nums[highPtr++];
            }
        }

        while (lowPtr <= mid) {
            workspace[i++] = nums[lowPtr++];
        }

        while (highPtr <= upperBound) {
            workspace[i++] = nums[highPtr++];
        }

        for (int j = 0; j < i; j++) {
            nums[lowerBound + j] = workspace[j];
        }

    }


    /**
     * 堆排序
     *
     * @param nums 待排序数组
     * @return 排序后数组
     */
    public int[] heapSort(int[] nums) {
        // 构造大顶堆
        heapInsert(nums);
        int size = nums.length;
        while (size > 1) {
            // 固定最大值
            swap(nums, 0, size - 1);
            size--;
            // 构造大顶堆
            heapify(nums, 0, size);
        }
        return nums;
    }

    // 将剩余的数构造成大顶堆
    private void heapify(int[] nums, int index, int size) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        while (left < size) {
            int largestIndex;
            // 判断孩子中较大值的索引（要确保右孩子在 size 范围之内）
            if (nums[left] < nums[right] && right < size) {
                largestIndex = right;
            } else {
                largestIndex = left;
            }
            // 比较父节点的值与子节点中较大的值，并确定最大值的索引
            if (nums[index] > nums[largestIndex]) {
                largestIndex = index;
            }

            // 如果父节点索引是最大值的索引，那已经是大顶堆了，则退出循环
            if (index == largestIndex) {
                break;
            }

            // 父节点不是最大值，与孩子中较大的值交换
            swap(nums, largestIndex, index);
            // 将索引指向子节点中较大的值的索引
            index = largestIndex;
            // 重新计算交换之后的孩子的索引
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
    }

    private void heapInsert(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 当前插入的索引
            int currentIndex = i;
            // 父节点索引
            int fatherIndex = (currentIndex - 1) / 2;
            // 如果当前插入的值大于其父节点的值，则交换值，并且将索引指向父节点
            // 然后继续和上面的父节点值比较，直到不大于父节点，退出循环
            while (nums[currentIndex] > nums[fatherIndex]) {
                // 交换当前节点与父节点的值
                swap(nums, currentIndex, fatherIndex);
                // 将当前索引指向父索引
                currentIndex = fatherIndex;
                // 重新计算当前索引的父索引
                fatherIndex = (currentIndex - 1) / 2;
            }
        }
    }


}
