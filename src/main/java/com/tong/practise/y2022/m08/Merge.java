package com.tong.practise.y2022.m08;

public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            int currNums1 = nums1[i];
            int currNums2 = nums2[j];
            if (currNums1 < currNums2) {
                nums1[k] = currNums2;
                j--;
                k--;
            } else {
                nums1[k] = currNums1;
                i--;
                k--;
            }
        }

        if (j >= 0) {
            for (int temp = 0; temp <= j; temp++) {
                nums1[temp] = nums2[temp];
            }
        }

    }


    public static void main(String[] args) {
        Merge tester = new Merge();
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        tester.merge(nums1, m, nums2, n);
        System.out.println("============");
    }
}
