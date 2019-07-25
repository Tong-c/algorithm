package com.tong.wangzheng.array;


/**
 * 合并两个有序数组，双指针从前往后
 */
public class MergeArray2 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 8};
        int[] nums2 = {2, 3, 4, 5, 6};

        int[] nums3 = new int[nums.length + nums2.length];
        int size = 0;


        for (int i = 0, j = 0; i < nums.length || j < nums2.length; ) {
            if (i > nums.length - 1) {
                nums3[size] = nums2[j];
                j++;
                size++;
                continue;
            }

            if (j > nums2.length - 1) {
                nums3[size] = nums[i];
                i++;
                size++;
                continue;
            }

            if (nums[i] <= nums2[j]) {
                nums3[size] = nums[i];
                size++;
                i++;
            } else if (nums[i] > nums2[j]) {
                nums3[size] = nums2[j];
                size++;
                j++;
            }
        }

        System.out.println(nums3);
    }
}
