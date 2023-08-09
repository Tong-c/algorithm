package com.tong.practise.y2023.array;

public class RemoveDuplicates2 {

    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int slow = 0;
        int fast = 0;

        for (fast = 0; fast < nums.length; fast++) {
            if (fast != slow) {
                if (nums[fast] != nums[slow]) {
                    slow++;
                    nums[slow] = nums[fast];
                }
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates2 removeDuplicates = new RemoveDuplicates2();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k = removeDuplicates.removeDuplicates(nums);
        System.out.println(k);
    }
}
