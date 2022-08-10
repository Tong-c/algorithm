package com.tong.practise.y2022.m08;

public class MajorityElement3 {

    public int majorityElement(int[] nums) {
        int startNum = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (startNum == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    startNum = nums[i];
                    count = 1;
                }
            }
        }
        return startNum;
    }

    public static void main(String[] args) {
        MajorityElement3 tester = new MajorityElement3();
        int[] nums = {2, 2, 2, 1, 1, 2, 2, 1, 2, 2, 3, 3, 3};
        System.out.println(tester.majorityElement(nums));
    }
}
