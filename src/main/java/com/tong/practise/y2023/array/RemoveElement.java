package com.tong.practise.y2023.array;


public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow++;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] nums = {1, 1, 1, 2, 3};
        int k = removeElement.removeElement(nums, 2);
        System.out.println(k);
    }

}
