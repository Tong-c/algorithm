package com.tong.practise.y2023.array;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int k = nums.length;
        for (int i = 0; i < k - 1; i++) {
            int cur = nums[i];
            int next = nums[i + 1];
            if (cur == next) {
                k--;
                i--;
                for (int j = i + 1; j < nums.length; j++) {
                    if (j != nums.length - 1) {
                        nums[j] = nums[j + 1];
                    }
                }
            }
        }
        return k;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k = removeDuplicates.removeDuplicates(nums);
        System.out.println(k);
    }
}
