package com.tong.practise.y2022.m08;

public class ProductExceptSelf2 {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = 1;
            } else {
                result[i] = result[i - 1] * nums[i - 1];
            }
        }

        int tmp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                tmp = 1;
            } else {
                tmp = tmp * nums[i + 1];
            }
            result[i] = result[i] * tmp;
        }

        return result;
    }

    public static void main(String[] args) {
        ProductExceptSelf2 tester = new ProductExceptSelf2();
        int[] nums = {1, 2, 3, 4};
        int[] result = tester.productExceptSelf(nums);
        System.out.println("============" + result);
    }
}
