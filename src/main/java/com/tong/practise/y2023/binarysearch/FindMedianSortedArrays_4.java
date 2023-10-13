package com.tong.practise.y2023.binarysearch;

public class FindMedianSortedArrays_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        int[] newArr = new int[nums1.length + nums2.length];
        int startIndex = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] <= nums2[p2]) {
                newArr[startIndex++] = nums1[p1++];
            } else {
                newArr[startIndex++] = nums2[p2++];
            }
        }

        if (p1 < nums1.length) {
            while (p1 < nums1.length) {
                newArr[startIndex++] = nums1[p1++];
            }
        }

        if (p2 < nums2.length) {
            while (p2 < nums2.length) {
                newArr[startIndex++] = nums2[p2++];
            }
        }

        if (newArr.length % 2 == 0) {
            int mid = newArr.length / 2;
            return (double) (newArr[mid - 1] + newArr[mid]) / 2;
        } else {
            return (double) newArr[newArr.length / 2] / 2;
        }
    }

    public static void main(String[] args) {
        FindMedianSortedArrays_4 tester = new FindMedianSortedArrays_4();
        int[] nums1 = {1, 2};
        int[] nums2 = {3};
        System.out.println(tester.findMedianSortedArrays(nums1, nums2));
    }
}
