package com.tong.practise.y2023.array;

public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        if (null == numbers || numbers.length == 0) {
            return new int[]{};
        }

        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] < target) {
                l++;
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }
        return new int[]{};
    }


    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        // 1, 2
        int[] result = twoSum.twoSum(numbers, target);
        System.out.println(result);
    }
}
