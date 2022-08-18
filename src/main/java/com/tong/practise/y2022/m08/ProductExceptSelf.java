package com.tong.practise.y2022.m08;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int p = 1, q = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = p;
            p *= nums[i];
        }

        for (int i = nums.length - 1; i > 0; i--) {
            q *= nums[i];
            result[i - 1] *= q;
        }
        return result;
    }

    public static void main(String[] args) {
        ProductExceptSelf tester = new ProductExceptSelf();
        int[] nums = {1, 2, 3, 3, 4, 5};
        int[] result = tester.productExceptSelf(nums);
        System.out.println("============" + result);
    }
}
