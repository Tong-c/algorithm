package com.tong.practise.y2021.m04;

public class Search1 {

    /**
     * 搜索区间
     *
     * @param nums:   an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int start = 0;
        int end = nums.length - 1;
        int lowerBound = -1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                if (lowerBound == -1) {
                    lowerBound = mid;
                } else {
                    if (mid < lowerBound) {
                        lowerBound = mid;
                    }
                }
            }
            end = mid - 1;

        }
        if (nums[start] == target) {
            lowerBound = start;
        }

        start = lowerBound == -1 ? 0 : lowerBound;
        end = nums.length - 1;
        int higerBound = -1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                if (higerBound == -1) {
                    higerBound = mid;
                } else {
                    if (mid > higerBound) {
                        higerBound = mid;
                    }
                }
            }
            start = mid + 1;
        }
        if (nums[end] == target) {
            higerBound = end;
        }
        if (lowerBound == -1 && higerBound == -1) {
            return new int[]{-1, -1};
        }else {
            return new int[]{lowerBound == -1 ? higerBound : -1, higerBound == -1 ? lowerBound : -1};
        }
    }


    public static void main(String[] args) {
        Search1 search1 = new Search1();
        search1.searchRange(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 9);
    }
}
