package com.tong.practise.y2023.array;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }

        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                if (nums[slow] != 0) {
                    slow++;
                    fast++;
                } else {
                    int tmp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = tmp;
                    slow++;
                    fast++;
                }
            } else {
                fast++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {1, 2, 1, 0, 0, 2};
        moveZeroes.moveZeroes(nums);
        System.out.println(nums);
    }
}
